package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.DeviceFunctionManageBean;
import com.pony.sc_home_personal.bean.base.TypeManageBean;
import lombok.Data;

import java.util.List;

/**
 * @author hanshuang
 * @date 2020/07/24 15:47
 **/
@Data
public class DeviceFunctionManageInitBean {

    private DeviceFunctionManageBean deviceFunctionManageBean;
    private List<TypeManageBean> typeManageBeanList;
}
