package com.pony.sc_home_personal.bean.base;

import lombok.Data;

@Data
public class DeviceBean {

    private long id;
    private long houseId;
    private long roomId;
    private String roomName;
    private long relayId;
    private String relayMac;
    private long typeId;
    private String typeName;
    private String typeNameEn;
    private String name;
    private int functionTypeValue;
    private String functionTypeText;
    private boolean alarm;
    private String createDate;
}
