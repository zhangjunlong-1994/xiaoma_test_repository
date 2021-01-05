package com.pony.sc_home_personal.bean.base;

import lombok.Data;

@Data
public class CustomerBean {

    private long id;
    private String name;
    private String img;
    private String mobile;
    private String birth;
    private int age;
    private int sexValue;
    private String sexText;
    private boolean enabled;
    private String createDate;
}
