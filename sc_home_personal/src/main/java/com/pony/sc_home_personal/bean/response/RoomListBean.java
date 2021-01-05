package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.RoomBean;
import lombok.Data;

import java.util.List;

/**
 * @author WenXuFeng
 * @date 2019/11/19 15:10
 **/
@Data
public class RoomListBean {
    private List<RoomBean> roomBeanList;
}
