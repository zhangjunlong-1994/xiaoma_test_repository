package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.WarnDeviceFunctionBean;
import lombok.Data;

import java.util.List;

/**
 * @author wenxufeng
 * @date 2020/1/7 11:05
 **/
@Data
public class WarnDeviceFunctionListBean {

    private List<WarnDeviceFunctionBean> warnDeviceFunctionBeanList;
}
