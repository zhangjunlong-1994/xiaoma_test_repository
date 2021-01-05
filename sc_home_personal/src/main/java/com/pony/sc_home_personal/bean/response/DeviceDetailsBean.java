package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.CentralBean;
import com.pony.sc_home_personal.bean.base.DeviceBean;
import com.pony.sc_home_personal.bean.base.DeviceFunctionBean;
import com.pony.sc_home_personal.bean.base.DeviceFunctionManageBean;
import lombok.Data;

import java.util.List;

/**
 * @author chujialin
 * @date 2020/4/8 15:05
 **/
@Data
public class DeviceDetailsBean {

    private List<DeviceFunctionManageBean> deviceFunctionManageBeanList;
    private List<DeviceFunctionBean> deviceFunctionBeanList;
    private CentralBean centralBean;
    private DeviceBean deviceBean;
}
