package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.response.RecordCustomerDeviceFunctionPageBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ViewBean;
import com.pony.sc_home_personal.service.personal.RecordManageFeign;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author haozhongyu
 * @date 2019/11/26 15:13
 **/

@Component
public class RecordFacadeImpl implements RecordFacade {

    @Resource
    private RecordManageFeign recordManageFeign;

    @Override
    public ResponseResult<RecordCustomerDeviceFunctionPageBean> searchRecordCustomerDeviceFunctionPage(long houseId, int currentPage, int everyPage) {
        ViewBean<RecordCustomerDeviceFunctionPageBean> viewBean =
                recordManageFeign.searchRecordCustomerDeviceFunctionPage(houseId, currentPage, everyPage);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult editRecordBySendStudy(long customerId) {
        ViewBean viewBean = recordManageFeign.editRecordBySendStudy(customerId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult editRecordBySendControl(long customerId, long deviceId, long functionId) {
        ViewBean viewBean = recordManageFeign.editRecordBySendControl(customerId, deviceId, functionId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult saveResult(long id, boolean result) {
        ViewBean viewBean = recordManageFeign.saveResult(id, result);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }
}
