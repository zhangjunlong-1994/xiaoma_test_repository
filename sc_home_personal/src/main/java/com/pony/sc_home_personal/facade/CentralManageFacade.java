package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.base.CentralBean;
import com.pony.sc_home_personal.bean.response.CentralInitBean;
import com.pony.sc_home_personal.bean.response.CentralListBean;
import com.pony.sc_home_personal.bean.response.CentralPageBean;
import com.pony.sc_home_personal.common.ResponseResult;

/**
 * @author suntai
 * @date 2019/11/26 15:02
 */
public interface CentralManageFacade {

    /**
     * @author suntai
     * @date 2019/11/26 15:01
     **/
    ResponseResult<CentralPageBean> searchPage(String province, String city, String region, String communityName,
                                               long customerId, int currentPage, int everyPage);

    /**
     * @author chujialin
     * @date 2020/10/9 10:32
     **/
    ResponseResult<CentralListBean> searchListByCustomerId(long customerId);

    /**
     * @author suntai
     * @date 2019/11/28 13:04
     **/
    ResponseResult<CentralBean> searchByHouseId(long houseId);

    /**
     * @author chujialin
     * @date 2020/4/2 11:31
     **/
    ResponseResult<CentralBean> searchByMac(String mac);

    /**
     * @author suntai
     * @date 2019/11/26 14:57
     **/
    ResponseResult<CentralInitBean> editCentralInit(long id);

    /**
     * @author suntai
     * @date 2019/11/26 14:56
     **/
    ResponseResult editCentral(long id, String mac, int state, long editionId);

    /**
     * @author suntai
     * @date 2019/11/26 14:58
     **/
    ResponseResult deleteCentral(long id);
}
