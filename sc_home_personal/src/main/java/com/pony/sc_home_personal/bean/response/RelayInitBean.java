package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.ConstantBean;
import com.pony.sc_home_personal.bean.base.EditionBean;
import com.pony.sc_home_personal.bean.base.RelayHouseRoomBean;
import com.pony.sc_home_personal.bean.base.RoomBean;
import lombok.Data;

import java.util.List;

/**
 * @author hanshuang
 * @date 2020/06/30 10:18
 **/
@Data
public class RelayInitBean {

    private RelayHouseRoomBean relayHouseRoomBean;
    private List<RoomBean> roomBeanList;
    private List<ConstantBean> mapFunctionType;
    private List<ConstantBean> mapHardwareVersion;
    private List<EditionBean> editionBeanList;
}
