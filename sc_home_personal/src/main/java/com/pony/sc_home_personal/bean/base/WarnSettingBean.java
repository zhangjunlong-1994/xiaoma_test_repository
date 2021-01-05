package com.pony.sc_home_personal.bean.base;

import lombok.Data;

/**
 * @author chujialin
 * @date 2020/4/10 14:34
 **/
@Data
public class WarnSettingBean {

    private long id;
    private long deviceId;
    private String message;
    private boolean inDanger;
    private int executeTypeValue;
    private String executeTypeText;
    private long scenarioId;
}
