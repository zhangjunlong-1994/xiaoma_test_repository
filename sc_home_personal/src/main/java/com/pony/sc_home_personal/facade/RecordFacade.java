package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.response.RecordCustomerDeviceFunctionPageBean;
import com.pony.sc_home_personal.common.ResponseResult;

/**
 * @author haozhongyu
 * @date 2019/11/26 15:13
 **/
public interface RecordFacade {

    /**
     * @author liuwenbo
     * @date 2020/7/10 15:03
     **/
    ResponseResult<RecordCustomerDeviceFunctionPageBean> searchRecordCustomerDeviceFunctionPage(long houseId, int currentPage, int everyPage);

    /**
     * @author wang
     * @date 2020/12/29 20:17
     **/
    ResponseResult editRecordBySendStudy(long customerId);

    /**
     * @author wang
     * @date 2020/12/29 20:17
     **/
    ResponseResult editRecordBySendControl(long customerId, long deviceId, long functionId);

    /**
     * @author wang
     * @date 2020/12/29 20:17
     **/
    ResponseResult saveResult(long id, boolean result);
}
