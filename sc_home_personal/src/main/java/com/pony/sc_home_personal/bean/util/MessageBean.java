package com.pony.sc_home_personal.bean.util;

import lombok.Data;

import java.util.List;

/**
 * @author chujialin
 * @date 2020/8/19 13:14
 **/
@Data
public class MessageBean {

    private long messageId; //指令ID
    private long userId; // 用户Id
    private int userType; //用户Type（1：管理员；2：用户）
    private String mac; //主机Mac地址
    private byte function; //功能码
    private List<DelayMessageBean> delayMessageBeanList; //指令

    public MessageBean() {

    }

    public MessageBean(long messageId, long userId, int userType, String mac, byte function, List<DelayMessageBean> delayMessageBeanList) {
        this.messageId = messageId;
        this.userId = userId;
        this.userType = userType;
        this.mac = mac;
        this.function = function;
        this.delayMessageBeanList = delayMessageBeanList;
    }

}
