package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.CentralBean;
import com.pony.sc_home_personal.common.PageNavigator;
import lombok.Data;

/**
 * @author suntai
 * @date 2019/11/23 11:11
 */
@Data
public class CentralPageBean {

    private PageNavigator<CentralBean> centralBeanPage;
}
