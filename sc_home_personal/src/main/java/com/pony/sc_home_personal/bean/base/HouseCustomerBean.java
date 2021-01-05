package com.pony.sc_home_personal.bean.base;

import lombok.Data;

@Data
public class HouseCustomerBean {

    private long customerId;
    private long houseId;
    private boolean defaultUse;
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
    private String customerName;
    private String mobile;
}
