package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.RecordCustomerDeviceFunctionBean;
import com.pony.sc_home_personal.common.PageNavigator;
import lombok.Data;

/**
 * @author suntai
 * @date 2019/11/29 10:46
 */
@Data
public class RecordCustomerDeviceFunctionPageBean {

    private PageNavigator<RecordCustomerDeviceFunctionBean> recordCustomerDeviceFunctionBeanPage;
}
