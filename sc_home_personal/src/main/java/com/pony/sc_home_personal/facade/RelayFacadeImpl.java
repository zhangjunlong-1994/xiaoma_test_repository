package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.base.RelayBean;
import com.pony.sc_home_personal.bean.response.RelayHouseRoomInitBean;
import com.pony.sc_home_personal.bean.response.RelayHouseRoomPageBean;
import com.pony.sc_home_personal.bean.response.RelayInitBean;
import com.pony.sc_home_personal.bean.response.RelayListBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ViewBean;
import com.pony.sc_home_personal.service.personal.RelayFeign;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author hanshuang
 * @date 2020/06/30 13:40
 **/
@Component
public class RelayFacadeImpl implements RelayFacade {

    @Resource
    private RelayFeign relayFeign;

    @Override
    public ResponseResult<RelayHouseRoomInitBean> searchRelayPageInit(int code, String province, String city, String region, String communityName,
                                                                      long customerId, long houseId, long roomId, int currentPage, int everyPage) {
        ViewBean<RelayHouseRoomInitBean> viewBean = relayFeign.searchRelayPageInit(
                code, province, city, region, communityName, customerId, houseId, roomId, currentPage, everyPage);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<RelayHouseRoomPageBean> searchRelayByPage(int code, String province, String city, String region, String communityName,
                                                                    long customerId, long houseId, long roomId, int currentPage, int everyPage) {
        ViewBean<RelayHouseRoomPageBean> viewBean = relayFeign.searchRelayPage(
                code, province, city, region, communityName, customerId, houseId, roomId, currentPage, everyPage);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<RelayHouseRoomPageBean> searchRelayPageByRoomId(long houseId, long roomId, int currentPage, int everyPage) {
        ViewBean<RelayHouseRoomPageBean> viewBean = relayFeign.searchRelayPageByRoomId(houseId, roomId, currentPage, everyPage);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<RelayListBean> searchRelayListByHouseIdAndRoomId(int code, long houseId, long roomId) {
        ViewBean<RelayListBean> viewBean = relayFeign.searchRelayListByHouseIdAndRoomId(code, houseId, roomId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<RelayBean> searchRelayByMac(String mac) {
        ViewBean<RelayBean> viewBean = relayFeign.SearchRelayByMac(mac);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<RelayInitBean> editRelayInit(long id) {
        ViewBean<RelayInitBean> viewBean = relayFeign.editRelayInit(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<RelayInitBean> editRelayInitByHouseId(long houseId) {
        ViewBean<RelayInitBean> viewBean = relayFeign.editRelayInitByHouseId(houseId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<Long> editRelay(long id, long houseId, long roomId, int type, String mac, long editionId) {
        ViewBean<Long> viewBean = relayFeign.editRelay(id, houseId, roomId, type, mac, editionId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult deleteRelay(long id) {
        ViewBean viewBean = relayFeign.deleteRelay(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }
}
