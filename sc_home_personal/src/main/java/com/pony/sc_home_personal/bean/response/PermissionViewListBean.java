package com.pony.sc_home_personal.bean.response;

import lombok.Data;

import java.util.List;

/**
 * @author hanshuang
 * @date 2020/07/10 14:38
 **/
@Data
public class PermissionViewListBean {

    private List<PermissionViewBean> positionBeanList;
    private List<PermissionViewBean> professionBeanList;
}
