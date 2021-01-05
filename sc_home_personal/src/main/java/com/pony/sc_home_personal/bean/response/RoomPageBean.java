package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.RoomBean;
import com.pony.sc_home_personal.common.PageNavigator;
import lombok.Data;

/**
 * @author WenXuFeng
 * @date 2019/11/19 11:56
 **/
@Data
public class RoomPageBean {

    private PageNavigator<RoomBean> roomBeanPage;

}
