package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.RoomBean;
import com.pony.sc_home_personal.common.PageNavigator;
import lombok.Data;

import java.util.List;

/**
 * @author WenXuFeng
 * @date 2019/11/19 15:12
 **/
@Data
public class RoomInitBean {

    private List<TypeManageTreeBean> roomTypeBeanList;
    private PageNavigator<RoomBean> roomBeanPage;
}