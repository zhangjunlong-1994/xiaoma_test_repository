package com.pony.sc_home_personal.service.personal;

import com.pony.sc_home_personal.bean.response.CustomerInitBean;
import com.pony.sc_home_personal.bean.response.CustomerListBean;
import com.pony.sc_home_personal.bean.response.CustomerPageBean;
import com.pony.sc_home_personal.common.ViewBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sp-home-personal")
@RequestMapping("/Customer")
public interface CustomerManageFeign {

    /**
     * @author haozhongyu
     * @date 2019/12/13 16:47
     **/
    @PostMapping("/SearchCustomerPageById.do")
    ViewBean<CustomerPageBean> SearchCustomerPageById(@RequestParam("userId") long userId,
                                                      @RequestParam("currentPage") int currentPage,
                                                      @RequestParam("everyPage") int everyPage);

    /**
     * @author chujialin
     * @date 2020/3/30 14:37
     **/
    @PostMapping("/SearchCustomerListByNameOrMobile.do")
    ViewBean<CustomerListBean> searchCustomerListByNameOrMobile(@RequestParam("nameOrMobile") String nameOrMobile);

    /**
     * @author haozhongyu
     * @date 2019/11/18 17:40
     **/
    @PostMapping("/EditCustomerInit.do")
    ViewBean<CustomerInitBean> editCustomerInit(@RequestParam("id") long id);

    /**
     * @author haozhongyu
     * @date 2019/11/26 14:38
     **/
    @PostMapping("/EditCustomer.do")
    ViewBean editCustomer(@RequestParam("id") long id,
                          @RequestParam("name") String name,
                          @RequestParam("img") String img,
                          @RequestParam("mobile") String mobile,
                          @RequestParam("birth") String birth,
                          @RequestParam("sex") int sex,
                          @RequestParam("enabled") boolean enabled,
                          @RequestParam("accounts") String accounts);

    /**
     * @author haozhongyu
     * @date 2019/12/2 14:23
     **/
    @PostMapping("/EditCustomerEnabled.do")
    ViewBean editCustomerEnabled(@RequestParam("id") long id,
                                 @RequestParam("enabled") boolean enabled);

    /**
     * @author haozhongyu
     * @date 2019/11/26 14:56
     **/
    @PostMapping("/DeleteCustomer.do")
    ViewBean deleteCustomer(@RequestParam("id") long id);

    /**
     * @author hanshuang
     * @date 2020/06/24 14:50
     **/
    @PostMapping("/ResetPassword.do")
    ViewBean resetPassword(@RequestParam("id") long id);
}
