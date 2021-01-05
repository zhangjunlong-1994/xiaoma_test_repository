package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.EditionBean;
import lombok.Data;

import java.util.List;

/**
 * @author chujialin
 * @date 2020/9/25 16:36
 **/
@Data
public class EditionListBean {

    private List<EditionBean> editionBeanList;
}
