package com.pony.sc_home_personal.bean.base;

import lombok.Data;

/**
 * @author hanshuang
 * @date 2020/07/07 9:38
 **/
@Data
public class TypeManageBean {

    private long id;
    private long parentId;
    private String parentName;
    private String name;
    private String nameEn;
    private String img;
    private int type;
    private String typeText;
    private String createDate;
}
