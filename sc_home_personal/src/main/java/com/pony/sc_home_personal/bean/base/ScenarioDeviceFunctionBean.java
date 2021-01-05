package com.pony.sc_home_personal.bean.base;

import lombok.Data;

@Data
public class ScenarioDeviceFunctionBean {

    private long scenarioId;
    private long functionId;
    private long houseId;
    private String name;
    private String nameEn;
    private boolean enabled;
    private String functionName;
    private String functionCode;
    private boolean alarm;
    private long deviceId;
    private String deviceName;
    private long relayId;
    private String relayMac;
    private String centralMac;
    private long deviceTypeId;
    private String deviceTypeName;
    private int functionTypeValue;
    private String functionTypeText;
    private long typeId;
    private String typeName;
    private long roomId;
    private int functionSort;
    private long functionDelay;
    private long scenarioFunctionId;
    private String roomName;
}
