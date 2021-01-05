package com.pony.sc_home_personal.bean.base;

import lombok.Data;

/**
 * @author wenxufeng
 * @date 2020/1/7 11:05
 **/
@Data
public class WarnDeviceFunctionBean {

    private long warnId;
    private long functionId;
    private String message;
    private boolean inDanger;
    private int executeTypeValue;
    private String executeTypeText;
    private long scenarioId;
    private long deviceId;
    private String functionName;
    private String functionCode;
    private String deviceName;
    private long relayId;
    private String relayMac;
    private int functionType;
    private String functionTypeText;
    private long deviceTypeId;
    private String deviceTypeName;
    private int functionSort;
    private long functionDelay;
    private long warnFunctionId;
    private String roomName;
    private long roomId;
}
