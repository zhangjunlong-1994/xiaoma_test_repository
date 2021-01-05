package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.DeviceBean;
import lombok.Data;

import java.util.List;

/**
 * @author chujialin
 * @date 2020/4/21 9:07
 **/
@Data
public class DeviceListBean {

    private List<DeviceBean> deviceBeanList;
}
