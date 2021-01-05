package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.response.ScheduleListBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ViewBean;
import com.pony.sc_home_personal.service.personal.ScheduleFeign;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author suntai
 * @date 2019/12/30 11:48
 */
@Component
public class ScheduleFacadeImpl implements ScheduleFacade {

    @Resource
    private ScheduleFeign scheduleFeign;

    @Override
    public ResponseResult<ScheduleListBean> searchScheduleList(long customerId, String date) {
        ViewBean<ScheduleListBean> viewBean = scheduleFeign.searchScheduleList(customerId, date);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<Long> editSchedule(long id, long customerId, String title, String content, long scenarioId, String scheduleDate) {
        ViewBean<Long> viewBean = scheduleFeign.editSchedule(id, customerId, title, content, scenarioId, scheduleDate);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult deleteSchedule(long id) {
        ViewBean viewBean = scheduleFeign.deleteSchedule(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }
}
