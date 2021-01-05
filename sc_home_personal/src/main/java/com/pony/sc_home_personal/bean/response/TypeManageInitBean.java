package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.ConstantBean;
import com.pony.sc_home_personal.bean.base.TypeManageBean;
import lombok.Data;

import java.util.List;

/**
 * @author hanshuang
 * @date 2020/07/07 10:13
 **/
@Data
public class TypeManageInitBean {

    private TypeManageBean typeManageBean;
    private List<ConstantBean> typeBeanList;
    private List<TypeManageBean> parentList;
}
