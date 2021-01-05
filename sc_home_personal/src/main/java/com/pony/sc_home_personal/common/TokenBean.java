package com.pony.sc_home_personal.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class TokenBean implements Serializable{

    private int userType;
    private long userId;
    private String token;

    public static TokenBean of(int type, long id, String token) {
        TokenBean tokenBean = new TokenBean();
        tokenBean.setUserType(type);
        tokenBean.setUserId(id);
        tokenBean.setToken(token);
        return tokenBean;
    }
}
