package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.ConstantBean;
import com.pony.sc_home_personal.bean.base.EditionBean;
import lombok.Data;

import java.util.List;

/**
 * @author liguotao
 * @date 2020/8/28 13:02
 */

@Data
public class EditionInitBean {

    private EditionBean editionBean;
    private List<ConstantBean> equipmentTypeMapListBean;
    private List<ConstantBean> centralHardwareTypeMapListBean;
    private List<ConstantBean> relayHardwareTypeMapListBean;
}
