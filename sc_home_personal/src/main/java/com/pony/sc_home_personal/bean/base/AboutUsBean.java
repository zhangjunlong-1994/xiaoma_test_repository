package com.pony.sc_home_personal.bean.base;

import lombok.Data;

@Data
public class AboutUsBean {

    private long id;
    private String introduction;
    private String mobile;
    private String email;
    private String version;
    private boolean enabled;
}
