package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.bean.response.ScheduleListBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.config.CheckToken;
import com.pony.sc_home_personal.facade.ScheduleFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 日程（TODO：APP日程功能已废弃）
 *
 * @author suntai
 * @date 2019/12/30 11:51
 */
@Deprecated
@RestController
@RequestMapping("/ScSchedule/")
public class ScheduleController {

    private final ScheduleFacade scheduleFacade;

    @Autowired
    public ScheduleController(ScheduleFacade scheduleFacade) {
        this.scheduleFacade = scheduleFacade;
    }

    @Deprecated
    @CheckToken
    @PostMapping("/SearchScheduleList.do")
    public ResponseResult<ScheduleListBean> searchScheduleList(HttpServletRequest request,
                                                               @RequestParam String date) {
        String userId = String.valueOf(request.getAttribute("userId"));
        return scheduleFacade.searchScheduleList(Long.parseLong(userId), date);
    }

    @Deprecated
    @CheckToken
    @PostMapping("/EditSchedule.do")
    public ResponseResult<Long> editSchedule(HttpServletRequest request,
                                             @RequestParam long id,
                                             @RequestParam String title,
                                             @RequestParam String content,
                                             @RequestParam long scenarioId,
                                             @RequestParam String scheduleDate) {
        String userId = String.valueOf(request.getAttribute("userId"));
        return scheduleFacade.editSchedule(id, Long.parseLong(userId), title, content, scenarioId, scheduleDate);
    }

    @Deprecated
    @CheckToken
    @PostMapping("/DeleteSchedule.do")
    public ResponseResult deleteSchedule(@RequestParam long id) {
        return scheduleFacade.deleteSchedule(id);
    }
}
