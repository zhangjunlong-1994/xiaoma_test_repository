package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.DeviceFunctionManageBean;
import com.pony.sc_home_personal.common.PageNavigator;
import lombok.Data;

/**
 * @author hanshuang
 * @date 2020/07/24 11:36
 **/
@Data
public class DeviceFunctionManagePageBean {

    private PageNavigator<DeviceFunctionManageBean> pageNavigator;
}
