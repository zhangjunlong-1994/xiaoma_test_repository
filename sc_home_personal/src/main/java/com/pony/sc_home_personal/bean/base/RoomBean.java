package com.pony.sc_home_personal.bean.base;

import lombok.Data;

@Data
public class RoomBean {

    private long id;
    private long houseId;
    private long typeId;
    private String typeName;
    private String typeNameEn;
    private String name;
    private double area;
    private String createDate;
    private boolean edit;
}
