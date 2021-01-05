package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.RelayHouseRoomBean;
import com.pony.sc_home_personal.common.PageNavigator;
import lombok.Data;

/**
 * @author hanshuang
 * @date 2020/06/30 10:23
 **/
@Data
public class RelayHouseRoomPageBean {

    private PageNavigator<RelayHouseRoomBean> pageNavigator;
}
