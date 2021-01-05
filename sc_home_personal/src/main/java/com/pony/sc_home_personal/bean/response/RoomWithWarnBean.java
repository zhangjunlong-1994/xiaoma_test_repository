package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.RoomBean;
import lombok.Data;

/**
 * @author chujialin
 * @date 2020/4/30 15:52
 **/
@Data
public class RoomWithWarnBean {

    private RoomBean roomBean;
    private boolean alarm;
    private String message;
}
