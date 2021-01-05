package com.pony.sc_home_personal.service.personal;

import com.pony.sc_home_personal.bean.response.LoginCustomerBean;
import com.pony.sc_home_personal.common.ViewBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chujialin
 * @date 2020/3/25 14:18
 **/
@FeignClient(name = "sp-home-personal")
@RequestMapping("/CustomerLogin")
public interface CustomerLoginFeign {

    /**
     * @author chujialin
     * @date 2020/3/25 14:18
     **/
    @PostMapping("/LoginByAccountsAndPassword.do")
    ViewBean<LoginCustomerBean> loginByAccountsAndPassword(@RequestParam("accounts") String accounts,
                                                           @RequestParam("password") String password);

    /**
     * @author liuwenbo
     * @date 2020/7/16 16:14
     **/
    @PostMapping("/LoginByCustomerId.do")
    ViewBean<LoginCustomerBean> loginByCustomerId(@RequestParam("customerId") long customerId);

    /**
     * @author hanshuang
     * @date 2020/06/23 9:21
     **/
    @PostMapping("/LoginByMobile.do")
    ViewBean<LoginCustomerBean> loginByMobile(@RequestParam("mobile") String mobile);

    /**
     * @author hanshuang
     * @date 2020/06/23 9:19
     **/
    @PostMapping("/RegisterByMobile.do")
    ViewBean registerByMobile(@RequestParam("mobile") String mobile,
                              @RequestParam("password") String password);

    /**
     * @author chujialin
     * @date 2020/3/25 14:20
     **/
    @PostMapping("/EditLoginPassword.do")
    ViewBean editLoginPassword(@RequestParam("id") long id,
                               @RequestParam("oldPassword") String oldPassword,
                               @RequestParam("newPassword") String newPassword);

    /**
     * @author hanshuang
     * @date 2020/06/23 9:20
     **/
    @PostMapping("/ForgetPassword.do")
    ViewBean forgetPassword(@RequestParam("mobile") String mobile,
                            @RequestParam("password") String password);

    /**
     * @author haozhongyu
     * @date 2019/11/26 14:56
     **/
    @PostMapping("/ExistsByAccounts.do")
    ViewBean existsByAccounts(@RequestParam("accounts") String accounts);

    /**
     * @author liuwenbo
     * @date 2020/7/16 9:47
     **/
    @PostMapping("/ExistsByMobile.do")
    ViewBean existsByMobile(@RequestParam("mobile") String mobile);
}
