package com.pony.sc_home_personal.facade;


import com.pony.sc_home_personal.bean.base.DeviceBean;
import com.pony.sc_home_personal.bean.base.DeviceFunctionBean;
import com.pony.sc_home_personal.bean.response.*;
import com.pony.sc_home_personal.common.ResponseResult;

/**
 * @author suntai
 * @date 2019/11/25 9:12
 */
public interface DeviceManageFacade {

    //********************设备管理********************

    /**
     * @author suntai
     * @date 2019/11/25 9:21
     **/
    ResponseResult<DeviceCentralHouseInitBean> searchDevicePageInit(int typeId, String province, String city, String region, String communityName,
                                                                    long customerId, long houseId, long roomId, int currentPage, int everyPage);

    /**
     * @author suntai
     * @date 2019/11/25 9:21
     **/
    ResponseResult<DeviceCentralHousePageBean> searchDevicePage(int typeId, String province, String city, String region, String communityName,
                                                                long customerId, long houseId, long roomId, int currentPage, int everyPage);

    /**
     * @author hanshuang
     * @date 2020/07/06 14:29
     **/
    ResponseResult<DeviceCentralHousePageBean> searchDevicePageByRoomId(long houseId, long roomId, int currentPage, int everyPage);

    /**
     * @author suntai
     * @date 2019/11/25 9:18
     **/
    ResponseResult<DeviceInitBean> editDeviceInit(long id);

    /**
     * @author liuwenbo
     * @date 2020/7/30 9:36
     **/
    ResponseResult<DeviceInitBean> editAppDeviceInit(long houseId, long roomId);

    /**
     * @author suntai
     * @date 2019/11/25 9:15
     **/
    ResponseResult<DeviceBean> editDevice(long id, long houseId, long roomId, long relayId, String relayMac,
                                          String name, int functionType, long typeId, boolean alarm);

    /**
     * @author suntai
     * @date 2019/11/25 9:16
     **/
    ResponseResult deleteDevice(long id);

    //********************设备功能管理********************

    /**
     * @author suntai
     * @date 2019/11/25 9:23
     **/
    ResponseResult<DeviceDetailsBean> searchDeviceDetailsById(long id);

    /**
     * @author suntai
     * @date 2019/11/25 9:26
     **/
    ResponseResult<DeviceFunctionBean> editDeviceFunction(long id, long deviceId, String name, String code, boolean isAlarm);

    /**
     * @author chujialin
     * @date 2020/5/18 12:43
     **/
    ResponseResult deleteDeviceFunction(long id);

    /**
     * @author chujialin
     * @date 2020/4/15 15:15
     **/
    ResponseResult<DeviceWithFunctionListBean> searchDeviceWithFunctionList(long houseId, long roomId);

    /**
     * @author hanshuang
     * @date 2020/04/26 9:30
     **/
    ResponseResult existsByCode(long centralId, String code);
}
