package com.pony.sc_home_personal.common;

/**
 * @author gaofeng
 * @date 2019/12/21 13:55
 **/
public enum ResultStatus {
    SUCCESS_SELECT(10001, "查询成功"),
    SUCCESS_NO_DATA(10002, "暂无数据"),
    SUCCESS_INSERT(10003, "新增成功"),
    SUCCESS_UPDATE(10004, "编辑成功"),
    SUCCESS_DELETE(10005, "删除成功"),
    SUCCESS_SETTING(10006, "设置成功"),
    SUCCESS_EDIT_PASSWORD(10007, "修改密码成功"),
    SUCCESS_RESET_PASSWORD(10008, "重置密码成功"),
    SUCCESS_ACCOUNT_AVAILABLE(10009, "该帐号名称可用"),
    SUCCESS_PAY(10010, "支付成功"),
    SUCCESS_CHECK(10011, "审核成功"),

    EXISTENT_NO_PAY(30001, "支付失败"),
    EXISTENT_NO_CONSTANT(20000, "常量信息不存在"),


    /* =====================================共通sp-common-manage===================================== */

    //共通-menu
    EXISTENT_NO_MENU_MODULES(20001, "菜单模块信息不存在"),
    EXISTENT_MENU_MODULES(20002, "存在菜单模块信息"),
    EXISTENT_NO_MENU_MODULES_LIST(20003, "菜单模块列表信息不存在"),
    EXISTENT_NO_MENU_MODULES_PAGE(20004, "菜单模块分页信息不存在"),

    EXISTENT_NO_MENU_MODULES_GROUP(20005, "菜单模块组信息不存在"),
    EXISTENT_MENU_MODULES_GROUP(20006, "存在菜单模块组信息"),
    EXISTENT_NO_MENU_MODULES_GROUP_LIST(20007, "菜单模块组列表信息不存在"),
    EXISTENT_NO_MENU_MODULES_GROUP_PAGE(20008, "菜单模块组分页信息不存在"),

    EXISTENT_NO_MENU_MODULES_RELATION(20009, "菜单模块关联信息不存在"),
    EXISTENT_MENU_MODULES_RELATION(20010, "存在菜单模块关联信息"),
    EXISTENT_NO_MENU_MODULES_RELATION_LIST(20011, "菜单模块关联列表信息不存在"),
    EXISTENT_NO_MENU_MODULES_RELATION_PAGE(20012, "菜单模块关联分页信息不存在"),

    //共通-permission
    EXISTENT_NO_PERMISSION(20013, "权限信息不存在"),
    EXISTENT_PERMISSION(20014, "存在权限信息"),
    EXISTENT_NO_PERMISSION_LIST(20015, "权限列表信息不存在"),
    EXISTENT_NO_PERMISSION_PAGE(20016, "权限分页信息不存在"),

    EXISTENT_NO_PERMISSION_GROUP(20017, "权限组信息不存在"),
    EXISTENT_PERMISSION_GROUP(20018, "存在权限组信息"),
    EXISTENT_NO_PERMISSION_GROUP_LIST(20019, "权限组列表信息不存在"),
    EXISTENT_NO_PERMISSION_GROUP_PAGE(20020, "权限组分页信息不存在"),

    EXISTENT_NO_PERMISSION_RELATION(20021, "权限关联信息不存在"),
    EXISTENT_PERMISSION_RELATION(20022, "存在权限关联信息"),
    EXISTENT_NO_PERMISSION_RELATION_LIST(20023, "权限关联列表信息不存在"),
    EXISTENT_NO_PERMISSION_RELATION_PAGE(20024, "权限关联分页信息不存在"),

    //共通-company
    EXISTENT_NO_COMPANY(20025, "公司信息不存在"),
    EXISTENT_COMPANY(20026, "存在公司信息"),
    EXISTENT_NO_COMPANY_LIST(20027, "公司列表信息不存在"),
    EXISTENT_NO_COMPANY_PAGE(20028, "公司分页信息不存在"),

    //共通-department
    EXISTENT_NO_DEPARTMENT(20029, "部门信息不存在"),
    EXISTENT_DEPARTMENT(20030, "部门公司信息"),
    EXISTENT_NO_DEPARTMENT_LIST(20031, "部门列表信息不存在"),
    EXISTENT_NO_DEPARTMENT_PAGE(20032, "部门分页信息不存在"),

