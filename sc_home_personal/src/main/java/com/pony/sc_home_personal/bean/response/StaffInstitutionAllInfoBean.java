package com.pony.sc_home_personal.bean.response;

import lombok.Data;

/**
 * @author hanshuang
 * @date 2020/07/10 14:51
 **/
@Data
public class StaffInstitutionAllInfoBean {

    private String accounts;
    private String type;
    private String disabled;
    private String name;
    private String headImg;
    private String sex;
    private String companyName;
    private String departmentName;
    private String positionName;
    private String professionName;
    private String menuModulesGroupName;
    private long id;
    private String mobile;
    private long companyId;
    private long departmentId;
    private long positionId;
    private long professionId;
    private long modulesGroupId;
    private String entryDate;
    private String createDate;
    private String explains;
    private String manager;
    private String superManager;
    private int role;
}
