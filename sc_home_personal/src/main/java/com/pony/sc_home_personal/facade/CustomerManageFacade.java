package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.response.CustomerInitBean;
import com.pony.sc_home_personal.bean.response.CustomerListBean;
import com.pony.sc_home_personal.bean.response.CustomerPageBean;
import com.pony.sc_home_personal.common.ResponseResult;

/**
 * @author haozhongyu
 * @date 2019/11/26 14:28
 **/
public interface CustomerManageFacade {

    /**
     * @author chujialin
     * @date 2020/3/24 15:12
     **/
    ResponseResult<CustomerPageBean> SearchCustomerPageById(long userId, int currentPage, int everyPage);

    /**
     * @author chujialin
     * @date 2020/3/24 15:12
     **/
    ResponseResult<CustomerListBean> SearchCustomerListByNameOrMobile(String nameOrMobile);

    /**
     * @author haozhongyu
     * @date 2019/11/26 14:43
     **/
    ResponseResult<CustomerInitBean> editCustomerInit(long id);

    /**
     * @author haozhongyu
     * @date 2019/11/26 14:52
     **/
    ResponseResult editCustomer(long id, String name, String img, String mobile, String birth, int sex, boolean enabled, String accounts);

    /**
     * @author chujialin
     * @date 2020/3/24 16:52
     **/
    ResponseResult editCustomerEnabled(long id, boolean enabled);

    /**
     * @author haozhongyu
     * @date 2019/11/26 14:55
     **/
    ResponseResult deleteCustomer(long id);

    /**
     * @author hanshuang
     * @date 2020/06/24 14:49
     **/
    ResponseResult resetPassword(long id);
}
