package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.AboutUsBean;
import com.pony.sc_home_personal.common.PageNavigator;
import lombok.Data;

/**
 * @author liuwenbo
 * @date 2020/7/9 9:33
 **/
@Data
public class AboutUsPageBean {

    PageNavigator<AboutUsBean> aboutUsBeanPageNavigator;
}
