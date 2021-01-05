package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.bean.response.AppHomeInitData;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.config.CheckToken;
import com.pony.sc_home_personal.facade.AppHomeFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * APP首页
 *
 * @author haozhongyu
 * @date 2020/1/2 11:39
 **/
@RestController
@RequestMapping("/AppHome")
public class AppHomeController {

    @Resource
    private AppHomeFacade appHomeFacade;

    /**
     * 获取APP首页初始化信息
     *
     * @param houseId 房产Id
     * @author haozhongyu
     * @date 2020/1/2 11:39
     **/
    @CheckToken
    @PostMapping("/SearchHomeInitData.do")
    public ResponseResult<AppHomeInitData> searchHomeInitData(HttpServletRequest request,
                                                              @RequestParam long houseId) {
        long userId = Long.parseLong(String.valueOf(request.getAttribute("userId")));
        return appHomeFacade.searchHomeInitData(userId, houseId);
    }
}
