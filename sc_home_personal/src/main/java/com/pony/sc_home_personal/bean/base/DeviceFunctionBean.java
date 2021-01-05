package com.pony.sc_home_personal.bean.base;

import lombok.Data;

@Data
public class DeviceFunctionBean {
    private long id;
    private long deviceId;
    private String name;
    private String code;
    private boolean alarm;
    private String createDate;
}
