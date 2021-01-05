package com.pony.sc_home_personal.service.personal;

import com.pony.sc_home_personal.bean.base.RelayBean;
import com.pony.sc_home_personal.bean.response.RelayHouseRoomInitBean;
import com.pony.sc_home_personal.bean.response.RelayHouseRoomPageBean;
import com.pony.sc_home_personal.bean.response.RelayInitBean;
import com.pony.sc_home_personal.bean.response.RelayListBean;
import com.pony.sc_home_personal.common.ViewBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hanshuang
 * @date 2020/06/30 13:54
 **/
@FeignClient(name = "sp-home-personal")
@RequestMapping("/Relay")
public interface RelayFeign {

    /**
     * @author hanshuang
     * @date 2020/06/30 14:04
     **/
    @PostMapping("/SearchRelayPageInit.do")
    ViewBean<RelayHouseRoomInitBean> searchRelayPageInit(@RequestParam("functionType") int functionType,
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
     * @date 2020/06/30 14:04
     **/
    @PostMapping("/SearchRelayPage.do")
    ViewBean<RelayHouseRoomPageBean> searchRelayPage(@RequestParam("functionType") int functionType,
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
     * @date 2020/07/06 11:28
     **/
    @PostMapping("/SearchRelayPageByRoomId.do")
    ViewBean<RelayHouseRoomPageBean> searchRelayPageByRoomId(@RequestParam("houseId") long houseId,
                                                             @RequestParam("roomId") long roomId,
                                                             @RequestParam("currentPage") int currentPage,
                                                             @RequestParam("everyPage") int everyPage);

    /**
     * @author hanshuang
     * @date 2020/06/30 14:08
     **/
    @PostMapping("/SearchRelayListByHouseIdAndRoomId.do")
    ViewBean<RelayListBean> searchRelayListByHouseIdAndRoomId(@RequestParam("functionType") int functionType,
                                                              @RequestParam("houseId") long houseId,
                                                              @RequestParam("roomId") long roomId);

    /**
     * @author hanshuang
     * @date 2020/06/30 15:52
     **/
    @PostMapping("/SearchRelayByMac.do")
    ViewBean<RelayBean> SearchRelayByMac(@RequestParam("mac") String mac);

    /**
     * @author hanshuang
     * @date 2020/06/30 14:17
     **/
    @PostMapping("/EditRelayInit.do")
    ViewBean<RelayInitBean> editRelayInit(@RequestParam("id") long id);

    /**
     * @author hanshuang
     * @date 2020/06/30 14:17
     **/
    @PostMapping("/EditRelayInitByHouseId.do")
    ViewBean<RelayInitBean> editRelayInitByHouseId(@RequestParam("houseId") long houseId);

    /**
     * @author hanshuang
     * @date 2020/06/30 14:22
     **/
    @PostMapping("/EditRelay.do")
    ViewBean<Long> editRelay(@RequestParam("id") long id,
                             @RequestParam("houseId") long houseId,
                             @RequestParam("roomId") long roomId,
                             @RequestParam("type") int type,
                             @RequestParam("mac") String mac,
                             @RequestParam("editionId") long editionId);

    /**
     * @author hanshuang
     * @date 2020/06/30 14:24
     **/
    @PostMapping("/DeleteRelay.do")
    ViewBean deleteRelay(@RequestParam("id") long id);
}
