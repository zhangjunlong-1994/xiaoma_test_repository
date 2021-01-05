package com.pony.sc_home_personal.bean.base;

import lombok.Data;

/**
 * @author suntai
 * @date 2019/11/29 10:39
 */
@Data
public class RecordCustomerDeviceFunctionBean {

    private long id;
    private long houseId;
    private long customerId;
    private String remark;
    private String createDate;
    private long roomId;
    private String roomName;
    private long deviceId;
    private String deviceName;
    private long deviceTypeId;
    private String deviceTypeName;
    private long functionId;
    private String functionName;
    private String customerName;
    private String customerMobile;
}
