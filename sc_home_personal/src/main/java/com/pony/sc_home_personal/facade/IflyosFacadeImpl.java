package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.base.*;
import com.pony.sc_home_personal.bean.response.*;
import com.pony.sc_home_personal.bean.util.DelayMessageBean;
import com.pony.sc_home_personal.bean.util.MessageBean;
import com.pony.sc_home_personal.common.Constant;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ResultStatus;
import com.pony.sc_home_personal.common.ViewBean;
import com.pony.sc_home_personal.service.communication.CommunicationFeign;
import com.pony.sc_home_personal.service.personal.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chujialin
 * @date 2020/5/9 15:47
 **/
@Component
public class IflyosFacadeImpl implements IflyosFacade {

    @Resource
    private IflyosFeign iflyosFeign;
    @Resource
    private CentralManageFeign centralManageFeign;
    @Resource
    private HouseCustomerFeign houseCustomerFeign;
    @Resource
    private DeviceManageFeign deviceManageFeign;
    @Resource
    private CommunicationFeign communicationFeign;
    @Resource
    private ScenarioFeign scenarioFeign;
    @Resource
    private RecordManageFeign recordManageFeign;

    @Override
    public ResponseResult sendControlMessage(String iflyosId, String action, String position, String device) {
        ViewBean<IflyosBean> iflyosViewBean = iflyosFeign.searchById(iflyosId);
        if (iflyosViewBean.getCode() == ResultStatus.SUCCESS_SELECT.getCode()) {
            String mac = iflyosViewBean.getData().getMac();

            //判断设备状态
            ViewBean<Integer> deviceStateViewBean = communicationFeign.searchStateByMac(mac);
            if (deviceStateViewBean.getCode() == ResultStatus.SUCCESS_SELECT.getCode() && deviceStateViewBean.getData() != null) {
                switch (deviceStateViewBean.getData()) {
                    case Constant.DEVICE_STATE_UNBIND: {
                        return ResponseResult.success(ResultStatus.EXISTENT_DEVICE_STATE_UNBIND.getCode(), null);
                    }
                    case Constant.DEVICE_STATE_OFF: {
                        return ResponseResult.success(ResultStatus.EXISTENT_DEVICE_STATE_OFF.getCode(), null);
                    }
                    case Constant.DEVICE_STATE_STUDY: {
                        return ResponseResult.success(ResultStatus.EXISTENT_DEVICE_STATE_STUDY.getCode(), null);
                    }
                    default: {
                        //查询绑定主机
                        ViewBean<CentralBean> centralControllerViewBean = centralManageFeign.searchCentralByMac(mac);
                        if (centralControllerViewBean.getCode() != ResultStatus.SUCCESS_SELECT.getCode()) {
                            return ResponseResult.success(ResultStatus.EXISTENT_NO_CENTRAL_CONTROLLER.getCode(), null);
                        }
                        long houseId = centralControllerViewBean.getData().getId();
                        long roomId = 0;
                        //指定设备位置
                        if (position != null && position.length() > 0) {
                            ViewBean<RoomListBean> roomListViewBean = houseCustomerFeign.searchRoomList(houseId);
                            if (roomListViewBean.getCode() != ResultStatus.SUCCESS_SELECT.getCode()) {
                                return ResponseResult.success(ResultStatus.EXISTENT_NO_ROOM.getCode(), null);
                            }
                            for (RoomBean roomBean : roomListViewBean.getData().getRoomBeanList()) {
                                if (roomBean.getName().equals(position)) {
                                    roomId = roomBean.getId();
                                    break;
                                }
                            }
                            if (roomId == 0) {
                                return ResponseResult.success(ResultStatus.EXISTENT_NO_ROOM.getCode(), null);
                            }
                        }
                        //查询设备及功能
                        ViewBean<DeviceWithFunctionListBean> deviceWithFunctionListViewBean = deviceManageFeign.searchDeviceWithFunctionList(houseId, roomId);
                        if (deviceWithFunctionListViewBean.getCode() != ResultStatus.SUCCESS_SELECT.getCode()) {
                            return ResponseResult.success(ResultStatus.EXISTENT_NO_DEVICE.getCode(), null);
                        }
                        List<DeviceWithFunctionBean> beanList = deviceWithFunctionListViewBean.getData().getDeviceWithFunctionBeanList().stream()
                                .filter(deviceWithFunctionBean -> deviceWithFunctionBean.getDeviceBean().getName().equals(device)).collect(Collectors.toList());
                        //筛选结果
                        if (beanList.isEmpty()) {
                            return ResponseResult.success(ResultStatus.EXISTENT_NO_DEVICE.getCode(), null);
                        } else {
                            List<DelayMessageBean> delayMessageBeanList = new ArrayList<>();
                            for (DeviceWithFunctionBean bean : beanList) {
                                for (DeviceFunctionBean deviceFunctionBean : bean.getDeviceFunctionBeanList()) {
                                    if (deviceFunctionBean.getName().equals(action)) {
                                        //语音指令记录
                                        recordManageFeign.editRecord(deviceFunctionBean.getDeviceId(), deviceFunctionBean.getId(), 0L, "语音控制指令");
                                        //添加待发送指令
                                        delayMessageBeanList.add(new DelayMessageBean(
                                                (byte) bean.getDeviceBean().getFunctionTypeValue(),
                                                "00 00 00 00 00 00",
                                                deviceFunctionBean.getCode(),
                                                0));
                                        break;
                                    }
                                }
                            }
                            if (delayMessageBeanList.isEmpty()) {
                                return ResponseResult.success(ResultStatus.EXISTENT_NO_DEVICE_FUNCTION.getCode(), null);
                            }
                            communicationFeign.sendMessage(
                                    new MessageBean(0L,
                                            0,
                                            0,
                                            mac,
                                            Constant.FRAME_FUNCTION_CONTROL,
                                            delayMessageBeanList));
                            return ResponseResult.success(ResultStatus.SUCCESS_DEVICE_WORK.getCode(), null);
                        }
                    }
                }
            } else {
                return ResponseResult.success(ResultStatus.EXISTENT_NO_DEVICE.getCode(), null);
            }
        } else {
            return ResponseResult.success(ResultStatus.SUCCESS_NO_DATA.getCode(), null);
        }
    }

