package com.pony.sc_home_personal.service.personal;

import com.pony.sc_home_personal.bean.base.AboutUsBean;
import com.pony.sc_home_personal.bean.response.AboutUsPageBean;
import com.pony.sc_home_personal.common.ViewBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author haozhongyu
 * @date 2019/12/30 11:07
 **/
@FeignClient(name = "sp-home-personal")
@RequestMapping("/AboutUs")
public interface AboutUsManageFeign {

    @PostMapping("/searchAboutUsPage.do")
    ViewBean<AboutUsPageBean> searchAboutUsPage(@RequestParam("currentPage") int currentPage,
                                                @RequestParam("everyPage") int everyPage);

    @PostMapping(value = "/editAboutUs.do")
    ViewBean editAboutUs(@RequestParam("id") long id,
                         @RequestParam("briefIntroduction") String briefIntroduction,
                         @RequestParam("mobile") String mobile,
                         @RequestParam("email") String email,
                         @RequestParam("edition") String edition);

    @PostMapping("/searchAboutUsById.do")
    ViewBean<AboutUsBean> searchAboutUsById(@RequestParam("id") long id);

    @PostMapping("/deleteAboutUs.do")
    ViewBean deleteAboutUs(@RequestParam("id") long id);

    @PostMapping("/editAboutUsEnabled.do")
    ViewBean editAboutUsEnabled(@RequestParam("id") long id,
                                @RequestParam("enabled") boolean enabled);

    @PostMapping("/searchAboutUsByEnabledIsTrue.do")
    ViewBean<AboutUsBean> searchAboutUsByEnabledIsTrue();
}
