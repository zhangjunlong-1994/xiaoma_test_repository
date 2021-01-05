package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.*;
import lombok.Data;

import java.util.List;

/**
 * @author chujialin
 * @date 2020/4/10 16:56
 **/
@Data
public class WarnSettingInitBean {

    private WarnSettingBean warnSettingBean; //警报设置
    private List<ConstantBean> warnSettingExecuteTypeList; //警报executeType列表
    private List<RoomBean> roomBeanList;
    private List<ScenarioBean> scenarioBeanList; //情景模式列表
    private List<WarnDeviceFunctionBean> warnDeviceFunctionBeanList; //已经选中的自定义功能列表
    private List<DeviceWithFunctionBean> deviceWithFunctionBeanList; //可选择的功能列表
}