    @Override
    public ResponseResult sendControlMessageByScenario(String iflyosId, String scenario) {
        ViewBean<IflyosBean> iflyosViewBean = iflyosFeign.searchById(iflyosId);
        if (iflyosViewBean.getCode() == ResultStatus.SUCCESS_SELECT.getCode()) {
            String mac = iflyosViewBean.getData().getMac();

            //判断设备状态
            ViewBean<Integer> deviceStateViewBean = communicationFeign.searchStateByMac(mac);
            if (deviceStateViewBean.getCode() == ResultStatus.SUCCESS_SELECT.getCode() && deviceStateViewBean.getData() != null) {
                switch (deviceStateViewBean.getData()) {
                    case Constant.DEVICE_STATE_UNBIND: {
                        return ResponseResult.success(ResultStatus.EXISTENT_DEVICE_STATE_UNBIND.getCode(), null);
                    }
                    case Constant.DEVICE_STATE_OFF: {
                        return ResponseResult.success(ResultStatus.EXISTENT_DEVICE_STATE_OFF.getCode(), null);
                    }
                    case Constant.DEVICE_STATE_STUDY: {
                        return ResponseResult.success(ResultStatus.EXISTENT_DEVICE_STATE_STUDY.getCode(), null);
                    }
                    default: {
                        //查询绑定主机
                        ViewBean<CentralBean> centralViewBean = centralManageFeign.searchCentralByMac(mac);
                        if (centralViewBean.getCode() != ResultStatus.SUCCESS_SELECT.getCode()) {
                            return ResponseResult.success(ResultStatus.EXISTENT_NO_CENTRAL_CONTROLLER.getCode(), null);
                        }
                        long houseId = centralViewBean.getData().getId();
                        //查询情景模式
                        ViewBean<ScenarioListBean> scenarioListViewBean = scenarioFeign.searchListByHouseId(houseId);
                        if (scenarioListViewBean.getCode() != ResultStatus.SUCCESS_SELECT.getCode()) {
                            return ResponseResult.success(ResultStatus.EXISTENT_NO_SCENARIO_MODE.getCode(), null);
                        }
                        //遍历、筛选
                        for (ScenarioBean scenarioBean : scenarioListViewBean.getData().getScenarioBeanList()) {
                            if (scenarioBean.getName().equals(scenario)) {
                                ViewBean<ScenarioFunctionListBean> scenarioFunctionListViewBean =
                                        scenarioFeign.searchFunctionListByScenarioId(scenarioBean.getId());
                                if (scenarioFunctionListViewBean.getCode() == ResultStatus.SUCCESS_SELECT.getCode() &&
                                        !scenarioFunctionListViewBean.getData().getScenarioDeviceFunctionBeanList().isEmpty()) {
                                    //语音指令记录
                                    recordManageFeign.editRecordByScenarioId(scenarioBean.getId(), 0L, "语音情景模式");
                                    //发送指令
                                    List<ScenarioDeviceFunctionBean> scenarioDeviceFunctionBeanList =
                                            scenarioFunctionListViewBean.getData().getScenarioDeviceFunctionBeanList();
                                    communicationFeign.sendMessage(
                                            new MessageBean(
                                                    0L,
                                                    0,
                                                    0,
                                                    mac,
                                                    Constant.FRAME_FUNCTION_CONTROL,
                                                    scenarioDeviceFunctionBeanList.stream()
                                                            .map(scenarioDeviceFunctionBean -> new DelayMessageBean(
                                                                    (byte) scenarioDeviceFunctionBean.getFunctionTypeValue(),
                                                                    "00 00 00 00 00 00",
                                                                    scenarioDeviceFunctionBean.getFunctionCode(),
                                                                    scenarioDeviceFunctionBean.getFunctionDelay()))
                                                            .collect(Collectors.toList())));
                                    return ResponseResult.success(ResultStatus.SUCCESS_DEVICE_WORK.getCode(), null);
                                }
                            }
                        }
                        return ResponseResult.success(ResultStatus.EXISTENT_NO_SCENARIO_MODE.getCode(), null);
                    }
                }
            } else {
                return ResponseResult.success(ResultStatus.EXISTENT_NO_DEVICE.getCode(), null);
            }
        } else {
            return ResponseResult.success(ResultStatus.SUCCESS_NO_DATA.getCode(), null);
        }
    }

    @Override
    public ResponseResult<IflyosPageBean> selectIflyosByPage(int currentPage, int everyPage) {
        ViewBean<IflyosPageBean> viewBean = iflyosFeign.selectIflyosByPage(currentPage, everyPage);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult deleteIflyosById(String id) {
        ViewBean viewBean = iflyosFeign.deleteIflyosById(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<IflyosInitBean> editIflyosInit(String id) {
        ViewBean<IflyosInitBean> viewBean = iflyosFeign.editIflyosInit(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult saveIflyos(String id, long centralId, String snNumber) {
        ViewBean viewBean = iflyosFeign.saveIflyos(id, centralId, snNumber);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult saveIflyosMac(String sNNumber) {
        ViewBean viewBean = iflyosFeign.saveIflyosMac(sNNumber);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }
}
