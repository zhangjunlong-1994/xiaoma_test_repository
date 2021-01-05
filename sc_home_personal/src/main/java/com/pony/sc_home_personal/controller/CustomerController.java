package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.bean.response.CustomerInitBean;
import com.pony.sc_home_personal.bean.response.CustomerListBean;
import com.pony.sc_home_personal.bean.response.CustomerPageBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.config.CheckToken;
import com.pony.sc_home_personal.facade.CustomerManageFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户
 *
 * @author haozhongyu
 * @date 2019/12/28 10:13
 **/
@RestController
@RequestMapping("/ScCustomer")
public class CustomerController {

    @Resource
    private CustomerManageFacade customerManageFacade;

    /**
     * 获取用户分页列表
     *
     * @param userId      用户Id
     * @param currentPage 当前页数（从0开始）
     * @param everyPage   每页条数
     * @author haozhongyu
     * @date 2019/12/28 10:13
     **/
    @CheckToken
    @PostMapping("/SearchCustomerPageById.do")
    public ResponseResult<CustomerPageBean> searchCustomerPageById(@RequestParam long userId,
                                                                   @RequestParam int currentPage,
                                                                   @RequestParam int everyPage) {
        return customerManageFacade.SearchCustomerPageById(userId, currentPage, everyPage);
    }

    /**
     * 获取用户列表
     *
     * @param nameOrMobile 用户名称或手机号（模糊查询）
     * @author chujialin
     * @date 2020/3/30 14:56
     **/
    @CheckToken
    @PostMapping("/SearchCustomerListByNameOrMobile.do")
    public ResponseResult<CustomerListBean> searchCustomerListByNameOrMobile(@RequestParam String nameOrMobile) {
        return customerManageFacade.SearchCustomerListByNameOrMobile(nameOrMobile);
    }

    /**
     * 编辑用户初始化
     *
     * @param id 用户Id
     * @author haozhongyu
     * @date 2019/12/28 10:13
     **/
    @CheckToken
    @PostMapping("/EditCustomerInit.do")
    public ResponseResult<CustomerInitBean> editCustomerInit(@RequestParam long id) {
        return customerManageFacade.editCustomerInit(id);
    }

    /**
     * 编辑用户
     *
     * @param id       用户Id
     * @param name     名称
     * @param img      头像临时地址（未修改时为"")
     * @param mobile   手机号
     * @param birth    出生日期
     * @param sex      性别（男：1；女：2；不明：3）
     * @param enabled  是否可用
     * @param accounts 账号（新增用户时有效）
     * @author haozhongyu
     * @date 2019/12/28 10:13
     **/
    @CheckToken
    @PostMapping("/EditCustomer.do")
    public ResponseResult editCustomer(@RequestParam long id,
                                       @RequestParam String name,
                                       @RequestParam String img,
                                       @RequestParam String mobile,
                                       @RequestParam String birth,
                                       @RequestParam int sex,
                                       @RequestParam boolean enabled,
                                       @RequestParam String accounts) {
        return customerManageFacade.editCustomer(id, name, img, mobile, birth, sex, enabled, accounts);
    }

    /**
     * 修改用户启用/禁用状态
     *
     * @param id      用户Id
     * @param enabled 是否可用
     * @author haozhongyu
     * @date 2019/12/28 10:13
     **/
    @CheckToken
    @PostMapping("/EditCustomerEnabled.do")
    public ResponseResult editCustomerEnabled(@RequestParam long id,
                                              @RequestParam boolean enabled) {
        return customerManageFacade.editCustomerEnabled(id, enabled);
    }

    /**
     * 删除用户
     *
     * @param id 用户Id
     * @author haozhongyu
     * @date 2019/12/28 10:13
     **/
    @CheckToken
    @PostMapping("/DeleteCustomer.do")
    public ResponseResult deleteCustomer(@RequestParam long id) {
        return customerManageFacade.deleteCustomer(id);
    }

    /**
     * 重置用户密码
     *
     * @param id 用户Id
     * @author hanshuang
     * @date 2020/06/24 14:48
     **/
    @PostMapping("/ResetPassword.do")
    public ResponseResult resetPassword(@RequestParam long id) {
        return customerManageFacade.resetPassword(id);
    }
}
