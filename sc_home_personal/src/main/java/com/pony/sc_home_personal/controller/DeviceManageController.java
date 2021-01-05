package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.bean.base.DeviceBean;
import com.pony.sc_home_personal.bean.base.DeviceFunctionBean;
import com.pony.sc_home_personal.bean.response.*;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.config.CheckToken;
import com.pony.sc_home_personal.facade.DeviceManageFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 设备
 *
 * @author suntai
 * @date 2019/11/25 9:05
 */
@RestController
@RequestMapping("/ScDeviceManage")
public class DeviceManageController {

    private final DeviceManageFacade deviceManageFacade;

    @Autowired
    public DeviceManageController(DeviceManageFacade deviceManageFacade) {
        this.deviceManageFacade = deviceManageFacade;
    }

    /**
     * 获取设备分页列表初始化信息
     *
     * @param typeId        设备类型（红外、射频433、射频315；全部设备时为0）
     * @param province      省份
     * @param city          市
     * @param region        区县
     * @param communityName 小区（模糊查询）
     * @param customerId    用户Id（不为0）
     * @param houseId       房产Id（所有房产时为0）
     * @param roomId        房间Id（所有房间时为0）
     * @param currentPage   当前页数（从0开始）
     * @param everyPage     每页条数
     * @author suntai
     * @date 2019/11/25 10:07
     **/
    @CheckToken
    @PostMapping("/SearchDevicePageInit.do")
    public ResponseResult<DeviceCentralHouseInitBean> searchDevicePageInit(@RequestParam int typeId,
                                                                           @RequestParam String province,
                                                                           @RequestParam String city,
                                                                           @RequestParam String region,
                                                                           @RequestParam String communityName,
                                                                           @RequestParam long customerId,
                                                                           @RequestParam long houseId,
                                                                           @RequestParam long roomId,
                                                                           @RequestParam int currentPage,
                                                                           @RequestParam int everyPage) {
        return deviceManageFacade.searchDevicePageInit(
                typeId, province, city, region, communityName, customerId, houseId, roomId, currentPage, everyPage);
    }

    /**
     * 获取设备分页列表
     *
     * @param typeId        设备类型（红外、射频433、射频315；全部设备时为0）
     * @param province      省份
     * @param city          市
     * @param region        区县
     * @param communityName 小区（模糊查询）
     * @param customerId    用户Id（不为0）
     * @param houseId       房产Id（所有房产时为0）
     * @param roomId        房间Id（所有房间时为0）
     * @param currentPage   当前页数（从0开始）
     * @param everyPage     每页条数
     * @author suntai
     * @date 2019/11/25 10:07
     **/
    @CheckToken
    @PostMapping("/SearchDevicePage.do")
    public ResponseResult<DeviceCentralHousePageBean> searchDevicePage(@RequestParam int typeId,
                                                                       @RequestParam String province,
                                                                       @RequestParam String city,
                                                                       @RequestParam String region,
                                                                       @RequestParam String communityName,
                                                                       @RequestParam long customerId,
                                                                       @RequestParam long houseId,
                                                                       @RequestParam long roomId,
                                                                       @RequestParam int currentPage,
                                                                       @RequestParam int everyPage) {
        return deviceManageFacade.searchDevicePage(typeId, province, city, region, communityName, customerId, houseId, roomId, currentPage, everyPage);
    }

    /**
     * 根据房产Id、房间Id，获取设备分页列表
     *
     * @param houseId     房产Id（所有房产时为0）
     * @param roomId      房间Id（所有房间时为0）
     * @param currentPage 当前页数（从0开始）
     * @param everyPage   每页条数
     * @author hanshuang
     * @date 2020/07/06 14:29
     **/
    @PostMapping("/SearchDevicePageByRoomId.do")
    @CheckToken
    public ResponseResult<DeviceCentralHousePageBean> searchDevicePageByRoomId(@RequestParam long houseId,
                                                                               @RequestParam long roomId,
                                                                               @RequestParam int currentPage,
                                                                               @RequestParam int everyPage) {
        return deviceManageFacade.searchDevicePageByRoomId(houseId, roomId, currentPage, everyPage);
    }

    /**
     * 编辑设备初始化
     *
     * @param id 设备Id
     * @author suntai
     * @date 2019/11/25 9:58
     **/
    @CheckToken
    @PostMapping("/EditDeviceInit.do")
    public ResponseResult<DeviceInitBean> editDeviceInit(@RequestParam long id) {
        return deviceManageFacade.editDeviceInit(id);
    }

