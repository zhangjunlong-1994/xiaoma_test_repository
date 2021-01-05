package com.pony.sc_home_personal.bean.base;

import lombok.Data;

@Data
public class ScheduleBean {

    private long id;
    private long customerId;
    private String title;
    private String content;
    private String scheduleDate;
    private String createDate;
    private long scenarioId;
}
