package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.bean.base.AboutUsBean;
import com.pony.sc_home_personal.bean.response.AboutUsPageBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.config.CheckToken;
import com.pony.sc_home_personal.facade.AboutUsFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 关于我们
 *
 * @author haozhongyu
 * @date 2019/12/28 10:13
 **/
@RestController
@RequestMapping("/ScAboutUs")
public class AboutUsController {

    @Resource
    private AboutUsFacade aboutUsFacade;

    /**
     * 查询“关于我们”的分页列表
     *
     * @param currentPage 当前页数（从0开始）
     * @param everyPage   每页条数
     * @author liuwenbo
     * @date 2020/7/9 13:35
     **/
    @CheckToken
    @PostMapping("/SearchAboutUsPage.do")
    public ResponseResult<AboutUsPageBean> searchAboutUsPage(int currentPage, int everyPage) {
        return aboutUsFacade.searchAboutUsPage(currentPage, everyPage);
    }

    /**
     * 根据Id查询“关于我们”
     *
     * @param id Id
     * @author liuwenbo
     * @date 2020/7/9 13:35
     **/
    @CheckToken
    @PostMapping("/SearchAboutUsById.do")
    public ResponseResult<AboutUsBean> searchAboutUsById(@RequestParam long id) {
        return aboutUsFacade.searchAboutUsById(id);
    }

    /**
     * 查询当前启用的“关于我们”
     *
     * @author liuwenbo
     * @date 2020/7/13 14:01
     **/
    @CheckToken
    @PostMapping("/SearchAboutUsByEnabledIsTrue.do")
    public ResponseResult<AboutUsBean> searchAboutUsByEnabledIsTrue() {
        return aboutUsFacade.searchAboutUsByEnabledIsTrue();
    }

    /**
     * 编辑关于我们
     *
     * @param id                新增为0，修改为其他
     * @param briefIntroduction 说明
     * @param mobile            联系电话
     * @param email             联系邮箱
     * @param edition           版本号
     * @author liuwenbo
     * @date 2020/7/9 13:35
     **/
    @CheckToken
    @PostMapping("/EditAboutUs.do")
    public ResponseResult editAboutUs(@RequestParam long id,
                                      @RequestParam String briefIntroduction,
                                      @RequestParam String mobile,
                                      @RequestParam String email,
                                      @RequestParam String edition) {
        return aboutUsFacade.editAboutUs(id, briefIntroduction, mobile, email, edition);
    }

    /**
     * 根据Id启用“关于我们”
     * 同一时间最多能有一个“关于我们”处于启用状态，其余全部不启用
     *
     * @param id      Id
     * @param enabled 是否启用
     * @author liuwenbo
     * @date 2020/7/9 13:38
     **/
    @CheckToken
    @PostMapping("/EditAboutUsEnabled.do")
    public ResponseResult editAboutUsEnabled(@RequestParam long id,
                                             @RequestParam boolean enabled) {
        return aboutUsFacade.editAboutUsEnabled(id, enabled);
    }

    /**
     * 根据Id删除“关于我们”
     *
     * @param id Id
     * @author liuwenbo
     * @date 2020/7/9 13:36
     **/
    @CheckToken
    @PostMapping("/DeleteAboutUs.do")
    public ResponseResult deleteAboutUs(@RequestParam long id) {
        return aboutUsFacade.deleteAboutUs(id);
    }
}
