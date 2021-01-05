package com.pony.sc_home_personal.bean.base;

import lombok.Data;

/**
 * @author wenxufeng
 * @date 2019/12/11 14:54
 **/
@Data
public class ScenarioHouseBean {

    private long id;
    private String name;
    private long typeId;
    private String typeName;
    private boolean enabled;
    private long houseId;
    private String province;
    private String city;
    private String region;
    private String community;
    private String building;
    private String unit;
    private String floor;
    private String num;
    private String centralMac;
}
