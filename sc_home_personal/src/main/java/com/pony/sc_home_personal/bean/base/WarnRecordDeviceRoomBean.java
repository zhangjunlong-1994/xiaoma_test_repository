package com.pony.sc_home_personal.bean.base;

import lombok.Data;

/**
 * @author chujialin
 * @date 2020/4/30 16:38
 **/
@Data
public class WarnRecordDeviceRoomBean {

    private long id;
    private long warnId;
    private String message;
    private String startDate;
    private String endDate;
    private String deviceName;
    private long houseId;
    private long roomId;
    private String roomName;
}
