package com.pony.sc_home_personal.bean.base;

import lombok.Data;

@Data
public class StaffBean {

    private long id;
    private String name;
    private String headImg;
    private int sexValue;
    private String sexText;
    private String mobile;
    private long companyId;
    private String companyName;
    private long departmentId;
    private String departmentName;
    private long positionId;
    private String positionName;
    private long professionId;
    private String professionName;
    private long modulesGroupId;
    private String entryDate;
    private String explains;
    private int managerValue;
    private String managerText;
    private int superManagerValue;
    private String superManagerText;
    private String createDate;
}
