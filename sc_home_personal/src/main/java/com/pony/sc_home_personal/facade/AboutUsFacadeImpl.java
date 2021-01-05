package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.base.AboutUsBean;
import com.pony.sc_home_personal.bean.response.AboutUsPageBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ViewBean;
import com.pony.sc_home_personal.service.personal.AboutUsManageFeign;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author haozhongyu
 * @date 2019/12/28 10:13
 **/
@Component
public class AboutUsFacadeImpl implements AboutUsFacade {

    @Resource
    private AboutUsManageFeign aboutUsService;

    @Override
    public ResponseResult<AboutUsPageBean> searchAboutUsPage(int currentPage, int everyPage) {
        ViewBean<AboutUsPageBean> viewBean = aboutUsService.searchAboutUsPage(currentPage, everyPage);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<AboutUsBean> searchAboutUsById(long id) {
        ViewBean<AboutUsBean> viewBean = aboutUsService.searchAboutUsById(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<AboutUsBean> searchAboutUsByEnabledIsTrue() {
        ViewBean<AboutUsBean> viewBean = aboutUsService.searchAboutUsByEnabledIsTrue();
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult editAboutUs(long id, String briefIntroduction, String mobile, String email, String edition) {
        ViewBean viewBean = aboutUsService.editAboutUs(id, briefIntroduction, mobile, email, edition);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult editAboutUsEnabled(long id, boolean enabled) {
        ViewBean viewBean = aboutUsService.editAboutUsEnabled(id, enabled);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult deleteAboutUs(long id) {
        ViewBean viewBean = aboutUsService.deleteAboutUs(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }
}
