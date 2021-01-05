package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.DeviceBean;
import com.pony.sc_home_personal.bean.base.DeviceFunctionBean;
import lombok.Data;

import java.util.List;

/**
 * @author chujialin
 * @date 2020/4/11 8:38
 **/
@Data
public class DeviceWithFunctionBean {

    private DeviceBean deviceBean;
    private List<DeviceFunctionBean> deviceFunctionBeanList;
}
