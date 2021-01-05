package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.response.ScenarioFunctionListBean;
import com.pony.sc_home_personal.bean.response.ScenarioInitBean;
import com.pony.sc_home_personal.bean.response.ScenarioListBean;
import com.pony.sc_home_personal.bean.response.ScenarioPageBean;
import com.pony.sc_home_personal.common.ResponseResult;

/**
 * @author wenxufeng
 * @date 2019/11/26 10:52
 **/
public interface ScenarioFacade {

    /**
     * @author chujialin
     * @date 2020/4/27 17:12
     **/
    ResponseResult<ScenarioPageBean> searchPage(String province, String city, String region,
                                                long customerId, long houseId, int currentPage, int everyPage);

    /**
     * @author chujialin
     * @date 2020/4/27 17:07
     **/
    ResponseResult<ScenarioFunctionListBean> searchFunctionListByScenarioId(long scenarioId);

    /**
     * @author wenxufeng
     * @date 2019/11/26 11:01
     **/
    ResponseResult<ScenarioInitBean> editScenarioInit(long id);

    /**
     * @author wenxufeng
     * @date 2019/11/26 11:01
     **/
    ResponseResult editScenario(ScenarioFunctionListBean listBean);

    /**
     * @author liuwenbo
     * @date 2020/8/3 11:22
     **/
    ResponseResult<ScenarioListBean> addScenarioList(ScenarioListBean scenarioListBean);

    /**
     * @author haozhongyu
     * @date 2019/12/27 14:51
     **/
    ResponseResult editScenarioEnabled(long scenarioId, boolean enabled);

    /**
     * @author wenxufeng
     * @date 2019/11/26 11:02
     **/
    ResponseResult deleteScenario(long id);
}
