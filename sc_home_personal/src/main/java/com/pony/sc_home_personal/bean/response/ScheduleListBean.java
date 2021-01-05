package com.pony.sc_home_personal.bean.response;

import com.pony.sc_home_personal.bean.base.ScheduleBean;
import lombok.Data;

import java.util.List;

/**
 * @author suntai
 * @date 2019/12/27 13:17
 */
@Data
public class ScheduleListBean {

    private List<ScheduleBean> scheduleBeanList;
}
