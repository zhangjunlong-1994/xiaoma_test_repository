package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.base.RelayBean;
import com.pony.sc_home_personal.bean.response.RelayHouseRoomInitBean;
import com.pony.sc_home_personal.bean.response.RelayHouseRoomPageBean;
import com.pony.sc_home_personal.bean.response.RelayInitBean;
import com.pony.sc_home_personal.bean.response.RelayListBean;
import com.pony.sc_home_personal.common.ResponseResult;

/**
 * @author hanshuang
 * @date 2020/06/30 13:40
 **/
public interface RelayFacade {

    /**
     * @author hanshuang
     * @date 2020/06/30 13:48
     **/
    ResponseResult<RelayHouseRoomInitBean> searchRelayPageInit(int functionType, String province, String city, String region, String communityName,
                                                               long customerId, long houseId, long roomId, int currentPage, int everyPage);

    /**
     * @author hanshuang
     * @date 2020/06/30 13:48
     **/
    ResponseResult<RelayHouseRoomPageBean> searchRelayByPage(int functionType, String province, String city, String region, String communityName,
                                                             long customerId, long houseId, long roomId, int currentPage, int everyPage);

    /**
     * @author hanshuang
     * @date 2020/07/06 11:27
     **/
    ResponseResult<RelayHouseRoomPageBean> searchRelayPageByRoomId(long houseId, long roomId, int currentPage, int everyPage);

    /**
     * @author hanshuang
     * @date 2020/06/30 14:06
     **/
    ResponseResult<RelayListBean> searchRelayListByHouseIdAndRoomId(int functionType, long houseId, long roomId);

    /**
     * @author hanshuang
     * @date 2020/06/30 15:51
     **/
    ResponseResult<RelayBean> searchRelayByMac(String mac);

    /**
     * @author hanshuang
     * @date 2020/06/30 14:17
     **/
    ResponseResult<RelayInitBean> editRelayInit(long id);

    /**
     * @author hanshuang
     * @date 2020/06/30 14:17
     **/
    ResponseResult<RelayInitBean> editRelayInitByHouseId(long houseId);

    /**
     * @author hanshuang
     * @date 2020/06/30 14:21
     **/
    ResponseResult<Long> editRelay(long id, long houseId, long roomId, int type, String mac, long editionId);

    /**
     * @author hanshuang
     * @date 2020/06/30 14:24
     **/
    ResponseResult deleteRelay(long id);
}
