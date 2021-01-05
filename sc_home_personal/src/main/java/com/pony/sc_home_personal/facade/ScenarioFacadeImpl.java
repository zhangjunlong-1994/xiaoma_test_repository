package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.response.ScenarioFunctionListBean;
import com.pony.sc_home_personal.bean.response.ScenarioInitBean;
import com.pony.sc_home_personal.bean.response.ScenarioListBean;
import com.pony.sc_home_personal.bean.response.ScenarioPageBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ViewBean;
import com.pony.sc_home_personal.service.personal.ScenarioFeign;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author chujialin
 * @date 2020/4/27 17:12
 **/
@Component
public class ScenarioFacadeImpl implements ScenarioFacade {

    @Resource
    private ScenarioFeign scenarioFeign;

    @Override
    public ResponseResult<ScenarioPageBean> searchPage(String province, String city, String region,
                                                       long customerId, long houseId, int currentPage, int everyPage) {
        ViewBean<ScenarioPageBean> viewBean = scenarioFeign.searchPage(province, city, region, customerId, houseId, currentPage, everyPage);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<ScenarioFunctionListBean> searchFunctionListByScenarioId(long scenarioId) {
        ViewBean<ScenarioFunctionListBean> viewBean = scenarioFeign.searchFunctionListByScenarioId(scenarioId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<ScenarioInitBean> editScenarioInit(long id) {
        ViewBean<ScenarioInitBean> viewBean = scenarioFeign.editScenarioInit(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult editScenario(ScenarioFunctionListBean listBean) {
        ViewBean viewBean = scenarioFeign.editScenario(listBean);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<ScenarioListBean> addScenarioList(ScenarioListBean scenarioListBean) {
        ViewBean<ScenarioListBean> viewBean = scenarioFeign.addScenarioList(scenarioListBean);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult editScenarioEnabled(long scenarioId, boolean enabled) {
        ViewBean viewBean = scenarioFeign.editScenarioEnabled(scenarioId, enabled);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult deleteScenario(long id) {
        ViewBean viewBean = scenarioFeign.deleteScenario(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }
}
