package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.base.DeviceBean;
import com.pony.sc_home_personal.bean.base.EditionBean;
import com.pony.sc_home_personal.bean.base.ScenarioDeviceFunctionBean;
import com.pony.sc_home_personal.bean.base.WarnSettingBean;
import com.pony.sc_home_personal.bean.response.HouseCustomerListBean;
import com.pony.sc_home_personal.bean.response.ScenarioFunctionListBean;
import com.pony.sc_home_personal.bean.response.WarnDeviceFunctionListBean;
import com.pony.sc_home_personal.bean.util.DelayMessageBean;
import com.pony.sc_home_personal.bean.util.MessageBean;
import com.pony.sc_home_personal.common.Constant;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ResultStatus;
import com.pony.sc_home_personal.common.ViewBean;
import com.pony.sc_home_personal.service.ImageFeign;
import com.pony.sc_home_personal.service.communication.CommunicationFeign;
import com.pony.sc_home_personal.service.personal.*;
import com.pony.sc_home_personal.socket.WebSocketServer;
import com.pony.sc_home_personal.util.ByteUtil;
import com.pony.sc_home_personal.util.PathUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wenxufeng
 * @date 2019/12/6 13:42
 **/
@Component
public class CommunicationFacadeImpl implements CommunicationFacade {

    @Resource
    private CommunicationFeign communicationFeign;
    @Resource
    private WarnFeign warnFeign;
    @Resource
    private ScenarioFeign scenarioFeign;
    @Resource
    private RecordManageFeign recordManageFeign;
    @Resource
    private IflyosFeign iflyosFeign;
    @Resource
    private DeviceManageFeign deviceManageFeign;
    @Resource
    private HouseCustomerFeign houseCustomerFeign;
    @Resource
    private EditionFeign editionFeign;
    @Resource
    private ImageFeign imageFeign;

    @Override
    public ResponseResult sendStudyMessage(long userId, int userType, String mac, int functionType, int type) {
        ViewBean viewBean = new ViewBean();
        communicationFeign.sendMessage(new MessageBean(
                0L,
                userId,
                userType,
                mac,
                Constant.FRAME_FUNCTION_STUDY,
                new ArrayList<DelayMessageBean>() {{
                    add(new DelayMessageBean(type == 2, (byte) functionType, "00 00 00 00 00 00", "00", 0));
                }}));
        // 存库
        if (userId > 0) {
            recordManageFeign.editRecordBySendStudy(userId);
        } else {
            iflyosFeign.saveIflyosMac(mac);
        }
        viewBean.setCode(ResultStatus.SUCCESS_SETTING.getCode());
        return ResponseResult.success(viewBean.getCode(), null);
    }

    @Override
    public ResponseResult sendControlMessage(
            long userId, int userType, String mac, String relayMac, long deviceId, long functionId, int functionType, String functionCode) {
        ViewBean viewBean = new ViewBean<>();
        //记录指令
        recordManageFeign.editRecord(deviceId, functionId, userId, "控制指令");
        //发送指令
        communicationFeign.sendMessage(new MessageBean(
                0L,
                userId,
                userType,
                mac,
                Constant.FRAME_FUNCTION_CONTROL,
                new ArrayList<DelayMessageBean>() {{
                    add(new DelayMessageBean((byte) functionType, relayMac, functionCode, 0));
                }}));
        // 存库
        if (userId > 0) {
            recordManageFeign.editRecordBySendControl(userId, deviceId, functionId);
        } else {
            iflyosFeign.saveIflyosMac(mac);
        }
        viewBean.setCode(ResultStatus.SUCCESS_SETTING.getCode());
        return ResponseResult.success(viewBean.getCode(), null);
    }

