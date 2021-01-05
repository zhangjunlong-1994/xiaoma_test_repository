package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.bean.base.ConstantBean;
import com.pony.sc_home_personal.bean.response.*;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.config.CheckToken;
import com.pony.sc_home_personal.facade.TypeManageFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 类型
 *
 * @author hanshuang
 * @date 2020/07/07 11:48
 **/
@RestController
@RequestMapping("/ScTypeManage")
public class TypeManageController {

    private final TypeManageFacade typeManageFacade;

    @Autowired
    public TypeManageController(TypeManageFacade typeManageFacade) {
        this.typeManageFacade = typeManageFacade;
    }

    /**
     * 获取类型分类列表
     *
     * @author hanshuang
     * @date 2020/07/07 10:06
     **/
    @CheckToken
    @PostMapping("/SearchTypeMapList.do")
    public ResponseResult<List<ConstantBean>> searchTypeMapList() {
        return typeManageFacade.searchTypeMapList();
    }

    /**
     * 根据类型分类，获取类型分页列表
     *
     * @param type        类型分类
     * @param currentPage 当前页数（从0开始）
     * @param everyPage   每页条数
     * @author hanshuang
     * @date 2020/07/07 10:13
     **/
    @CheckToken
    @PostMapping("/SearchTypeManagePageByType.do")
    public ResponseResult<TypeManagePageBean> searchTypeManagePageByType(@RequestParam int type,
                                                                         @RequestParam int currentPage,
                                                                         @RequestParam int everyPage) {
        return typeManageFacade.searchTypeManagePageByType(type, currentPage, everyPage);
    }

    /**
     * 根据类型分类，获取根类型列表
     *
     * @param type 类型分类
     * @author hanshuang
     * @date 2020/07/07 11:18
     **/
    @CheckToken
    @PostMapping("/SearchParentListByType.do")
    public ResponseResult<TypeManageListBean> searchParentListByType(@RequestParam int type) {
        return typeManageFacade.searchParentListByType(type);
    }

    /**
     * 获取类型列表
     *
     * @author liuwenbo
     * @date 2020/7/21 10:57
     **/
    @CheckToken
    @PostMapping("/SelectAllTypeManage.do")
    public ResponseResult<TypeManageListBean> selectAllTypeManage() {
        return typeManageFacade.selectAllTypeManage();
    }

    /**
     * 编辑类型初始化
     *
     * @param id 类型Id
     * @author hanshuang
     * @date 2020/07/07 10:51
     **/
    @CheckToken
    @PostMapping("/EditTypeManageInit.do")
    public ResponseResult<TypeManageInitBean> editTypeManageInit(@RequestParam long id) {
        return typeManageFacade.editTypeManageInit(id);
    }

    /**
     * 编辑类型
     *
     * @param id       类型Id
     * @param parentId 上级类型Id
     * @param name     类型名称
     * @param nameEn   类型英文名
     * @param img      类型图片
     * @param type     类型分类
     * @author hanshuang
     * @date 2020/07/07 11:02
     **/
    @CheckToken
    @PostMapping("/EditTypeManage.do")
    public ResponseResult editTypeManage(@RequestParam long id,
                                         @RequestParam long parentId,
                                         @RequestParam String name,
                                         @RequestParam String nameEn,
                                         @RequestParam String img,
                                         @RequestParam int type) {
        return typeManageFacade.editTypeManage(id, parentId, name, nameEn, img, type);
    }

    /**
     * 删除类型
     *
     * @param id 类型Id
     * @author hanshuang
     * @date 2020/07/07 11:12
     **/
    @CheckToken
    @PostMapping("/DeleteTypeManage.do")
    public ResponseResult deleteTypeManage(@RequestParam long id) {
        return typeManageFacade.deleteTypeManage(id);
    }

    /**
     * 获取设备功能分页列表
     *
     * @param typeId      类型Id
     * @param currentPage 当前页数（从0开始）
     * @param everyPage   每页条数
     * @author hanshuang
     * @date 2020/07/24 14:33
     **/
    @CheckToken
    @PostMapping("/SearchDeviceFunctionManagePage.do")
    public ResponseResult<DeviceFunctionManagePageBean> searchDeviceFunctionManagePage(@RequestParam long typeId,
                                                                                       @RequestParam int currentPage,
                                                                                       @RequestParam int everyPage) {
        return typeManageFacade.searchDeviceFunctionManagePage(typeId, currentPage, everyPage);
    }

    /**
     * 编辑设备功能初始化
     *
     * @param id 设备功能Id
     * @author hanshuang
     * @date 2020/07/24 14:34
     **/
    @CheckToken
    @PostMapping("/EditDeviceFunctionManageInit.do")
    public ResponseResult<DeviceFunctionManageInitBean> editDeviceFunctionManageInit(@RequestParam long id) {
        return typeManageFacade.editDeviceFunctionManageInit(id);
    }

    /**
     * 编辑设备功能
     *
     * @param id     设备功能Id
     * @param typeId 类型Id
     * @param name   设备功能名
     * @author hanshuang
     * @date 2020/07/24 14:34
     **/
    @CheckToken
    @PostMapping("/EditDeviceFunctionManage.do")
    public ResponseResult editDeviceFunctionManage(@RequestParam long id,
                                                   @RequestParam long typeId,
                                                   @RequestParam String name) {
        return typeManageFacade.editDeviceFunctionManage(id, typeId, name);
    }

    /**
     * 删除设备功能
     *
     * @param id 设备功能Id
     * @author hanshuang
     * @date 2020/07/24 14:36
     **/
    @CheckToken
    @PostMapping("/DeleteDeviceFunctionManage.do")
    public ResponseResult deleteDeviceFunctionManage(@RequestParam long id) {
        return typeManageFacade.deleteDeviceFunctionManage(id);
    }
}
