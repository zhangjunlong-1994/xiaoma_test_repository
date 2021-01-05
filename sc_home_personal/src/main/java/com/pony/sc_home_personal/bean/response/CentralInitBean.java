package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.CentralBean;
import com.pony.sc_home_personal.bean.base.ConstantBean;
import com.pony.sc_home_personal.bean.base.EditionBean;
import lombok.Data;

import java.util.List;

/**
 * @author chujialin
 * @date 2020/3/24 11:33
 **/
@Data
public class CentralInitBean {

    private CentralBean centralBean;
    private List<ConstantBean> mapHardwareTypeList;
    private List<EditionBean> editionBeanList;
}
