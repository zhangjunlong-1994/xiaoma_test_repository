package com.pony.sc_home_personal.bean.base;

import lombok.Data;

@Data
public class CustomerServiceBean {

    private long id;
    private long manageId;
    private long customerId;
    private int sender;
    private boolean readed;
    private int type;
    private String content;
    private String createDate;
}
