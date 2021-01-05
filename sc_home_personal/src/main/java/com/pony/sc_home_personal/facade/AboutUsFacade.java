package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.base.AboutUsBean;
import com.pony.sc_home_personal.bean.response.AboutUsPageBean;
import com.pony.sc_home_personal.common.ResponseResult;

/**
 * @author haozhongyu
 * @date 2019/12/30 10:59
 **/
public interface AboutUsFacade {

    /**
     * @author liuwenbo
     * @date 2020/7/9 13:18
     **/
    ResponseResult<AboutUsPageBean> searchAboutUsPage(int currentPage, int everyPage);

    /**
     * @author liuwenbo
     * @date 2020/7/9 13:19
     **/
    ResponseResult<AboutUsBean> searchAboutUsById(long id);

    /**
     * @author liuwenbo
     * @date 2020/7/13 15:05
     **/
    ResponseResult<AboutUsBean> searchAboutUsByEnabledIsTrue();

    /**
     * @author chujialin
     * @date 2020/3/27 12:56
     **/
    ResponseResult editAboutUs(long id, String briefIntroduction, String mobile, String email, String edition);

    /**
     * @author liuwenbo
     * @date 2020/7/9 13:21
     **/
    ResponseResult editAboutUsEnabled(long id, boolean enabled);

    /**
     * @author liuwenbo
     * @date 2020/7/9 13:20
     **/
    ResponseResult deleteAboutUs(long id);
}
