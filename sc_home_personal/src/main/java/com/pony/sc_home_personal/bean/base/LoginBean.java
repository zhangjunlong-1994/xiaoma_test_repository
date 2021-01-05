package com.pony.sc_home_personal.bean.base;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginBean implements Serializable{

    private long id;
    private String accounts;
    private String password;
    private String mobile;
    private int typeValue;
    private String typeText;
    private String unionid;
    private String openid;
    private boolean enabled;
}
