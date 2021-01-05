package com.pony.sc_home_personal.bean.base;

import lombok.Data;

@Data
public class HouseBean {

    private long id;
    private String province;
    private String city;
    private String region;
    private String community;
    private String building;
    private String unit;
    private String floor;
    private String num;
    private String layout;
    private double area;
    private String createDate;
    private String independentPassword;
}
