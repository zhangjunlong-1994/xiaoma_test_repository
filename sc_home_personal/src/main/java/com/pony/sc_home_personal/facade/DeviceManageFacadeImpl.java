package com.pony.sc_home_personal.facade;


import com.pony.sc_home_personal.bean.base.DeviceBean;
import com.pony.sc_home_personal.bean.base.DeviceFunctionBean;
import com.pony.sc_home_personal.bean.response.*;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ViewBean;
import com.pony.sc_home_personal.service.personal.DeviceManageFeign;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author suntai
 * @date 2019/11/25 9:12
 */
@Component
public class DeviceManageFacadeImpl implements DeviceManageFacade {

    @Resource
    private DeviceManageFeign deviceManageFeign;

    @Override
    public ResponseResult<DeviceCentralHouseInitBean> searchDevicePageInit(int typeId, String province, String city, String region, String communityName,
                                                                           long customerId, long houseId, long roomId, int currentPage, int everyPage) {
        ViewBean<DeviceCentralHouseInitBean> viewBean = deviceManageFeign.searchDevicePageInit(
                typeId, province, city, region, communityName, customerId, houseId, roomId, currentPage, everyPage);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<DeviceCentralHousePageBean> searchDevicePage(int typeId, String province, String city, String region, String communityName,
                                                                       long customerId, long houseId, long roomId, int currentPage, int everyPage) {
        ViewBean<DeviceCentralHousePageBean> viewBean = deviceManageFeign.searchDevicePage(
                typeId, province, city, region, communityName, customerId, houseId, roomId, currentPage, everyPage);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<DeviceCentralHousePageBean> searchDevicePageByRoomId(long houseId, long roomId, int currentPage, int everyPage) {
        ViewBean<DeviceCentralHousePageBean> viewBean = deviceManageFeign.searchDevicePageByRoomId(houseId, roomId, currentPage, everyPage);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<DeviceInitBean> editDeviceInit(long id) {
        ViewBean<DeviceInitBean> viewBean = deviceManageFeign.editDeviceInit(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<DeviceInitBean> editAppDeviceInit(long houseId, long roomId) {
        ViewBean<DeviceInitBean> viewBean = deviceManageFeign.editAppDeviceInit(houseId, roomId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<DeviceBean> editDevice(long id, long houseId, long roomId, long relayId, String relayMac,
                                                 String name, int functionType, long typeId, boolean alarm) {
        ViewBean<DeviceBean> viewBean = deviceManageFeign.editDevice(id, houseId, roomId, relayId,
                relayId == 0 ? "00 00 00 00 00 00" : relayMac, name, functionType, typeId, alarm);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult deleteDevice(long id) {
        ViewBean viewBean = deviceManageFeign.deleteDevice(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<DeviceDetailsBean> searchDeviceDetailsById(long id) {
        ViewBean<DeviceDetailsBean> viewBean = deviceManageFeign.searchDeviceDetailsById(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<DeviceFunctionBean> editDeviceFunction(long id, long deviceId, String name, String code, boolean isAlarm) {
        ViewBean<DeviceFunctionBean> viewBean = deviceManageFeign.editDeviceFunction(id, deviceId, name, code, isAlarm);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult deleteDeviceFunction(long id) {
        ViewBean viewBean = deviceManageFeign.deleteDeviceFunction(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<DeviceWithFunctionListBean> searchDeviceWithFunctionList(long houseId, long roomId) {
        ViewBean<DeviceWithFunctionListBean> viewBean = deviceManageFeign.searchDeviceWithFunctionList(houseId, roomId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult existsByCode(long centralId, String code) {
        ViewBean viewBean = deviceManageFeign.existsByCode(centralId, code);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }
}
