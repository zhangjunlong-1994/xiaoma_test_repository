package com.pony.springboot_demo.controller;

import com.pony.springboot_demo.bean.ViewBean;
import com.pony.springboot_demo.entities.User;
import com.pony.springboot_demo.entities.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author zjl
 * @date 2020/10/17 10:20
 * User相关方法接口类
 */
@Api(value = "User相关方法接口" , description = "User相关方法接口")
@RestController
@RequestMapping("/test")
public class UserController {

    /**
     * 获取用户详细信息接口方法
     * @param user 用户基础信息
     * @return 返回用户详细信息
     */
    @ApiOperation(value = "获取用户详细信息" , notes = "根据基础信息获取用户详细信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "user" , value = "用户基本信息")
    )
    @RequestMapping("/userinfo")
    public ViewBean<UserInfo> getUserInfo(@RequestBody User user){
        UserInfo userInfo = new UserInfo(new BigDecimal(3000.25), "科长", 3 , "辽宁省丹东市");
        ViewBean<UserInfo> viewBean = new ViewBean();
        viewBean.setCode(0);
        viewBean.setMessage("访问成功");
        viewBean.setData(userInfo);
        return viewBean;
    }
}

