package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.bean.base.ManagerBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.config.CheckToken;
import com.pony.sc_home_personal.facade.ManagerLoginFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 管理员登录
 *
 * @author chujialin
 * @date 2020/3/25 11:01
 **/
@RestController
@RequestMapping("/ScManagerLogin")
public class ManagerLoginController {

    private final ManagerLoginFacade managerLoginFacade;

    @Autowired
    public ManagerLoginController(ManagerLoginFacade managerLoginFacade) {
        this.managerLoginFacade = managerLoginFacade;
    }

    /**
     * 使用管理员token登录
     *
     * @param projectId 项目Id（用于验证token是否具有该项目权限）
     * @author chujialin
     * @date 2020/12/30 11:28
     **/
    @PostMapping("/LoginByManagerToken.do")
    public ResponseResult<ManagerBean> loginByManagerToken(@RequestHeader("token") String token,
                                                           @RequestParam long projectId) {
        return managerLoginFacade.loginByManagerToken(token, projectId);
    }

    /**
     * 使用token登录，并返回manager
     *
     * @author chujialin
     * @date 2020/12/30 11:28
     **/
    @CheckToken
    @PostMapping("/LoginByToken.do")
    public ResponseResult<ManagerBean> loginByToken(HttpServletRequest request) {
        String token = String.valueOf(request.getAttribute("token"));
        return managerLoginFacade.loginByToken(token);
    }
}
