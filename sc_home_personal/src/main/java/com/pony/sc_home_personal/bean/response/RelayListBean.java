package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.RelayBean;
import lombok.Data;

import java.util.List;

/**
 * @author hanshuang
 * @date 2020/06/30 10:18
 **/
@Data
public class RelayListBean {

    private List<RelayBean> relayBeanList;
}
