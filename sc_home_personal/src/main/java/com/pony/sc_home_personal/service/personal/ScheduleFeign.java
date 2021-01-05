package com.pony.sc_home_personal.service.personal;

import com.pony.sc_home_personal.bean.response.ScheduleListBean;
import com.pony.sc_home_personal.common.ViewBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author suntai
 * @date 2019/12/30 11:15
 */
@FeignClient(name = "sp-home-personal")
@RequestMapping("/Schedule")
public interface ScheduleFeign {

    /**
     * @author chujialin
     * @date 2020/4/29 16:25
     **/
    @PostMapping("/SearchScheduleList.do")
    ViewBean<ScheduleListBean> searchScheduleList(@RequestParam("customerId") long customerId,
                                                  @RequestParam("date") String date);

    /**
     * @author chujialin
     * @date 2020/4/29 16:26
     **/
    @PostMapping("/EditSchedule.do")
    ViewBean<Long> editSchedule(@RequestParam("id") long id,
                                @RequestParam("customerId") long customerId,
                                @RequestParam("title") String title,
                                @RequestParam("content") String content,
                                @RequestParam("scenarioId") long scenarioId,
                                @RequestParam("scheduleDate") String scheduleDate);

    /**
     * @author suntai
     * @date 2019/12/30 11:23
     **/
    @PostMapping("/DeleteSchedule.do")
    ViewBean deleteSchedule(@RequestParam("id") long id);
}
