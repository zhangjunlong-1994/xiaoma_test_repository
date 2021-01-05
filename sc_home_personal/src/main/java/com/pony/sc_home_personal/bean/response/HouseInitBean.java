package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.HouseBean;
import com.pony.sc_home_personal.bean.base.HouseCustomerBean;
import lombok.Data;

import java.util.List;

/**
 * @author suntai
 * @date 2019/11/28 16:24
 */
@Data
public class HouseInitBean {

    private HouseBean houseBean;
    private List<HouseCustomerBean> houseCustomerBeanList;
}
