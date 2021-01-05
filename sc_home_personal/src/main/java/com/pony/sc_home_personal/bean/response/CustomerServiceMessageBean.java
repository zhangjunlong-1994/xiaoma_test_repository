package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.CustomerBean;
import com.pony.sc_home_personal.bean.base.CustomerServiceBean;
import com.pony.sc_home_personal.common.PageNavigator;
import lombok.Data;

/**
 * @author suntai
 * @date 2019/11/21 13:28
 */
@Data
public class CustomerServiceMessageBean {

    private CustomerBean customerBean;
    private PageNavigator<CustomerServiceBean> pageNavigator;
    private long unReadNum;
}