    //共通-position
    EXISTENT_NO_POSITION(20033, "职务信息不存在"),
    EXISTENT_POSITION(20034, "职务公司信息"),
    EXISTENT_NO_POSITION_LIST(20035, "职务列表信息不存在"),
    EXISTENT_NO_POSITION_PAGE(20036, "职务分页信息不存在"),

    //共通-profession
    EXISTENT_NO_PROFESSION(20037, "职称信息不存在"),
    EXISTENT_PROFESSION(20038, "职称公司信息"),
    EXISTENT_NO_PROFESSION_LIST(20039, "职称列表信息不存在"),
    EXISTENT_NO_PROFESSION_PAGE(20040, "职称分页信息不存在"),

    //共通-staff
    EXISTENT_NO_STAFF(20041, "员工信息不存在"),
    EXISTENT_STAFF(20042, "员工公司信息"),
    EXISTENT_NO_STAFF_LIST(20043, "员工列表信息不存在"),
    EXISTENT_NO_STAFF_PAGE(20044, "员工分页信息不存在"),

    //共通-login
    EXISTENT_NO_LOGIN(20045, "登录信息不存在"),
    EXISTENT_LOGIN(20046, "登录公司信息"),
    EXISTENT_NO_LOGIN_LIST(20047, "登录列表信息不存在"),
    EXISTENT_NO_LOGIN_PAGE(20048, "登录分页信息不存在"),

    //共通-关联
    EXISTENT_NO_MENU_RELATION_MODULES(20049, "菜单模块关联菜单模块信息不存在"),
    EXISTENT_NO_MENU_RELATION_MODULES_LIST(20050, "菜单模块关联菜单模块列表信息不存在"),
    EXISTENT_NO_MENU_RELATION_MODULES_PAGE(20051, "菜单模块关联菜单模块分页信息不存在"),

    EXISTENT_NO_COMPANY_PARENT(20052, "公司上级信息不存在"),
    EXISTENT_NO_COMPANY_PARENT_LIST(20053, "公司上级列表信息不存在"),
    EXISTENT_NO_COMPANY_PARENT_PAGE(20054, "公司上级分页信息不存在"),

    EXISTENT_NO_DEPARTMENT_PARENT_COMPANY(20055, "部门上级公司信息不存在"),
    EXISTENT_NO_DEPARTMENT_PARENT_COMPANY_LIST(20056, "部门上级公司列表信息不存在"),
    EXISTENT_NO_DEPARTMENT_PARENT_COMPANY_PAGE(20057, "部门上级公司分页信息不存在"),

    EXISTENT_NO_POSITION_DEPARTMENT_COMPANY(20058, "职务部门公司信息不存在"),
    EXISTENT_NO_POSITION_DEPARTMENT_COMPANY_LIST(20059, "职务部门公司列表信息不存在"),
    EXISTENT_NO_POSITION_DEPARTMENT_COMPANY_PAGE(20060, "职务部门公司分页信息不存在"),

    EXISTENT_NO_STAFF_LOGIN_COMPANY_DEPARTMENT_POSITION_PROFESSION_GROUP(20061, "员工登录公司部门职务职称菜单组信息不存在"),
    EXISTENT_NO_STAFF_LOGIN_COMPANY_DEPARTMENT_POSITION_PROFESSION_GROUP_LIST(20062, "员工登录公司部门职务职称菜单组列表信息不存在"),
    EXISTENT_NO_STAFF_LOGIN_COMPANY_DEPARTMENT_POSITION_PROFESSION_GROUP_PAGE(20063, "员工登录公司部门职务职称菜单组分页信息不存在"),

    IS_NO_STAFF_MANAGER(20064, "该员工非超级管理员"),
    IS_STAFF_MANAGER(20065, "该员工为超级管理员"),
    EXISTENT_NO_ACCOUNT(20066, "帐号不存在"),
    CORRECT_NO_PASSWORD(20067, "密码不正确"),
    EQUAL_NO_PASSWORD(20068, "新旧密码不相同"),


    /* =====================================智能家居sp-personal—customer===================================== */

    //登录
    SUCCESS_LOGIN(10101, "登录成功"),
    SUCCESS_LOGIN_EDIT(10102, "编辑成功"),
    SUCCESS_LOGIN_PASSWORD_EDIT(10103, "密码修改成功"),
    SUCCESS_LOGIN_PASSWORD_RESET(10104, "密码重置成功"),
    SUCCESS_LOGIN_DELETE(10105, "删除成功"),
    SUCCESS_LOGIN_ACCOUNTS(10106, "账号可用"),
    SUCCESS_DEVICE_WORK(10107, "设备操作成功"),
    SUCCESS_SEND_SMS(10108, "验证码发送成功"),
    SUCCESS_REGISTER(10109, "注册成功"),


