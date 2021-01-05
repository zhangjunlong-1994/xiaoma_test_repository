package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.DeviceBean;
import com.pony.sc_home_personal.bean.base.RoomBean;
import lombok.Data;

import java.util.List;

/**
 * @author chujialin
 * @date 2020/4/21 8:36
 **/
@Data
public class RoomWithDeviceBean {

    private RoomBean roomBean;
    private List<DeviceBean> deviceBeanList;
}