    /**
     * APP编辑设备初始化
     *
     * @param houseId 房产Id
     * @param roomId  房间Id
     * @author liuwenbo
     * @date 2020/7/29 10:45
     **/
    @CheckToken
    @PostMapping("/EditAppDeviceInit.do")
    public ResponseResult<DeviceInitBean> editAppDeviceInit(@RequestParam long houseId,
                                                            @RequestParam long roomId) {
        return deviceManageFacade.editAppDeviceInit(houseId, roomId);
    }

    /**
     * 编辑设备
     *
     * @param id           设备Id
     * @param houseId      房产Id
     * @param roomId       房间Id
     * @param relayId      中继Id
     * @param relayMac     中继mac
     * @param name         设备名称
     * @param functionType 设备功能类别（红外、射频433、射频315）
     * @param typeId       设备类型
     * @param alarm        是否为报警设备
     * @author suntai
     * @date 2019/11/25 9:52
     **/
    @CheckToken
    @PostMapping("/EditDevice.do")
    public ResponseResult<DeviceBean> editDevice(@RequestParam long id,
                                                 @RequestParam long houseId,
                                                 @RequestParam long roomId,
                                                 @RequestParam long relayId,
                                                 @RequestParam String relayMac,
                                                 @RequestParam String name,
                                                 @RequestParam int functionType,
                                                 @RequestParam long typeId,
                                                 @RequestParam boolean alarm) {
        return deviceManageFacade.editDevice(id, houseId, roomId, relayId, relayMac, name, functionType, typeId, alarm);
    }

    /**
     * 删除设备
     *
     * @param id 设备Id
     * @author suntai
     * @date 2019/11/25 9:55
     **/
    @CheckToken
    @PostMapping("/DeleteDevice.do")
    public ResponseResult deleteDevice(@RequestParam long id) {
        return deviceManageFacade.deleteDevice(id);
    }

    /**
     * 获取设备详情
     *
     * @param id 设备Id
     * @author suntai
     * @date 2019/11/25 10:11
     **/
    @CheckToken
    @PostMapping("/SearchDeviceDetailsById.do")
    public ResponseResult<DeviceDetailsBean> searchDeviceDetailsById(@RequestParam long id) {
        return deviceManageFacade.searchDeviceDetailsById(id);
    }

    /**
     * 编辑设备功能
     *
     * @param id       功能Id
     * @param deviceId 设备Id
     * @param name     功能名称
     * @param code     功能码
     * @param isAlarm  是否为报警功能
     * @author suntai
     * @date 2019/11/25 10:26
     **/
    @CheckToken
    @PostMapping("/EditDeviceFunction.do")
    public ResponseResult<DeviceFunctionBean> editDeviceFunction(@RequestParam long id,
                                                                 @RequestParam long deviceId,
                                                                 @RequestParam String name,
                                                                 @RequestParam String code,
                                                                 @RequestParam boolean isAlarm) {
        return deviceManageFacade.editDeviceFunction(id, deviceId, name, code, isAlarm);
    }

    /**
     * 删除设备功能
     *
     * @param id 功能Id
     * @author chujialin
     * @date 2020/5/18 12:42
     **/
    @CheckToken
    @PostMapping("/DeleteDeviceFunction.do")
    public ResponseResult deleteDeviceFunction(@RequestParam long id) {
        return deviceManageFacade.deleteDeviceFunction(id);
    }

    /**
     * 获取设备列表（附带设备的功能列表）
     *
     * @param houseId 房产Id
     * @param roomId  房间Id
     * @author chujialin
     * @date 2020/4/15 15:17
     **/
    @CheckToken
    @PostMapping("/SearchDeviceWithFunctionList.do")
    public ResponseResult<DeviceWithFunctionListBean> searchDeviceWithFunctionList(@RequestParam long houseId,
                                                                                   @RequestParam long roomId) {
        return deviceManageFacade.searchDeviceWithFunctionList(houseId, roomId);
    }

    /**
     * 查询同一网关下，功能码是否重复
     *
     * @param centralId 网关Id
     * @param code      功能码
     * @author hanshuang
     * @date 2020/07/01 14:41
     **/
    @PostMapping("/ExistsByCode.do")
    public ResponseResult existsByCode(@RequestParam long centralId,
                                       @RequestParam String code) {
        return deviceManageFacade.existsByCode(centralId, code);
    }
}
