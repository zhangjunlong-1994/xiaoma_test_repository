package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.bean.base.ScenarioBean;
import com.pony.sc_home_personal.bean.base.ScenarioDeviceFunctionBean;
import com.pony.sc_home_personal.bean.response.ScenarioFunctionListBean;
import com.pony.sc_home_personal.bean.response.ScenarioInitBean;
import com.pony.sc_home_personal.bean.response.ScenarioListBean;
import com.pony.sc_home_personal.bean.response.ScenarioPageBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ResultStatus;
import com.pony.sc_home_personal.config.CheckToken;
import com.pony.sc_home_personal.facade.ScenarioFacade;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 情景模式
 *
 * @author wenxufeng
 * @date 2019/11/26 11:22
 **/
@RestController
@RequestMapping("/ScScenarioMode")
public class ScenarioController {

    private final ScenarioFacade scenarioFacade;

    @Autowired
    public ScenarioController(ScenarioFacade scenarioFacade) {
        this.scenarioFacade = scenarioFacade;
    }

    /**
     * 获取情景模式分页列表
     *
     * @param province    省份
     * @param city        市
     * @param region      区县
     * @param customerId  用户Id
     * @param houseId     房产Id
     * @param currentPage 当前页数（从0开始）
     * @param everyPage   每页条数
     * @author wenxufeng
     * @date 2019/11/26 11:01
     **/
    @CheckToken
    @PostMapping("/SearchPage.do")
    public ResponseResult<ScenarioPageBean> searchPage(@RequestParam String province,
                                                       @RequestParam String city,
                                                       @RequestParam String region,
                                                       @RequestParam long customerId,
                                                       @RequestParam long houseId,
                                                       @RequestParam int currentPage,
                                                       @RequestParam int everyPage) {
        return scenarioFacade.searchPage(province, city, region, customerId, houseId, currentPage, everyPage);
    }

    /**
     * 获取情景模式功能列表
     *
     * @param scenarioId 情景模式Id
     * @author liuwenbo
     * @date 2020/7/13 13:50
     **/
    @CheckToken
    @PostMapping("/SearchFunctionListByScenarioId.do")
    public ResponseResult<ScenarioFunctionListBean> searchFunctionListByScenarioId(@RequestParam long scenarioId) {
        return scenarioFacade.searchFunctionListByScenarioId(scenarioId);
    }

    /**
     * 编辑情景模式初始化
     *
     * @param id 情景模式Id
     * @author wenxufeng
     * @date 2019/11/26 11:02
     **/
    @CheckToken
    @PostMapping("/EditScenarioInit.do")
    public ResponseResult<ScenarioInitBean> editScenarioInit(@RequestParam long id) {
        return scenarioFacade.editScenarioInit(id);
    }

    /**
     * 编辑情景模式（带功能列表）
     *
     * @param messageObject 情景模式json数据
     * @author wenxufeng
     * @date 2019/11/26 11:01
     **/
    @CheckToken
    @PostMapping("/EditScenario.do")
    public ResponseResult editScenario(@RequestParam String messageObject) {
        List<ScenarioDeviceFunctionBean> beanList = new ArrayList<>();
        try {
            JSONObject jsonObject = JSONObject.fromObject(messageObject);
            ScenarioDeviceFunctionBean functionBean = new ScenarioDeviceFunctionBean();
            functionBean.setScenarioId(jsonObject.getLong("id"));
            functionBean.setHouseId(jsonObject.getLong("houseId"));
            functionBean.setTypeId(jsonObject.getLong("typeId"));
            functionBean.setName(jsonObject.getString("name"));
            functionBean.setEnabled(jsonObject.getBoolean("enabled"));

            JSONArray functionArray = JSONArray.fromObject(jsonObject.getString("functionList"));
            for (int i = 0; i < functionArray.size(); i++) {
                JSONObject functionObject = functionArray.getJSONObject(i);
                ScenarioDeviceFunctionBean bean;
                if (i == 0) {
                    bean = functionBean;
                } else {
                    bean = new ScenarioDeviceFunctionBean();
                }
                bean.setFunctionId(functionObject.getLong("functionId"));
                bean.setFunctionSort(functionObject.getInt("functionSort"));
                bean.setFunctionDelay(functionObject.getLong("functionDelay"));
                beanList.add(bean);
            }
            if (beanList.isEmpty()) {
                beanList.add(functionBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (beanList.isEmpty()) {
            return ResponseResult.success(ResultStatus.EXISTENT_FAILED_JSON.getCode(), null);
        } else {
            ScenarioFunctionListBean listBean = new ScenarioFunctionListBean();
            listBean.setScenarioDeviceFunctionBeanList(beanList);
            return scenarioFacade.editScenario(listBean);
        }
    }

    /**
     * 批量添加情景模式
     *
     * @param scenarioArrayStr 情景模式列表json数据
     * @author liuwenbo
     * @date 2020/8/3 11:36
     **/
    @CheckToken
    @PostMapping("/AddScenarioList.do")
    public ResponseResult<ScenarioListBean> addScenarioList(@RequestParam String scenarioArrayStr) {
        List<ScenarioBean> scenarioBeanList = new ArrayList<>();
        try {
            JSONArray jsonArray = JSONArray.fromObject(scenarioArrayStr);
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                ScenarioBean scenarioBean = new ScenarioBean();
                scenarioBean.setHouseId(jsonObject.getLong("houseId"));
                scenarioBean.setTypeId(jsonObject.getLong("type"));
                scenarioBean.setName(jsonObject.getString("name"));
                scenarioBean.setEnabled(jsonObject.getBoolean("enabled"));
                scenarioBeanList.add(scenarioBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (scenarioBeanList.isEmpty()) {
            return ResponseResult.success(ResultStatus.EXISTENT_FAILED_JSON.getCode(), null);
        } else {
            ScenarioListBean scenarioListBean = new ScenarioListBean();
            scenarioListBean.setScenarioBeanList(scenarioBeanList);
            return scenarioFacade.addScenarioList(scenarioListBean);
        }
    }

    /**
     * 编辑情景模式可用状态
     *
     * @param scenarioId 情景模式Id
     * @param enabled    是否可用
     * @author liuwenbo
     * @date 2020/7/13 13:50
     **/
    @CheckToken
    @PostMapping("/EditScenarioEnabled.do")
    public ResponseResult editScenarioEnabled(@RequestParam long scenarioId,
                                              @RequestParam boolean enabled) {
        return scenarioFacade.editScenarioEnabled(scenarioId, enabled);
    }

    /**
     * 删除情景模式
     *
     * @param id 情景模式Id
     * @author wenxufeng
     * @date 2019/11/26 11:01
     **/
    @CheckToken
    @PostMapping("/DeleteScenario.do")
    public ResponseResult deleteScenario(@RequestParam long id) {
        return scenarioFacade.deleteScenario(id);
    }
}
