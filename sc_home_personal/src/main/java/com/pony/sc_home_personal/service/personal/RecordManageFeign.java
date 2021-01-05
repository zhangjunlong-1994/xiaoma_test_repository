package com.pony.sc_home_personal.service.personal;

import com.pony.sc_home_personal.bean.response.RecordCustomerDeviceFunctionPageBean;
import com.pony.sc_home_personal.common.ViewBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author haozhongyu
 * @date 2019/11/26 15:46
 **/
@FeignClient(name = "sp-home-personal")
@RequestMapping("/Record")
public interface RecordManageFeign {

    /**
     * @author liuwenbo
     * @date 2020/7/10 15:02
     **/
    @PostMapping("/SearchRecordCustomerDeviceFunctionPage.do")
    ViewBean<RecordCustomerDeviceFunctionPageBean> searchRecordCustomerDeviceFunctionPage(@RequestParam("houseId") long houseId,
                                                                                          @RequestParam("currentPage") int currentPage,
                                                                                          @RequestParam("everyPage") int everyPage);

    /**
     * @author liuwenbo
     * @date 2020/7/10 11:22
     **/
    @PostMapping("/EditRecord.do")
    ViewBean editRecord(@RequestParam("deviceId") long deviceId,
                        @RequestParam("functionId") long functionId,
                        @RequestParam("customerId") Long customerId,
                        @RequestParam("remark") String remark);

    /**
     * @author chujialin
     * @date 2020/9/29 13:09
     **/
    @PostMapping("/EditRecordByScenarioId.do")
    ViewBean editRecordByScenarioId(@RequestParam("scenarioId") long scenarioId,
                                    @RequestParam("customerId") Long customerId,
                                    @RequestParam("remark") String remark);

    /**
     * @author wang
     * @date 2020/9/29 13:09
     **/
    @PostMapping("/EditRecordBySendStudy.do")
    ViewBean editRecordBySendStudy(@RequestParam("customerId") long customerId);

    /**
     * @author wang
     * @date 2020/9/29 13:09
     **/
    @PostMapping("/EditRecordBySendControl.do")
    ViewBean editRecordBySendControl(@RequestParam("customerId") long customerId,
                                     @RequestParam("deviceId") long deviceId,
                                     @RequestParam("functionId") long functionId);

    /**
     * @author wang
     * @date 2020/9/29 13:09
     **/
    @PostMapping("/SaveResult.do")
    ViewBean saveResult(@RequestParam("id") long id,
                        @RequestParam("result") boolean result);
}
