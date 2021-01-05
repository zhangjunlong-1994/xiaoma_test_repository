package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.response.RoomWithWarnListBean;
import com.pony.sc_home_personal.bean.response.WarnDeviceFunctionListBean;
import com.pony.sc_home_personal.bean.response.WarnSettingInitBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ViewBean;
import com.pony.sc_home_personal.service.personal.WarnFeign;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author suntai
 * @date 2019/12/30 11:45
 */
@Component
public class WarnFacadeImpl implements WarnFacade {

    @Resource
    private WarnFeign warnFeign;

    @Override
    public ResponseResult<WarnSettingInitBean> editWarnSettingInit(long warnId, long houseId) {
        ViewBean<WarnSettingInitBean> viewBean = warnFeign.editWarnSettingInit(warnId, houseId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult editWarnSetting(WarnDeviceFunctionListBean listBean) {
        ViewBean viewBean = warnFeign.editWarnSetting(listBean);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<RoomWithWarnListBean> searchWarnUnReadMessage(long houseId) {
        ViewBean<RoomWithWarnListBean> viewBean = warnFeign.searchWarnUnReadMessage(houseId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult confirmDeviceWarn(long houseId, long roomId) {
        ViewBean viewBean = warnFeign.confirmDeviceWarn(houseId, roomId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }
}
