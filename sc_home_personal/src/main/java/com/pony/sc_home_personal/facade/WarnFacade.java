package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.response.RoomWithWarnListBean;
import com.pony.sc_home_personal.bean.response.WarnDeviceFunctionListBean;
import com.pony.sc_home_personal.bean.response.WarnSettingInitBean;
import com.pony.sc_home_personal.common.ResponseResult;

/**
 * @author suntai
 * @date 2019/12/30 11:38
 */
public interface WarnFacade {

    /**
     * @author chujialin
     * @date 2020/4/11 8:40
     **/
    ResponseResult<WarnSettingInitBean> editWarnSettingInit(long warnId, long houseId);

    /**
     * @author chujialin
     * @date 2020/4/11 8:13
     **/
    ResponseResult editWarnSetting(WarnDeviceFunctionListBean listBean);

    /**
     * @author chujialin
     * @date 2020/4/30 15:54
     **/
    ResponseResult<RoomWithWarnListBean> searchWarnUnReadMessage(long houseId);

    /**
     * @author chujialin
     * @date 2020/5/6 8:36
     **/
    ResponseResult confirmDeviceWarn(long houseId, long roomId);
}
