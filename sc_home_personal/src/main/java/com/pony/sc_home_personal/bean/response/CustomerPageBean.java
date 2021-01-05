package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.CustomerBean;
import com.pony.sc_home_personal.common.PageNavigator;
import lombok.Data;

/**
 * @author chujialin
 * @date 2020/3/24 11:33
 **/
@Data
public class CustomerPageBean {

    private PageNavigator<CustomerBean> customerPageBean;
}
