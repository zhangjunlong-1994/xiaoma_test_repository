package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.bean.response.LoginCustomerBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.config.CheckToken;
import com.pony.sc_home_personal.facade.CustomerLoginFacade;
import com.pony.sc_home_personal.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户登录
 *
 * @author chujialin
 * @date 2020/3/25 11:01
 **/
@RestController
@RequestMapping("/ScCustomerLogin")
public class CustomerLoginController {

    private final CustomerLoginFacade customerLoginFacade;

    @Autowired
    public CustomerLoginController(CustomerLoginFacade customerLoginFacade) {
        this.customerLoginFacade = customerLoginFacade;
    }

    /**
     * 使用账号、密码登录
     *
     * @param accounts 账号
     * @param password 密码
     * @author liuwenbo
     * @date 2020/7/13 10:10
     **/
    @PostMapping("/LoginByAccountsAndPassword.do")
    public ResponseResult<LoginCustomerBean> loginByAccountsAndPassword(@RequestParam String accounts,
                                                                        @RequestParam String password) {
        return customerLoginFacade.loginByAccountsAndPassword(accounts, password);
    }

    /**
     * 使用token登录
     *
     * @author liuwenbo
     * @date 2020/7/16 16:08
     **/
    @CheckToken
    @PostMapping("/LoginByToken.do")
    public ResponseResult<LoginCustomerBean> loginByToken(HttpServletRequest request) {
        String userId = String.valueOf(request.getAttribute("userId"));
        String token = String.valueOf(request.getAttribute("token"));
        return customerLoginFacade.loginByToken(Long.valueOf(userId), token);
    }

    /**
     * 使用手机号登录（TODO：验证码功能未做，故该接口暂未使用）
     *
     * @param mobile     手机号
     * @param verifyCode 验证码
     * @author liuwenbo
     * @date 2020/7/13 10:13
     **/
    @PostMapping("/LoginByMobile.do")
    public ResponseResult<LoginCustomerBean> loginByMobile(@RequestParam String mobile,
                                                           @RequestParam String verifyCode) {
        return customerLoginFacade.loginByMobile(mobile, verifyCode);
    }

    /**
     * 使用手机号注册（TODO：验证码功能）
     *
     * @param mobile     手机号
     * @param verifyCode 验证码
     * @param password   密码
     * @author liuwenbo
     * @date 2020/7/13 10:12
     **/
    @PostMapping("/RegisterByMobile.do")
    public ResponseResult registerByMobile(@RequestParam String mobile,
                                           @RequestParam String verifyCode,
                                           @RequestParam String password) {
        return customerLoginFacade.registerByMobile(mobile, verifyCode, password);
    }

    /**
     * 修改登录密码
     *
     * @param id          用户Id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @author liuwenbo
     * @date 2020/7/13 10:11
     **/
    @CheckToken
    @PostMapping("/EditLoginPassword.do")
    public ResponseResult editLoginPassword(@RequestParam long id,
                                            @RequestParam String oldPassword,
                                            @RequestParam String newPassword) {
        return customerLoginFacade.editLoginPassword(id, oldPassword, newPassword);
    }

    /**
     * 忘记密码（TODO：验证码功能）
     *
     * @param mobile     手机号
     * @param verifyCode 验证码
     * @param password   新密码
     * @author liuwenbo
     * @date 2020/7/13 10:12
     **/
    @PostMapping("/ForgetPassword.do")
    public ResponseResult forgetPassword(@RequestParam String mobile,
                                         @RequestParam String verifyCode,
                                         @RequestParam String password) {
        return customerLoginFacade.forgetPassword(mobile, verifyCode, password);
    }

    /**
     * 验证账号是否存在
     *
     * @param accounts 账号
     * @author chujialin
     * @date 2020/3/25 15:26
     **/
    @PostMapping("/ExistsByAccounts.do")
    public ResponseResult existsByAccounts(@RequestParam String accounts) {
        return customerLoginFacade.existsByAccounts(accounts);
    }

    /**
     * 验证手机号是否存在
     *
     * @param mobile 手机号
     * @author liuwenbo
     * @date 2020/7/16 9:55
     **/
    @PostMapping("/ExistsByMobile.do")
    public ResponseResult existsByMobile(@RequestParam String mobile) {
        return customerLoginFacade.existsByMobile(mobile);
    }

    /**
     * 退出登录
     *
     * @author liuwenbo
     * @date 2020/7/13 10:12
     **/
    @CheckToken
    @PostMapping("/Logout.do")
    public void logout(HttpServletRequest request) {
        String token = String.valueOf(request.getAttribute("token"));
        TokenUtil.deleteToken(token);
    }

    /**
     * 发送验证码（TODO：短信平台未开通）
     *
     * @param mobile 手机号
     * @author liuwenbo
     * @date 2020/7/13 10:14
     **/
    @PostMapping("/SendSms.do")
    public ResponseResult sendSms(@RequestParam String mobile) {
        return customerLoginFacade.sendSms(mobile);
    }
}
