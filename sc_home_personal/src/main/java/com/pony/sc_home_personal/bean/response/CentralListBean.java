package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.CentralBean;
import lombok.Data;

import java.util.List;

/**
 * @author chujialin
 * @date 2020/10/9 10:33
 **/
@Data
public class CentralListBean {

    List<CentralBean> centralBeanList;
}
