package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.TypeManageBean;
import lombok.Data;

import java.util.List;

/**
 * @author chujialin
 * @date 2020/7/24 9:19
 **/
@Data
public class TypeManageTreeBean {

    private TypeManageBean typeManageBean;
    private List<TypeManageBean> typeManageChildrenBeanList;
}
