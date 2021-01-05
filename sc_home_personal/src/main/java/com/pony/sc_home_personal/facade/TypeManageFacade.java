package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.base.ConstantBean;
import com.pony.sc_home_personal.bean.response.*;
import com.pony.sc_home_personal.common.ResponseResult;

import java.util.List;

/**
 * @author hanshuang
 * @date 2020/07/07 9:33
 **/
public interface TypeManageFacade {

    /**
     * @author hanshuang
     * @date 2020/07/07 10:08
     **/
    ResponseResult<List<ConstantBean>> searchTypeMapList();

    /**
     * @author hanshuang
     * @date 2020/07/07 10:17
     **/
    ResponseResult<TypeManagePageBean> searchTypeManagePageByType(int type, int currentPage, int everyPage);

    /**
     * @author hanshuang
     * @date 2020/07/07 10:53
     **/
    ResponseResult<TypeManageInitBean> editTypeManageInit(long id);

    /**
     * @author hanshuang
     * @date 2020/07/07 11:06
     **/
    ResponseResult editTypeManage(long id, long parentId, String name, String nameEn, String img, int type);

    /**
     * @author hanshuang
     * @date 2020/07/07 11:13
     **/
    ResponseResult deleteTypeManage(long id);

    /**
     * @author hanshuang
     * @date 2020/07/07 11:20
     **/
    ResponseResult<TypeManageListBean> searchParentListByType(int type);

    /**
     * @author liuwenbo
     * @date 2020/7/21 10:55
     **/
    ResponseResult<TypeManageListBean> selectAllTypeManage();

    /**
     * @author hanshuang
     * @date 2020/07/24 14:37
     **/
    ResponseResult<DeviceFunctionManagePageBean> searchDeviceFunctionManagePage(long typeId, int currentPage, int everyPage);

    /**
     * @author hanshuang
     * @date 2020/07/24 14:37
     **/
    ResponseResult<DeviceFunctionManageInitBean> editDeviceFunctionManageInit(long id);

    /**
     * @author hanshuang
     * @date 2020/07/24 14:37
     **/
    ResponseResult editDeviceFunctionManage(long id, long typeId, String name);

    /**
     * @author hanshuang
     * @date 2020/07/24 14:38
     **/
    ResponseResult deleteDeviceFunctionManage(long id);
}
