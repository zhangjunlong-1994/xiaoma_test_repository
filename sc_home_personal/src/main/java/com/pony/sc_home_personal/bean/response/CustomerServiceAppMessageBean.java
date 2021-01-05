package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.CustomerServiceBean;
import lombok.Data;

/**
 * @author suntai
 * @date 2019/11/21 13:28
 */
@Data
public class CustomerServiceAppMessageBean {

    private String staffImg;
    private CustomerServiceBean customerServiceBean;
}
