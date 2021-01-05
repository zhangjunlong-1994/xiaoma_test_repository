package com.pony.sc_home_personal.bean.base;

import lombok.Data;

/**
 * @author suntai
 * @date 2019/11/26 14:57
 */
@Data
public class CentralBean {

    private long id;
    private String mac;
    private String createDate;
    private int state;
    private long editionId;
    private String softwareVersion;
    private String hardwareVersion;
    private String province;
    private String city;
    private String region;
    private String building;
    private String unit;
    private String floor;
    private String num;
    private String community;
}
