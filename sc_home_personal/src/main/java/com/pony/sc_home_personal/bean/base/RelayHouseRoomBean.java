package com.pony.sc_home_personal.bean.base;

import lombok.Data;

/**
 * @author hanshuang
 * @date 2020/06/30 10:09
 **/
@Data
public class RelayHouseRoomBean {

    private long id;
    private long houseId;
    private long roomId;
    private int type;
    private String typeText;
    private String mac;
    private long editionId;
    private String softwareVersion;
    private String hardwareVersion;
    private String createDate;
    private String province;
    private String city;
    private String region;
    private String community;
    private String building;
    private String unit;
    private String floor;
    private String num;
    private String roomName;
}
