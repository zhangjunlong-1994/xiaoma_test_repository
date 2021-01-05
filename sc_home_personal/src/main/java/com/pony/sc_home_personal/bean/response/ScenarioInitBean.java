package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.RoomBean;
import com.pony.sc_home_personal.bean.base.ScenarioDeviceFunctionBean;
import com.pony.sc_home_personal.bean.base.ScenarioHouseBean;
import lombok.Data;

import java.util.List;

/**
 * @author wenxufeng
 * @date 2019/11/25 13:17
 **/
@Data
public class ScenarioInitBean {

    private ScenarioHouseBean scenarioHouseBean;
    private List<TypeManageTreeBean> scenarioTypeList;
    private List<RoomBean> roomBeanList;
    private List<ScenarioDeviceFunctionBean> scenarioDeviceFunctionBeanList;
    private List<DeviceWithFunctionBean> deviceWithFunctionBeanList;
}
