package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.ConstantBean;
import com.pony.sc_home_personal.bean.base.EditionBean;
import com.pony.sc_home_personal.common.PageNavigator;
import lombok.Data;

import java.util.List;

/**
 * @author liguotao
 * @date 2020/8/28 12:02
 */
@Data
public class EditionPageBean {

    private PageNavigator<EditionBean> editionBeanPageNavigator;
    private List<ConstantBean> equipmentTypeMapListBean;
    private List<ConstantBean> hardwareTypeMapListBean;
}
