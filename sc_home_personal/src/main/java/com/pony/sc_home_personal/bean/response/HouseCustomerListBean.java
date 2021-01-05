package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.HouseCustomerBean;
import lombok.Data;

import java.util.List;

/**
 * @author suntai
 * @date 2019/11/28 11:24
 */
@Data
public class HouseCustomerListBean {

    private List<HouseCustomerBean> houseCustomerListBean;
}
