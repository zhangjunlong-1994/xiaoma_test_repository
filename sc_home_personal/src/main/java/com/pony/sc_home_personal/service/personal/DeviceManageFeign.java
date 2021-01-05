package com.pony.sc_home_personal.service.personal;

import com.pony.sc_home_personal.bean.base.DeviceBean;
import com.pony.sc_home_personal.bean.base.DeviceFunctionBean;
import com.pony.sc_home_personal.bean.response.*;
import com.pony.sc_home_personal.common.ViewBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author suntai
 * @date 2019/11/25 8:42
 */
@FeignClient(name = "sp-home-personal")
@RequestMapping("/DeviceManage")
public interface DeviceManageFeign {

    //********************设备管理********************

    /**
     * @author suntai
     * @date 2019/11/25 9:02
     **/
    @PostMapping(value = "/SearchDevicePageInit.do")
    ViewBean<DeviceCentralHouseInitBean> searchDevicePageInit(@RequestParam("typeId") int typeId,
                                                              @RequestParam("province") String province,
                                                              @RequestParam("city") String city,
                                                              @RequestParam("region") String region,
                                                              @RequestParam("communityName") String communityName,
                                                              @RequestParam("customerId") long customerId,
                                                              @RequestParam("houseId") long houseId,
                                                              @RequestParam("roomId") long roomId,
                                                              @RequestParam("currentPage") int currentPage,
                                                              @RequestParam("everyPage") int everyPage);

    /**
     * @author suntai
     * @date 2019/11/25 9:02
     **/
    @PostMapping(value = "/SearchDevicePage.do")
    ViewBean<DeviceCentralHousePageBean> searchDevicePage(@RequestParam("typeId") int typeId,
                                                          @RequestParam("province") String province,
                                                          @RequestParam("city") String city,
                                                          @RequestParam("region") String region,
                                                          @RequestParam("communityName") String communityName,
                                                          @RequestParam("customerId") long customerId,
                                                          @RequestParam("houseId") long houseId,
                                                          @RequestParam("roomId") long roomId,
                                                          @RequestParam("currentPage") int currentPage,
                                                          @RequestParam("everyPage") int everyPage);

    /**
     * @author hanshuang
     * @date 2020/07/06 14:31
     **/
    @PostMapping("/SearchDevicePageByRoomId.do")
    ViewBean<DeviceCentralHousePageBean> searchDevicePageByRoomId(@RequestParam("houseId") long houseId,
                                                                  @RequestParam("roomId") long roomId,
                                                                  @RequestParam("currentPage") int currentPage,
                                                                  @RequestParam("everyPage") int everyPage);

    /**
     * @author suntai
     * @date 2019/11/25 8:59
     **/
    @PostMapping(value = "/SearchDeviceListByHouseIdAndRoomId.do")
    ViewBean<DeviceListBean> searchDeviceListByHouseIdAndRoomId(@RequestParam("houseId") long houseId,
                                                                @RequestParam("roomId") long roomId);

    /**
     * @author chujialin
     * @date 2020/8/25 14:53
     **/
    @PostMapping(value = "/SearchDeviceById.do")
    ViewBean<DeviceBean> searchDeviceById(@RequestParam("deviceId") long deviceId);

    /**
     * @author suntai
     * @date 2019/11/25 8:55
     **/
    @PostMapping(value = "/EditDeviceInit.do")
    ViewBean<DeviceInitBean> editDeviceInit(@RequestParam("id") long id);

    /**
     * @author liuwenbo
     * @date 2020/7/29 10:52
     **/
    @PostMapping("/EditAppDeviceInit.do")
    ViewBean<DeviceInitBean> editAppDeviceInit(@RequestParam("houseId") long houseId,
                                               @RequestParam("roomId") long roomId);

    /**
     * @author suntai
     * @date 2019/11/25 8:44
     **/
    @PostMapping(value = "/EditDevice.do")
    ViewBean<DeviceBean> editDevice(@RequestParam("id") long id,
                                    @RequestParam("houseId") long houseId,
                                    @RequestParam("roomId") long roomId,
                                    @RequestParam("relayId") long relayId,
                                    @RequestParam("relayMac") String relayMac,
                                    @RequestParam("name") String name,
                                    @RequestParam("functionType") int functionType,
                                    @RequestParam("typeId") long typeId,
                                    @RequestParam("alarm") boolean alarm);

    /**
     * @author suntai
     * @date 2019/11/25 8:51
     **/
    @PostMapping(value = "/DeleteDevice.do")
    ViewBean deleteDevice(@RequestParam("id") long id);

    //********************设备功能管理********************

    /**
     * @author suntai
     * @date 2019/11/25 9:03
     **/
    @PostMapping("/SearchDeviceDetailsById.do")
    ViewBean<DeviceDetailsBean> searchDeviceDetailsById(@RequestParam("id") long id);

    /**
     * @author suntai
     * @date 2019/11/25 9:08
     **/
    @PostMapping("/EditDeviceFunction.do")
    ViewBean<DeviceFunctionBean> editDeviceFunction(@RequestParam("id") long id,
                                                    @RequestParam("deviceId") long deviceId,
                                                    @RequestParam("name") String name,
                                                    @RequestParam("code") String code,
                                                    @RequestParam("isAlarm") boolean isAlarm);

    /**
     * @author chujialin
     * @date 2020/5/18 12:52
     **/
    @PostMapping("/DeleteDeviceFunction.do")
    ViewBean deleteDeviceFunction(@RequestParam("id") long id);

    /**
     * @author chujialin
     * @date 2020/4/15 15:14
     **/
    @PostMapping("/SearchDeviceWithFunctionList.do")
    ViewBean<DeviceWithFunctionListBean> searchDeviceWithFunctionList(@RequestParam("houseId") long houseId,
                                                                      @RequestParam("roomId") long roomId);

    /**
     * @author hanshuang
     * @date 2020/04/26 9:34
     **/
    @PostMapping("/ExistsByCode.do")
    ViewBean existsByCode(@RequestParam("centralId") long centralId,
                          @RequestParam("code") String code);
}
