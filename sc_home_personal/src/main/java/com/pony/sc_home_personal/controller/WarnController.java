package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.bean.base.WarnDeviceFunctionBean;
import com.pony.sc_home_personal.bean.response.RoomWithWarnListBean;
import com.pony.sc_home_personal.bean.response.WarnDeviceFunctionListBean;
import com.pony.sc_home_personal.bean.response.WarnSettingInitBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ResultStatus;
import com.pony.sc_home_personal.config.CheckToken;
import com.pony.sc_home_personal.facade.WarnFacade;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 报警设置
 *
 * @author suntai
 * @date 2019/12/30 11:51
 */
@RestController
@RequestMapping("/ScWarn")
public class WarnController {

    private final WarnFacade warnFacade;

    @Autowired
    public WarnController(WarnFacade warnFacade) {
        this.warnFacade = warnFacade;
    }

    /**
     * 编辑报警设置初始化
     *
     * @param warnId  警报Id
     * @param houseId 房产Id
     * @author chujialin
     * @date 2020/4/11 8:40
     **/
    @CheckToken
    @PostMapping("/EditWarnSettingInit.do")
    public ResponseResult<WarnSettingInitBean> editWarnSettingInit(@RequestParam long warnId,
                                                                   @RequestParam long houseId) {
        return warnFacade.editWarnSettingInit(warnId, houseId);
    }

    /**
     * 编辑报警设置
     *
     * @param messageObject 报警设置json数据
     * @author chujialin
     * @date 2020/4/11 8:40
     **/
    @CheckToken
    @PostMapping("/EditWarnSetting.do")
    public ResponseResult editWarnSetting(@RequestParam String messageObject) {
        List<WarnDeviceFunctionBean> beanList = new ArrayList<>();
        try {
            JSONObject jsonObject = JSONObject.fromObject(messageObject);
            WarnDeviceFunctionBean functionBean = new WarnDeviceFunctionBean();
            functionBean.setWarnId(jsonObject.getLong("warnId"));
            functionBean.setDeviceId(jsonObject.getLong("deviceId"));
            functionBean.setMessage(jsonObject.getString("message"));
            functionBean.setInDanger(jsonObject.getBoolean("inDanger"));
            functionBean.setExecuteTypeValue(jsonObject.getInt("executeType"));
            functionBean.setScenarioId(jsonObject.getLong("scenarioId"));

            JSONArray functionArray = JSONArray.fromObject(jsonObject.getString("functionList"));
            for (int i = 0; i < functionArray.size(); i++) {
                JSONObject functionObject = functionArray.getJSONObject(i);
                WarnDeviceFunctionBean bean;
                if (i == 0) {
                    bean = functionBean;
                } else {
                    bean = new WarnDeviceFunctionBean();
                }
                bean.setFunctionId(functionObject.getLong("functionId"));
                bean.setFunctionSort(functionObject.getInt("functionSort"));
                bean.setFunctionDelay(functionObject.getLong("functionDelay"));
                beanList.add(bean);
            }
            if (beanList.isEmpty()) {
                beanList.add(functionBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (beanList.isEmpty()) {
            return ResponseResult.success(ResultStatus.EXISTENT_FAILED_JSON.getCode(), null);
        } else {
            WarnDeviceFunctionListBean listBean = new WarnDeviceFunctionListBean();
            listBean.setWarnDeviceFunctionBeanList(beanList);
            return warnFacade.editWarnSetting(listBean);
        }
    }

    /**
     * 获取警报未读数据列表
     *
     * @param houseId 房产Id
     * @author liuwenbo
     * @date 2020/7/13 11:21
     **/
    @CheckToken
    @PostMapping("/SearchWarnUnReadMessage.do")
    public ResponseResult<RoomWithWarnListBean> searchWarnUnReadMessage(@RequestParam long houseId) {
        return warnFacade.searchWarnUnReadMessage(houseId);
    }

    /**
     * 确认警报
     *
     * @param houseId 房产Id
     * @param roomId  房间Id
     * @author liuwenbo
     * @date 2020/7/13 11:21
     **/
    @CheckToken
    @PostMapping("/ConfirmDeviceWarn.do")
    public ResponseResult confirmDeviceWarn(@RequestParam long houseId,
                                            @RequestParam long roomId) {
        return warnFacade.confirmDeviceWarn(houseId, roomId);
    }
}
