package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.base.CustomerBean;
import com.pony.sc_home_personal.bean.response.LoginCustomerBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ResultStatus;
import com.pony.sc_home_personal.common.TokenBean;
import com.pony.sc_home_personal.common.ViewBean;
import com.pony.sc_home_personal.service.personal.CustomerLoginFeign;
import com.pony.sc_home_personal.util.PathUtil;
import com.pony.sc_home_personal.util.RedisUtil;
import com.pony.sc_home_personal.util.SendSmsUtil;
import com.pony.sc_home_personal.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chujialin
 * @date 2020/3/25 11:14
 **/
@Component
public class CustomerLoginFacadeImpl implements CustomerLoginFacade {

    @Resource
    private CustomerLoginFeign customerLoginFeign;

    private final RedisUtil redisUtil;

    @Autowired
    public CustomerLoginFacadeImpl(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Override
    public ResponseResult<LoginCustomerBean> loginByAccountsAndPassword(String accounts, String password) {
        ViewBean<LoginCustomerBean> viewBean = customerLoginFeign.loginByAccountsAndPassword(accounts, password);
        if (viewBean.getCode() == ResultStatus.SUCCESS_LOGIN.getCode()) {
            CustomerBean customerBean = viewBean.getData().getCustomerBean();
            if (customerBean.getImg() != null && customerBean.getImg().length() > 0) {
                customerBean.setImg(PathUtil.getEsPath() + PathUtil.customerImgPath + customerBean.getImg());
            }
            viewBean.getData().setTokenBean(TokenBean.of(
                    2, customerBean.getId(), TokenUtil.createToken(2, String.valueOf(customerBean.getId()))));
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<LoginCustomerBean> loginByToken(long userId, String token) {
        TokenUtil.deleteToken(token);
        ViewBean<LoginCustomerBean> viewBean = customerLoginFeign.loginByCustomerId(userId);
        if (viewBean.getCode() == ResultStatus.SUCCESS_LOGIN.getCode()) {
            CustomerBean customerBean = viewBean.getData().getCustomerBean();
            if (customerBean.getImg() != null && customerBean.getImg().length() > 0) {
                customerBean.setImg(PathUtil.getEsPath() + PathUtil.customerImgPath + customerBean.getImg());
            }
            viewBean.getData().setTokenBean(TokenBean.of(2, userId, TokenUtil.createToken(2, String.valueOf(userId))));
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<LoginCustomerBean> loginByMobile(String mobile, String verifyCode) {
        Map<String, String> stringMap = redisUtil.get(mobile);
        //验证码已过期
        if (stringMap.isEmpty()) {
            return ResponseResult.success(ResultStatus.EXISTENT_VERIFY_PAST_DUE.getCode(), null);
        }
        //验证码错误
        if (stringMap.get("verifyCode") == null || !stringMap.get("verifyCode").equals(verifyCode)) {
            return ResponseResult.success(ResultStatus.EXISTENT_VERIFY.getCode(), null);
        }
        redisUtil.delete(mobile);
        ViewBean<LoginCustomerBean> viewBean = customerLoginFeign.loginByMobile(mobile);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult registerByMobile(String mobile, String verifyCode, String password) {
        Map<String, String> stringMap = redisUtil.get(mobile);
        //验证码已过期
        if (stringMap.isEmpty()) {
            return ResponseResult.success(ResultStatus.EXISTENT_VERIFY_PAST_DUE.getCode(), null);
        }
        //验证码错误
        if (stringMap.get("verifyCode") == null || !stringMap.get("verifyCode").equals(verifyCode)) {
            return ResponseResult.success(ResultStatus.EXISTENT_VERIFY.getCode(), null);
        }
        redisUtil.delete(mobile);
        ViewBean viewBean = customerLoginFeign.registerByMobile(mobile, password);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult forgetPassword(String mobile, String verifyCode, String password) {
        Map<String, String> stringMap = redisUtil.get(mobile);
        //验证码已过期
        if (stringMap.isEmpty()) {
            return ResponseResult.success(ResultStatus.EXISTENT_VERIFY_PAST_DUE.getCode(), null);
        }
        //验证码错误
        if (stringMap.get("verifyCode") == null || !stringMap.get("verifyCode").equals(verifyCode)) {
            return ResponseResult.success(ResultStatus.EXISTENT_VERIFY.getCode(), null);
        }
        redisUtil.delete(mobile);
        ViewBean viewBean = customerLoginFeign.forgetPassword(mobile, password);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult editLoginPassword(long id, String oldPassword, String newPassword) {
        ViewBean viewBean = customerLoginFeign.editLoginPassword(id, oldPassword, newPassword);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult existsByAccounts(String accounts) {
        ViewBean viewBean = customerLoginFeign.existsByAccounts(accounts);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult existsByMobile(String mobile) {
        ViewBean viewBean = customerLoginFeign.existsByMobile(mobile);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult sendSms(String mobile) {
        String verifyCode = SendSmsUtil.sendSms(mobile);
        redisUtil.save(mobile, new HashMap<String, String>() {{
            put("verifyCode", verifyCode);
        }}, 300);
        return ResponseResult.success(ResultStatus.SUCCESS_SEND_SMS.getCode(), null);
    }
}
