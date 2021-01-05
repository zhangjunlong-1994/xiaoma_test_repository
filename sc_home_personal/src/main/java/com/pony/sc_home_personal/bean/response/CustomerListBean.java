package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.CustomerBean;
import lombok.Data;

import java.util.List;

/**
 * @author suntai
 * @date 2019/11/29 11:58
 */
@Data
public class CustomerListBean {

    List<CustomerBean> customerBeanList;
}
