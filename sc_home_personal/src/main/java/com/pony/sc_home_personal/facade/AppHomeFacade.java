package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.response.AppHomeInitData;
import com.pony.sc_home_personal.common.ResponseResult;

/**
 * @author haozhongyu
 * @date 2020/1/2 11:43
 **/
public interface AppHomeFacade {

    ResponseResult<AppHomeInitData> searchHomeInitData(long customerId, long houseId);
}
