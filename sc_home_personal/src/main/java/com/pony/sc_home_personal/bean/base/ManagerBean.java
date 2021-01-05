package com.pony.sc_home_personal.bean.base;

import lombok.Data;

/**
 * @author chujialin
 * @date 2020/12/8 17:27
 **/
@Data
public class ManagerBean {

    private long id;
    private String name;
    private String headImg;
    private byte sexValue;
    private String sexText;
    private String mobile;
    private String entryDate;
    private boolean manager;
    private byte stateValue;
    private String stateText;
    private long projectId;
    private String projectName;
    private long companyId;
    private String companyName;
    private long departmentId;
    private String departmentName;
    private long positionId;
    private String positionName;
    private long professionId;
    private String professionName;
    private long menuGroupId;
    private String createDate;
    private String updateDate;
    private long updateStaff;
}
