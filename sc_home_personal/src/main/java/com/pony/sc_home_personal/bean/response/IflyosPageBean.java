package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.IflyosBean;
import com.pony.sc_home_personal.common.PageNavigator;
import lombok.Data;

/**
 * @author liguotao
 * @date 2020/8/31 20:13
 */
@Data
public class IflyosPageBean {

    private PageNavigator<IflyosBean> iflyosBeanPageNavigator;
}
