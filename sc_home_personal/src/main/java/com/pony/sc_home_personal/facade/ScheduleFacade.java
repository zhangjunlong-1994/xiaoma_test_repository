package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.response.ScheduleListBean;
import com.pony.sc_home_personal.common.ResponseResult;

/**
 * @author suntai
 * @date 2019/12/30 11:38
 */
public interface ScheduleFacade {

    /**
     * @author suntai
     * @date 2019/12/30 11:47
     **/
    ResponseResult<ScheduleListBean> searchScheduleList(long customerId, String date);

    /**
     * @author suntai
     * @date 2019/12/30 11:47
     **/
    ResponseResult<Long> editSchedule(long id, long customerId, String title, String content, long scenarioId, String scheduleDate);

    /**
     * @author suntai
     * @date 2019/12/30 11:47
     **/
    ResponseResult deleteSchedule(long id);
}
