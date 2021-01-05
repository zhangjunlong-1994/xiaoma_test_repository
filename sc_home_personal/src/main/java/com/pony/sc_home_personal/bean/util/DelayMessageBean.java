package com.pony.sc_home_personal.bean.util;

import lombok.Data;

/**
 * @author chujialin
 * @date 2020/8/19 13:14
 **/
@Data
public class DelayMessageBean {

    private boolean random; //是否随机指令
    private byte function; //类型码
    private String relayMac; //中继mac地址
    private String message; //指令信息
    private long delay; // 指令延时

    public DelayMessageBean(byte function, String relayMac, String message, long delay) {
        this.random = false;
        this.function = function;
        this.relayMac = relayMac;
        this.message = message;
        this.delay = delay;
    }

    public DelayMessageBean(boolean random, byte function, String relayMac, String message, long delay) {
        this.random = random;
        this.function = function;
        this.relayMac = relayMac;
        this.message = message;
        this.delay = delay;
    }
}
