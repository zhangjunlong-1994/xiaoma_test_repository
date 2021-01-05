package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.bean.response.RecordCustomerDeviceFunctionPageBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.config.CheckToken;
import com.pony.sc_home_personal.facade.RecordFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 记录
 *
 * @author haozhongyu
 * @date 2019/11/26 15:10
 **/
@RestController
@RequestMapping("/ScRecord")
public class RecordManageController {

    @Resource
    private RecordFacade recordFacade;

    /**
     * 获取记录分页列表
     *
     * @param houseId     房产Id
     * @param currentPage 当前页数（从0开始）
     * @param everyPage   每页条数
     * @author liuwenbo
     * @date 2020/7/10 15:06
     **/
    @CheckToken
    @PostMapping("/searchRecordCustomerDeviceFunctionPage.do")
    public ResponseResult<RecordCustomerDeviceFunctionPageBean> searchRecordCustomerDeviceFunctionPage(@RequestParam long houseId,
                                                                                                       @RequestParam int currentPage,
                                                                                                       @RequestParam int everyPage) {
        return recordFacade.searchRecordCustomerDeviceFunctionPage(houseId, currentPage, everyPage);
    }

    /**
     * @author wang
     * @date 2020/12/28 15:06
     **/
    @CheckToken
    @PostMapping("/EditRecordBySendStudy.do")
    public ResponseResult editRecordBySendStudy(@RequestParam long customerId) {
        return recordFacade.editRecordBySendStudy(customerId);
    }

    /**
     * @author wang
     * @date 2020/12/28 15:06
     **/
    @CheckToken
    @PostMapping("/EditRecordBySendControl.do")
    public ResponseResult editRecordBySendControl(@RequestParam long customerId,
                                                  @RequestParam long deviceId,
                                                  @RequestParam long functionId) {
        return recordFacade.editRecordBySendControl(customerId, deviceId, functionId);
    }

    /**
     * @author wang
     * @date 2020/12/28 15:06
     **/
    @CheckToken
    @PostMapping("/SaveResult.do")
    public ResponseResult saveResult(@RequestParam long id,
                                     @RequestParam boolean result) {
        return recordFacade.saveResult(id, result);
    }

}
