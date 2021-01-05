package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.HouseBean;
import com.pony.sc_home_personal.bean.base.HouseCustomerBean;
import com.pony.sc_home_personal.common.PageNavigator;
import lombok.Data;

import java.util.List;

/**
 * @author suntai
 * @date 2019/12/16 9:28
 */
@Data
public class HousePageBean {

    private PageNavigator<HouseBean> houseBeanPage;
    private List<HouseCustomerBean> houseCustomerBeanList;
}
