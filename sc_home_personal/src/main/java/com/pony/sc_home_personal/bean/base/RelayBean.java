package com.pony.sc_home_personal.bean.base;

import lombok.Data;

/**
 * @author hanshuang
 * @date 2020/06/30 9:59
 **/
@Data
public class RelayBean {

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
}
