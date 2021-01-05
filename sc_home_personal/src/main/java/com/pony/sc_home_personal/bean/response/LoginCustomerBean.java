package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.CustomerBean;
import com.pony.sc_home_personal.bean.base.LoginBean;
import com.pony.sc_home_personal.common.TokenBean;
import lombok.Data;

/**
 * @author chujialin
 * @date 2020/3/25 11:32
 **/
@Data
public class LoginCustomerBean {

    private CustomerBean customerBean;
    private LoginBean loginBean;
    private TokenBean tokenBean;
}
