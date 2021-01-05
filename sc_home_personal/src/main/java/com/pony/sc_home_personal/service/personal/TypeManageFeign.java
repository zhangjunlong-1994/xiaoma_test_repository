package com.pony.sc_home_personal.service.personal;

import com.pony.sc_home_personal.bean.base.ConstantBean;
import com.pony.sc_home_personal.bean.response.*;
import com.pony.sc_home_personal.common.ViewBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author hanshuang
 * @date 2020/07/07 11:57
 **/
@FeignClient(name = "sp-home-personal")
@RequestMapping("/TypeManage")
public interface TypeManageFeign {

    /**
     * @author hanshuang
     * @date 2020/07/07 13:03
     **/
    @PostMapping("/SearchTypeMapList.do")
    ViewBean<List<ConstantBean>> searchTypeMapList();

    /**
     * @author hanshuang
     * @date 2020/07/07 13:05
     **/
    @PostMapping("/SearchTypeManagePageByType.do")
    ViewBean<TypeManagePageBean> searchTypeManagePageByType(@RequestParam("type") int type,
                                                            @RequestParam("currentPage") int currentPage,
                                                            @RequestParam("everyPage") int everyPage);

    /**
     * @author hanshuang
     * @date 2020/07/07 13:09
     **/
    @PostMapping("/searchParentListByType.do")
    ViewBean<TypeManageListBean> searchParentListByType(@RequestParam("type") int type);

    /**
     * @author liuwenbo
     * @date 2020/7/21 10:51
     **/
    @PostMapping("/SelectAllTypeManage.do")
    ViewBean<TypeManageListBean> selectAllTypeManage();

    /**
     * @author hanshuang
     * @date 2020/07/07 13:06
     **/
    @PostMapping("/EditTypeManageInit.do")
    ViewBean<TypeManageInitBean> editTypeManageInit(@RequestParam("id") long id);

    /**
     * @author hanshuang
     * @date 2020/07/07 13:08
     **/
    @PostMapping("/EditTypeManage.do")
    ViewBean editTypeManage(@RequestParam("id") long id,
                            @RequestParam("parentId") long parentId,
                            @RequestParam("name") String name,
                            @RequestParam("nameEn") String nameEn,
                            @RequestParam("img") String img,
                            @RequestParam("type") int type);

    /**
     * @author hanshuang
     * @date 2020/07/07 13:09
     **/
    @PostMapping("/DeleteTypeManage.do")
    ViewBean deleteTypeManage(@RequestParam("id") long id);

    /**
     * @author hanshuang
     * @date 2020/07/24 14:41
     **/
    @PostMapping("/SearchDeviceFunctionManagePage.do")
    ViewBean<DeviceFunctionManagePageBean> searchDeviceFunctionManagePage(@RequestParam("typeId") long typeId,
                                                                          @RequestParam("currentPage") int currentPage,
                                                                          @RequestParam("everyPage") int everyPage);

    /**
     * @author hanshuang
     * @date 2020/07/24 14:41
     **/
    @PostMapping("/EditDeviceFunctionManageInit.do")
    ViewBean<DeviceFunctionManageInitBean> editDeviceFunctionManageInit(@RequestParam("id") long id);

    /**
     * @author hanshuang
     * @date 2020/07/24 14:41
     **/
    @PostMapping("/EditDeviceFunctionManage.do")
    ViewBean editDeviceFunctionManage(@RequestParam("id") long id,
                                      @RequestParam("typeId") long typeId,
                                      @RequestParam("name") String name);

    /**
     * @author hanshuang
     * @date 2020/07/24 14:42
     **/
    @PostMapping("/DeleteDeviceFunctionManage.do")
    ViewBean deleteDeviceFunctionManage(@RequestParam("id") long id);
}
