package com.pony.sc_home_personal.bean.base;

import lombok.Data;

/**
 * @author hanshuang
 * @date 2020/07/24 11:27
 **/
@Data
public class DeviceFunctionManageBean {

    private long id;
    private long typeId;
    private String typeName;
    private String name;
    private boolean edit;
}
