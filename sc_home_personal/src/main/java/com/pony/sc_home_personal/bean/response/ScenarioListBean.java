package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.ScenarioBean;
import lombok.Data;

import java.util.List;

/**
 * @author chujialin
 * @date 2020/4/21 8:47
 **/
@Data
public class ScenarioListBean {

    private List<ScenarioBean> scenarioBeanList;
}
