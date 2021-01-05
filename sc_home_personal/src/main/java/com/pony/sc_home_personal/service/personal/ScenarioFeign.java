package com.pony.sc_home_personal.service.personal;

import com.pony.sc_home_personal.bean.response.ScenarioFunctionListBean;
import com.pony.sc_home_personal.bean.response.ScenarioInitBean;
import com.pony.sc_home_personal.bean.response.ScenarioListBean;
import com.pony.sc_home_personal.bean.response.ScenarioPageBean;
import com.pony.sc_home_personal.common.ViewBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wenxufeng
 * @date 2019/11/26 9:38
 **/
@FeignClient(name = "sp-home-personal")
@RequestMapping("/ScenarioMode")
public interface ScenarioFeign {

    /**
     * @author wenxufeng
     * @date 2019/11/27 11:35
     **/
    @PostMapping(value = "/SearchPage.do")
    ViewBean<ScenarioPageBean> searchPage(@RequestParam("province") String province,
                                          @RequestParam("city") String city,
                                          @RequestParam("region") String region,
                                          @RequestParam("customerId") long customerId,
                                          @RequestParam("houseId") long houseId,
                                          @RequestParam("currentPage") int currentPage,
                                          @RequestParam("everyPage") int everyPage);

    /**
     * @author chujialin
     * @date 2020/4/21 8:52
     **/
    @PostMapping(value = "/SearchListByHouseId.do")
    ViewBean<ScenarioListBean> searchListByHouseId(@RequestParam("houseId") long houseId);

    /**
     * @author chujialin
     * @date 2020/4/21 8:52
     **/
    @PostMapping(value = "/SearchFunctionListByScenarioId.do")
    ViewBean<ScenarioFunctionListBean> searchFunctionListByScenarioId(@RequestParam("scenarioId") long scenarioId);

    /**
     * @author wenxufeng
     * @date 2019/11/26 10:47
     **/
    @PostMapping(value = "/EditScenarioInit.do")
    ViewBean<ScenarioInitBean> editScenarioInit(@RequestParam("id") long id);

    /**
     * @author wenxufeng
     * @date 2019/11/26 10:46
     **/
    @PostMapping(value = "/EditScenario.do")
    ViewBean editScenario(@RequestBody ScenarioFunctionListBean listBean);

    /**
     * @author liuwenbo
     * @date 2020/8/3 11:20
     **/
    @PostMapping(value = "/AddScenarioList.do")
    ViewBean<ScenarioListBean> addScenarioList(@RequestBody ScenarioListBean scenarioListBean);

    /**
     * @author chujialin
     * @date 2020/4/24 10:06
     **/
    @PostMapping(value = "/EditScenarioEnabled.do")
    ViewBean editScenarioEnabled(@RequestParam("id") long id,
                                 @RequestParam("enabled") boolean enabled);

    /**
     * @author wenxufeng
     * @date 2019/11/26 10:47
     **/
    @PostMapping(value = "/DeleteScenario.do")
    ViewBean deleteScenario(@RequestParam("id") long id);
}
