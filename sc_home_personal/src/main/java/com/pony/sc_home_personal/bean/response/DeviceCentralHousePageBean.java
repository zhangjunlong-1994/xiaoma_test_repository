package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.DeviceCentralHouseBean;
import com.pony.sc_home_personal.common.PageNavigator;
import lombok.Data;

/**
 * @author suntai
 * @date 2019/11/19 18:04
 */
@Data
public class DeviceCentralHousePageBean {

    private PageNavigator<DeviceCentralHouseBean> deviceCentralHouseBeanPage;
}
