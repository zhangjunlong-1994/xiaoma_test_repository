package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.base.CustomerServiceBean;
import com.pony.sc_home_personal.bean.response.CustomerServiceAppMessageListBean;
import com.pony.sc_home_personal.bean.response.CustomerServiceMessageBean;
import com.pony.sc_home_personal.bean.response.CustomerServiceMessageListBean;
import com.pony.sc_home_personal.bean.response.StaffInstitutionAllInfoListBean;
import com.pony.sc_home_personal.common.ResponseResult;

/**
 * @author suntai
 * @date 2019/12/2 10:58
 */
public interface CustomerServiceFacade {

    /**
     * @author suntai
     * @date 2019/11/21 13:34
     **/
    ResponseResult<CustomerServiceMessageListBean> searchCustomerMessageInit(String nameOrMobile);

    /**
     * @author suntai
     * @date 2019/12/2 13:11
     **/
    ResponseResult<CustomerServiceMessageBean> searchCustomerMessageByCustomerId(
            long customerId, long manageId, String name, int currentPage, int everyPage);

    /**
     * @author suntai
     * @date 2019/12/2 13:11
     **/
    ResponseResult<CustomerServiceAppMessageListBean> searchAppCustomerMessageByCustomerId(long customerId, int currentPage, int everyPage);

    /**
     * @author chujialin
     * @date 2020/4/29 13:01
     **/
    ResponseResult editMessageReaded(long customerId, int sender);

    /**
     * @author hanshuang
     * @date 2020/07/10 14:55
     **/
    ResponseResult<StaffInstitutionAllInfoListBean> searchCustomerServerList();

    /**
     * @author suntai
     * @date 2019/11/21 15:22
     **/
    ResponseResult<CustomerServiceBean> editCustomerServiceMessage(long manageId, long customerId, int sender, int type, String content);
}
