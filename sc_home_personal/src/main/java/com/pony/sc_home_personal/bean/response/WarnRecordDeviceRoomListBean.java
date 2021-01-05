package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.WarnRecordDeviceRoomBean;
import lombok.Data;

import java.util.List;

/**
 * @author chujialin
 * @date 2020/4/30 16:43
 **/
@Data
public class WarnRecordDeviceRoomListBean {

    private List<WarnRecordDeviceRoomBean> warnRecordDeviceRoomBeanList;
}
