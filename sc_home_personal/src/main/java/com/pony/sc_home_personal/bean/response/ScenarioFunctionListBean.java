package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.ScenarioDeviceFunctionBean;
import lombok.Data;

import java.util.List;

/**
 * @author chujialin
 * @date 2020/4/21 8:47
 **/
@Data
public class ScenarioFunctionListBean {

    private List<ScenarioDeviceFunctionBean> scenarioDeviceFunctionBeanList;
}
