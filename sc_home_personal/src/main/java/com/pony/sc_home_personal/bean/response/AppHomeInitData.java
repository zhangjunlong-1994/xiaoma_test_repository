package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.CentralBean;
import com.pony.sc_home_personal.bean.base.HouseCustomerBean;
import com.pony.sc_home_personal.bean.base.ScenarioBean;
import lombok.Data;

import java.util.List;

/**
 * @author chujialin
 * @date 2020/4/20 18:39
 **/
@Data
public class AppHomeInitData {

    private List<HouseCustomerBean> houseCustomerBeanList;
    private List<RoomWithDeviceBean> roomWithDeviceBeanList;
    private List<ScenarioBean> scenarioBeanList;
    private int unReadMessage;
    private CentralBean centralBean;
}