    /**
     * @author liuwenbo
     * @date 2020/8/31 11:15
     **/
    @Override
    public ResponseResult sendControlMessageByScenarioId(long userId, int userType, String centralMac, long scenarioId) {
        ViewBean<ScenarioFunctionListBean> scenarioFunctionListViewBean = scenarioFeign.searchFunctionListByScenarioId(scenarioId);
        if (scenarioFunctionListViewBean.getCode() == ResultStatus.SUCCESS_SELECT.getCode()) {
            List<ScenarioDeviceFunctionBean> scenarioDeviceFunctionBeanList = scenarioFunctionListViewBean.getData().getScenarioDeviceFunctionBeanList();
            if (!scenarioDeviceFunctionBeanList.isEmpty()) {
                //记录指令
                recordManageFeign.editRecordByScenarioId(scenarioId, userId, "情景模式");
                //发送指令
                communicationFeign.sendMessage(
                        new MessageBean(
                                0L,
                                userId,
                                userType,
                                centralMac,
                                Constant.FRAME_FUNCTION_CONTROL,
                                scenarioDeviceFunctionBeanList.stream().map(scenarioDeviceFunctionBean -> new DelayMessageBean(
                                        (byte) scenarioDeviceFunctionBean.getFunctionTypeValue(),
                                        "00 00 00 00 00 00",
                                        scenarioDeviceFunctionBean.getFunctionCode(),
                                        scenarioDeviceFunctionBean.getFunctionDelay()))
                                        .collect(Collectors.toList())));
                return ResponseResult.success(ResultStatus.SUCCESS_DEVICE_WORK.getCode(), null);
            }
            return ResponseResult.success(ResultStatus.SUCCESS_NO_DATA.getCode(), null);
        }
        return ResponseResult.success(ResultStatus.SUCCESS_NO_DATA.getCode(), null);
    }

    @Override
    public ResponseResult sendQueryMessage(long userId, int userType, String mac, String relayMac) {
        ViewBean viewBean = new ViewBean<>();
        communicationFeign.sendMessage(new MessageBean(
                0L,
                userId,
                userType,
                mac,
                Constant.FRAME_FUNCTION_QUERY,
                new ArrayList<DelayMessageBean>() {{
                    add(new DelayMessageBean((byte) 0x00, relayMac, "00", 0));
                }}));
        // 存库
        if (userId > 0) {
            recordManageFeign.editRecordBySendStudy(userId);
        } else {
            iflyosFeign.saveIflyosMac(mac);
        }
        viewBean.setCode(ResultStatus.SUCCESS_SETTING.getCode());
        return ResponseResult.success(viewBean.getCode(), null);
    }

    @Override
    public ResponseResult sendUpdateMessage(long userId, int userType, String mac, String relayMac, long editionId) {
        ViewBean viewBean = new ViewBean<>();

        //获取版本信息
        ViewBean<EditionBean> editionBeanViewBean = editionFeign.searchEdition(editionId);
        if (ResultStatus.SUCCESS_SELECT.getCode() != editionBeanViewBean.getCode() ||
                editionBeanViewBean.getData() == null ||
                editionBeanViewBean.getData().getFileName() == null ||
                editionBeanViewBean.getData().getFileName().length() == 0) {
            viewBean.setCode(ResultStatus.SUCCESS_NO_DATA.getCode());
            return ResponseResult.success(viewBean.getCode(), null);
        }
        //获取版本文件
        byte[] data = imageFeign.getImage(PathUtil.editionFilePath + editionBeanViewBean.getData().getFileName());
        if (data == null || data.length == 0) {
            viewBean.setCode(ResultStatus.SUCCESS_NO_DATA.getCode());
            return ResponseResult.success(viewBean.getCode(), null);
        }
        //发送升级指令
        communicationFeign.sendMessage(new MessageBean(
                0L,
                userId,
                userType,
                mac,
                Constant.FRAME_FUNCTION_UPDATE,
                new ArrayList<DelayMessageBean>() {{
                    add(new DelayMessageBean((byte) 0x00, relayMac, ByteUtil.getStringFromByte(data), 0));
                }}));

        // 存库
        if (userId > 0) {
            recordManageFeign.editRecordBySendStudy(userId);
        } else {
            iflyosFeign.saveIflyosMac(mac);
        }
        viewBean.setCode(ResultStatus.SUCCESS_SETTING.getCode());
        return ResponseResult.success(viewBean.getCode(), null);
    }

