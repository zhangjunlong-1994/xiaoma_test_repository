package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.ConstantBean;
import com.pony.sc_home_personal.bean.base.DeviceCentralHouseBean;
import com.pony.sc_home_personal.bean.base.RelayBean;
import com.pony.sc_home_personal.bean.base.RoomBean;
import lombok.Data;

import java.util.List;

/**
 * @author suntai
 * @date 2019/11/26 13:06
 */
@Data
public class DeviceInitBean {

    private DeviceCentralHouseBean deviceCentralHouseBean;
    private List<ConstantBean> mapDeviceCode;
    private List<TypeManageTreeBean> deviceTypeList;
    private List<RoomBean> roomBeanList;
    private List<RelayBean> relayBeanList;
}
