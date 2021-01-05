package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.ScenarioHouseBean;
import com.pony.sc_home_personal.common.PageNavigator;
import lombok.Data;

/**
 * @author wenxufeng
 * @date 2019/11/20 13:09
 **/
@Data
public class ScenarioPageBean {

    private PageNavigator<ScenarioHouseBean> scenarioHouseBeanPage;
}