    EXISTENT_LOGIN_NO(20101, "登录信息不存在"),
    EXISTENT_LOGIN_PASSWORD(20102, "密码不正确"),
    EXISTENT_LOGIN_ACCOUNTS(20103, "账号已存在"),

    //用户
    EXISTENT_NO_CUSTOMER(20104, "用户信息不存在"),
    EXISTENT_NO_CUSTOMER_ENABLED(20220, "用户被禁用"),
    EXISTENT_HOUSE_RELATIONSHIP(20227, "用户被禁用"),
    EXISTENT_HAVE_CUSTOMER(20229, "用户信息已存在"),

    //房产
    EXISTENT_NO_HOUSE(20105, "房产信息不存在"),
    EXISTENT_BIND_ROOM(20106, "存在相关房间信息"),
    EXISTENT_BIND_SCENARIO_MODE(20107, "存在相关情景模式信息"),

    //房间
    EXISTENT_NO_ROOM(20108, "房间信息不存在"),
    EXISTENT_BIND_DEVICE(20109, "存在相关设备信息"),

    //网关
    EXISTENT_NO_CENTRAL_CONTROLLER(20110, "网关信息不存在"),

    //中继
    EXISTENT_NO_RELAY(20123, "中继信息不存在"),

    //设备
    EXISTENT_NO_DEVICE(20111, "设备信息不存在"),

    //设备功能
    EXISTENT_NO_DEVICE_FUNCTION(20112, "设备功能不存在"),

    //通讯
    INTELLIGENT_DEVICE_CODE_ERROR(20113, "设备类别信息错误"),
    INTELLIGENT_NO_DEVICE_CODE(20114, "暂无未使用功能码"),
    INTELLIGENT_DEVICE_NO_WORK(20115, "设备操作失败"),

    //警报
    EXISTENT_NO_WARN_FUNCTION(20116, "警报设置信息不存在"),

    //情景模式
    EXISTENT_NO_SCENARIO_MODE(20117, "情景模式不存在"),

    //日程
    EXISTENT_NO_SCHEDULE(20118, "日程不存在"),
    EXISTENT_SEND_SMS(20119, "验证码发送失败"),
    EXISTENT_VERIFY_PAST_DUE(20121, "验证码已过期"),
    EXISTENT_VERIFY(20122, "验证码错误"),
    EXISTENT_REGISTER(20223, "注册失败"),
    EXISTENT_PASS_WORD(20224, "新密码和原密码相同"),

    //类型
    EXISTENT_NO_TYPE_MANAGE(20225, "类型信息不存在"),
    EXISTENT_DELETE_FAIL_TO(20230, "删除失败，存在关联信息"),

    //关于我们
    EXISTENT_NO_ABOUT_US(20226, "关于我们信息不存在"),

    //忘记密码
    EXISTENT_NO_PHONE(20228, "该手机号未注册"),

    //新增情景模式失败
    EXISTENT_FAILED_ADD_SCENARIO(20231, "无新增情景模式信息"),

    //新增情景模式异常
    EXISTENT_ERROR_ADD_SCENARIO(20232, "新增情景模式失败"),

    //新增房间失败
    EXISTENT_FAILED_ADD_ROOM(20233, "无新增房间信息"),

    //新增房间异常
    EXISTENT_ERROR_ADD_ROOM(20234, "新增房间失败"),

    //版本类型
    EXISTENT_NO_EDITION(20235, "版本信息不存在"),
    EXISTENT_NO_NAME(20236, "可以使用该版本名"),
    EXISTENT_NAME(20237, "该版本名已存在"),
    EXISTENT_NO_EDITION_MESSAGE(20238, "暂无版本信息"),

    //JSON转换异常
    EXISTENT_FAILED_JSON(20239, "JSON转换异常"),

    //报警设置异常
    EXISTENT_FAILED_EDIT_WARN_SETTING(20240, "报警设置保存失败"),

    //设备状态
    EXISTENT_DEVICE_STATE_UNBIND(20241, "设备未绑定"),
    EXISTENT_DEVICE_STATE_OFF(20242, "设备离线"),
    EXISTENT_DEVICE_STATE_STUDY(20243, "设备动作中"),
    /* =====================================智能家居-非法===================================== */
    PERMISSION_NO(30000, "权限不足"),
    ILLEGAL_PARAMETER(40000, "参数字符非法");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
