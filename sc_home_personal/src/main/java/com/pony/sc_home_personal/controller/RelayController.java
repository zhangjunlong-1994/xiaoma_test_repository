package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.bean.base.RelayBean;
import com.pony.sc_home_personal.bean.response.RelayHouseRoomInitBean;
import com.pony.sc_home_personal.bean.response.RelayHouseRoomPageBean;
import com.pony.sc_home_personal.bean.response.RelayInitBean;
import com.pony.sc_home_personal.bean.response.RelayListBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.config.CheckToken;
import com.pony.sc_home_personal.facade.RelayFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 中继
 *
 * @author hanshuang
 * @date 2020/06/30 13:38
 **/
@RestController
@RequestMapping("/ScRelay")
public class RelayController {

    @Resource
    private RelayFacade relayFacade;

    /**
     * 获取中继分页列表初始化
     *
     * @param functionType  功能类型（红外、射频433、射频315）
     * @param province      省份
     * @param city          市
     * @param region        区县
     * @param communityName 小区
     * @param customerId    用户Id
     * @param houseId       房产Id
     * @param roomId        房间Id
     * @param currentPage   当前页数（从0开始）
     * @param everyPage     每页条数
     * @author hanshuang
     * @date 2020/06/30 13:45
     **/
    @CheckToken
    @PostMapping("/SearchRelayPageInit.do")
    public ResponseResult<RelayHouseRoomInitBean> searchRelayPageInit(@RequestParam int functionType,
                                                                      @RequestParam String province,
                                                                      @RequestParam String city,
                                                                      @RequestParam String region,
                                                                      @RequestParam String communityName,
                                                                      @RequestParam long customerId,
                                                                      @RequestParam long houseId,
                                                                      @RequestParam long roomId,
                                                                      @RequestParam int currentPage,
                                                                      @RequestParam int everyPage) {
        return relayFacade.searchRelayPageInit(functionType, province, city, region, communityName, customerId, houseId, roomId, currentPage, everyPage);
    }

    /**
     * 获取中继分页列表
     *
     * @param functionType  功能类型（红外、射频433、射频315）
     * @param province      省份
     * @param city          市
     * @param region        区县
     * @param communityName 小区
     * @param customerId    用户Id
     * @param houseId       房产Id
     * @param roomId        房间Id
     * @param currentPage   当前页数（从0开始）
     * @param everyPage     每页条数
     * @author hanshuang
     * @date 2020/06/30 13:45
     **/
    @CheckToken
    @PostMapping("/SearchRelayPage.do")
    public ResponseResult<RelayHouseRoomPageBean> searchRelayPage(@RequestParam int functionType,
                                                                  @RequestParam String province,
                                                                  @RequestParam String city,
                                                                  @RequestParam String region,
                                                                  @RequestParam String communityName,
                                                                  @RequestParam long customerId,
                                                                  @RequestParam long houseId,
                                                                  @RequestParam long roomId,
                                                                  @RequestParam int currentPage,
                                                                  @RequestParam int everyPage) {
        return relayFacade.searchRelayByPage(functionType, province, city, region, communityName, customerId, houseId, roomId, currentPage, everyPage);
    }

    /**
     * 获取中继分页列表
     *
     * @param houseId     房产Id
     * @param roomId      房间Id
     * @param currentPage 当前页数（从0开始）
     * @param everyPage   每页条数
     * @author hanshuang
     * @date 2020/07/06 11:26
     **/
    @PostMapping("/SearchRelayPageByRoomId.do")
    public ResponseResult<RelayHouseRoomPageBean> searchRelayPageByRoomId(@RequestParam long houseId,
                                                                          @RequestParam long roomId,
                                                                          @RequestParam int currentPage,
                                                                          @RequestParam int everyPage) {
        return relayFacade.searchRelayPageByRoomId(houseId, roomId, currentPage, everyPage);
    }

    /**
     * 获取中继列表
     *
     * @param functionType 功能类型（红外、射频433、射频315）
     * @param houseId      房产Id
     * @param roomId       房间Id
     * @author hanshuang
     * @date 2020/06/30 14:15
     **/
    @CheckToken
    @PostMapping("/SearchRelayListByHouseIdAndRoomId.do")
    public ResponseResult<RelayListBean> searchRelayListByHouseIdAndRoomId(@RequestParam int functionType,
                                                                           @RequestParam long houseId,
                                                                           @RequestParam long roomId) {
        return relayFacade.searchRelayListByHouseIdAndRoomId(functionType, houseId, roomId);
    }

    /**
     * 根据mac地址，获取中继
     *
     * @param mac 中继mac地址
     * @author hanshuang
     * @date 2020/06/30 15:50
     **/
    @CheckToken
    @PostMapping("/SearchRelayByMac.do")
    public ResponseResult<RelayBean> searchRelayByMac(@RequestParam String mac) {
        return relayFacade.searchRelayByMac(mac);
    }

    /**
     * 编辑中继初始化
     *
     * @param id 中继Id
     * @author hanshuang
     * @date 2020/06/30 14:15
     **/
    @CheckToken
    @PostMapping("/EditRelayInit.do")
    public ResponseResult<RelayInitBean> editRelayInit(@RequestParam long id) {
        return relayFacade.editRelayInit(id);
    }

    /**
     * 根据房产Id，编辑中继初始化
     *
     * @param houseId 房产Id
     * @author hanshuang
     * @date 2020/06/30 14:15
     **/
    @CheckToken
    @PostMapping("/EditRelayInitByHouseId.do")
    public ResponseResult<RelayInitBean> editRelayInitByHouseId(@RequestParam long houseId) {
        return relayFacade.editRelayInitByHouseId(houseId);
    }

    /**
     * 编辑中继
     *
     * @param id        中继Id
     * @param houseId   房产Id
     * @param roomId    房间Id
     * @param type      中继类别
     * @param mac       中继mac地址
     * @param editionId 版本Id
     * @author hanshuang
     * @date 2020/06/30 14:18
     **/
    @CheckToken
    @PostMapping("/EditRelay.do")
    public ResponseResult<Long> editRelay(@RequestParam long id,
                                          @RequestParam long houseId,
                                          @RequestParam long roomId,
                                          @RequestParam int type,
                                          @RequestParam String mac,
                                          @RequestParam long editionId) {
        return relayFacade.editRelay(id, houseId, roomId, type, mac, editionId);
    }

    /**
     * 删除中继
     *
     * @param id 中继Id
     * @author hanshuang
     * @date 2020/06/30 13:21
     **/
    @CheckToken
    @PostMapping("/DeleteRelay.do")
    public ResponseResult deleteRelay(@RequestParam long id) {
        return relayFacade.deleteRelay(id);
    }
}
