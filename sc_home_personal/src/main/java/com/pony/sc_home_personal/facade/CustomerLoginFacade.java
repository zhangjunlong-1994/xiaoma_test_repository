package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.response.LoginCustomerBean;
import com.pony.sc_home_personal.common.ResponseResult;

/**
 * @author chujialin
 * @date 2020/3/25 11:02
 **/
public interface CustomerLoginFacade {

    /**
     * @author chujialin
     * @date 2020/3/25 12:43
     **/
    ResponseResult<LoginCustomerBean> loginByAccountsAndPassword(String accounts, String password);

    /**
     * @author liuwenbo
     * @date 2020/7/16 16:08
     **/
    ResponseResult<LoginCustomerBean> loginByToken(long userId, String token);

    /**
     * @author hanshuang
     * @date 2020/06/23 9:16
     **/
    ResponseResult<LoginCustomerBean> loginByMobile(String mobile, String verifyCode);

    /**
     * @author hanshuang
     * @date 2020/06/23 9:14
     **/
    ResponseResult registerByMobile(String mobile, String verifyCode, String password);

    /**
     * @author chujialin
     * @date 2020/3/25 12:43
     **/
    ResponseResult editLoginPassword(long id, String oldPassword, String newPassword);

    /**
     * @author hanshuang
     * @date 2020/06/23 9:15
     **/
    ResponseResult forgetPassword(String mobile, String verifyCode, String password);

    /**
     * @author chujialin
     * @date 2020/3/25 12:43
     **/
    ResponseResult existsByAccounts(String accounts);

    /**
     * @author liuwenbo
     * @date 2020/7/16 9:49
     **/
    ResponseResult existsByMobile(String mobile);

    /**
     * @author chujialin
     * @date 2020/7/28 15:22
     **/
    ResponseResult sendSms(String mobile);
}
