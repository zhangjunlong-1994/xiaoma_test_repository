package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.TypeManageBean;
import com.pony.sc_home_personal.common.PageNavigator;
import lombok.Data;

/**
 * @author hanshuang
 * @date 2020/07/07 10:02
 **/
@Data
public class TypeManagePageBean {

    private PageNavigator<TypeManageBean> pageNavigator;
}
