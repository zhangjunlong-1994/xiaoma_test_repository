package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.base.ManagerBean;
import com.pony.sc_home_personal.common.ResponseResult;

/**
 * @author chujialin
 * @date 2020/3/25 11:02
 **/
public interface ManagerLoginFacade {

    /**
     * @author chujialin
     * @date 2020/3/25 12:43
     **/
    ResponseResult<ManagerBean> loginByManagerToken(String token, long projectId);

    /**
     * @author chujialin
     * @date 2020/3/25 12:43
     **/
    ResponseResult<ManagerBean> loginByToken(String token);
}
