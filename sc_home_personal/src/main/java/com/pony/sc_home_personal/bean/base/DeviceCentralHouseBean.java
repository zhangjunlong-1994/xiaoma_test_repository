package com.pony.sc_home_personal.bean.base;

import lombok.Data;

@Data
public class DeviceCentralHouseBean {

    private long id;
    private String name;
    private long typeId;
    private String typeName;
    private boolean alarm;
    private long houseId;
    private String province;
    private String city;
    private String region;
    private String community;
    private String building;
    private String unit;
    private String floor;
    private String num;
    private long roomId;
    private String roomName;
    private long relayId;
    private String relayMac;
    private int functionTypeValue;
    private String functionTypeText;
    private String createDate;
}
