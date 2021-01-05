package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.ConstantBean;
import com.pony.sc_home_personal.bean.base.CustomerBean;
import com.pony.sc_home_personal.bean.base.LoginBean;
import lombok.Data;

import java.util.List;

/**
 * @author chujialin
 * @date 2020/3/24 11:33
 **/
@Data
public class CustomerInitBean {

    private CustomerBean customerBean;
    private LoginBean loginBean;
    private List<ConstantBean> sexBeanList;
}
