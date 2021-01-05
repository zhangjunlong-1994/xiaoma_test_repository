package com.pony.sc_home_personal.service.personal;

import com.pony.sc_home_personal.bean.base.WarnSettingBean;
import com.pony.sc_home_personal.bean.response.RoomWithWarnListBean;
import com.pony.sc_home_personal.bean.response.WarnDeviceFunctionListBean;
import com.pony.sc_home_personal.bean.response.WarnSettingInitBean;
import com.pony.sc_home_personal.common.ViewBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wenxufeng
 * @date 2020/1/8 9:40
 **/
@FeignClient(name = "sp-home-personal")
@RequestMapping("/Warn")
public interface WarnFeign {

    /**
     * @author chujialin
     * @date 2020/7/14 13:31
     **/
    @PostMapping("/EditWarnSettingInit.do")
    ViewBean<WarnSettingInitBean> editWarnSettingInit(@RequestParam("warnId") long warnId,
                                                      @RequestParam("houseId") long houseId);

    /**
     * @author chujialin
     * @date 2020/7/14 13:31
     **/
    @PostMapping("/EditWarnSetting.do")
    ViewBean editWarnSetting(@RequestBody WarnDeviceFunctionListBean listBean);

    /**
     * @author chujialin
     * @date 2020/7/14 13:31
     **/
    @PostMapping("/SearchWarnUnReadMessage.do")
    ViewBean<RoomWithWarnListBean> searchWarnUnReadMessage(@RequestParam("houseId") long houseId);

    /**
     * @author chujialin
     * @date 2020/7/30 9:04
     **/
    @PostMapping("/SearchWarnFunctionList.do")
    ViewBean<WarnDeviceFunctionListBean> searchWarnFunctionList(@RequestParam("warnId") long warnId);

    /**
     * @author chujialin
     * @date 2020/7/14 13:31
     **/
    @PostMapping("/ConfirmDeviceWarn.do")
    ViewBean confirmDeviceWarn(@RequestParam("houseId") long houseId,
                               @RequestParam("roomId") long roomId);

    /**
     * @author chujialin
     * @date 2020/7/14 13:31
     **/
    @PostMapping("/EditWarnRecord.do")
    ViewBean<WarnSettingBean> editWarnRecord(@RequestParam("mac") String mac,
                                             @RequestParam("code") String code);
}
