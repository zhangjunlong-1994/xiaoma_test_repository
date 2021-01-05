package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.bean.response.CustomerServiceAppMessageListBean;
import com.pony.sc_home_personal.bean.response.CustomerServiceMessageBean;
import com.pony.sc_home_personal.bean.response.CustomerServiceMessageListBean;
import com.pony.sc_home_personal.bean.response.StaffInstitutionAllInfoListBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.config.CheckToken;
import com.pony.sc_home_personal.facade.CustomerServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 客服（TODO：客服功能已暂停，准备迁移至共通模块，该controller不再维护）
 *
 * @author suntai
 * @date 2019/12/2 11:05
 */
@Deprecated
@RestController
@RequestMapping("/ScCustomerServer")
public class CustomerServiceController {

    private final CustomerServiceFacade customerServiceFacade;

    @Autowired
    public CustomerServiceController(CustomerServiceFacade customerServiceFacade) {
        this.customerServiceFacade = customerServiceFacade;
    }

    /**
     * @author suntai
     * @date 2019/12/2 11:13
     **/
    @Deprecated
    @CheckToken
    @PostMapping("/SearchCustomerMessageInit.do")
    public ResponseResult<CustomerServiceMessageListBean> searchCustomerMessageInit(@RequestParam String nameOrMobile) {
        return customerServiceFacade.searchCustomerMessageInit(nameOrMobile);
    }

    /**
     * @author suntai
     * @date 2019/12/2 13:41
     **/
    @Deprecated
    @CheckToken
    @PostMapping("/SearchCustomerMessageByCustomerId.do")
    public ResponseResult<CustomerServiceMessageBean> searchCustomerMessageByCustomerId(@RequestParam long customerId,
                                                                                        @RequestParam long manageId,
                                                                                        @RequestParam String name,
                                                                                        @RequestParam int currentPage,
                                                                                        @RequestParam int everyPage) {
        return customerServiceFacade.searchCustomerMessageByCustomerId(customerId, manageId, name, currentPage, everyPage);
    }

    /**
     * @author liuwenbo
     * @date 2020/7/13 13:36
     **/
    @Deprecated
    @CheckToken
    @PostMapping("/SearchAppCustomerMessageByCustomerId.do")
    public ResponseResult<CustomerServiceAppMessageListBean> searchAppCustomerMessageByCustomerId(HttpServletRequest request,
                                                                                                  @RequestParam int currentPage,
                                                                                                  @RequestParam int everyPage) {
        long customerId = Long.parseLong(String.valueOf(request.getAttribute("userId")));
        return customerServiceFacade.searchAppCustomerMessageByCustomerId(customerId, currentPage, everyPage);
    }

    /**
     * @author chujialin
     * @date 2020/4/29 13:03
     **/
    @Deprecated
    @CheckToken
    @PostMapping("/EditMessageReaded.do")
    public ResponseResult editMessageReaded(@RequestParam long customerId) {
        return customerServiceFacade.editMessageReaded(customerId, 2);
    }

    /**
     * @author liuwenbo
     * @date 2020/7/13 13:37
     **/
    @Deprecated
    @CheckToken
    @PostMapping("/EditAppMessageReaded.do")
    public ResponseResult editAppMessageReaded(HttpServletRequest request) {
        long customerId = Long.parseLong(String.valueOf(request.getAttribute("userId")));
        return customerServiceFacade.editMessageReaded(customerId, 1);
    }

    /**
     * @author hanshuang
     * @date 2020/07/10 14:53
     **/
    @Deprecated
    @CheckToken
    @PostMapping("/SearchCustomerServerList.do")
    public ResponseResult<StaffInstitutionAllInfoListBean> searchCustomerServerList() {
        return customerServiceFacade.searchCustomerServerList();
    }
}