    @Override
    public ResponseResult<Integer> searchStateByMac(String mac) {
        ViewBean<Integer> viewBean = communicationFeign.searchStateByMac(mac);
        // 存库
        iflyosFeign.saveIflyosMac(mac);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public void workCallback(long id, long userId, int userType, boolean success, String code) {
        if (userId > 0) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("socketType", WebSocketServer.MESSAGE_INTELLIGENT);
            jsonObject.put("code", success ? ResultStatus.SUCCESS_DEVICE_WORK.getCode() : ResultStatus.INTELLIGENT_DEVICE_NO_WORK.getCode());
            jsonObject.put("message", success ? ResultStatus.SUCCESS_DEVICE_WORK.getMsg() :
                    (code.isEmpty() ? ResultStatus.INTELLIGENT_DEVICE_NO_WORK.getMsg() : code));
            jsonObject.put("codeValue", success ? code : "");
            WebSocketServer.sendMessageToUser(userType, userId, jsonObject.toString());
            // 存库（result）
            recordManageFeign.saveResult(id, success);
        }
    }

    @Override
    public void warnFunctionTrigger(String mac, String code) {
        ViewBean<WarnSettingBean> warnSettingBeanViewBean = warnFeign.editWarnRecord(mac, code);
        if (warnSettingBeanViewBean.getCode() == ResultStatus.SUCCESS_SELECT.getCode()) {
            WarnSettingBean warnSettingBean = warnSettingBeanViewBean.getData();

            //执行报警功能
            switch (warnSettingBean.getExecuteTypeValue()) {
                case Constant.warnSettingExecuteTypeScenario: {
                    ViewBean<ScenarioFunctionListBean> scenarioViewBean = scenarioFeign.searchFunctionListByScenarioId(warnSettingBean.getScenarioId());
                    if (scenarioViewBean.getData() != null && scenarioViewBean.getData().getScenarioDeviceFunctionBeanList() != null) {
                        communicationFeign.sendMessage(new MessageBean(
                                0L,
                                0,
                                0,
                                mac,
                                Constant.FRAME_FUNCTION_CONTROL,
                                scenarioViewBean.getData().getScenarioDeviceFunctionBeanList().stream().map(scenarioDeviceFunctionBean ->
                                        new DelayMessageBean(
                                                (byte) scenarioDeviceFunctionBean.getFunctionTypeValue(),
                                                "00 00 00 00 00 00",
                                                scenarioDeviceFunctionBean.getFunctionCode(),
                                                scenarioDeviceFunctionBean.getFunctionDelay())
                                ).collect(Collectors.toList())));
                    }
                    break;
                }
                case Constant.warnSettingExecuteTypeCustom: {
                    ViewBean<WarnDeviceFunctionListBean> warnViewBean = warnFeign.searchWarnFunctionList(warnSettingBean.getId());
                    if (warnViewBean.getData() != null && warnViewBean.getData().getWarnDeviceFunctionBeanList() != null) {
                        communicationFeign.sendMessage(new MessageBean(
                                0L,
                                0,
                                0,
                                mac,
                                Constant.FRAME_FUNCTION_CONTROL,
                                warnViewBean.getData().getWarnDeviceFunctionBeanList().stream().map(warnDeviceFunctionBean ->
                                        new DelayMessageBean(
                                                (byte) warnDeviceFunctionBean.getFunctionType(),
                                                "00 00 00 00 00 00",
                                                warnDeviceFunctionBean.getFunctionCode(),
                                                warnDeviceFunctionBean.getFunctionDelay())
                                ).collect(Collectors.toList())));
                    }
                    break;
                }
            }

            //发送报警通知
            if (warnSettingBean.isInDanger()) {
                ViewBean<DeviceBean> deviceViewBean = deviceManageFeign.searchDeviceById(warnSettingBean.getDeviceId());
                if (deviceViewBean.getCode() == ResultStatus.SUCCESS_SELECT.getCode() && deviceViewBean.getData() != null) {
                    ViewBean<HouseCustomerListBean> customerListViewBean =
                            houseCustomerFeign.searchHouseListByHouseId(deviceViewBean.getData().getHouseId());
                    if (customerListViewBean.getCode() == ResultStatus.SUCCESS_SELECT.getCode() && customerListViewBean.getData() != null) {
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("socketType", WebSocketServer.MESSAGE_WARN);
                        jsonObject.put("content", warnSettingBean.getMessage());

                        customerListViewBean.getData().getHouseCustomerListBean().forEach(houseCustomerBean ->
                                WebSocketServer.sendMessageToUser(WebSocketServer.TYPE_USER, houseCustomerBean.getCustomerId(), jsonObject.toString()));
                    }
                }
            }
        }
    }
}
