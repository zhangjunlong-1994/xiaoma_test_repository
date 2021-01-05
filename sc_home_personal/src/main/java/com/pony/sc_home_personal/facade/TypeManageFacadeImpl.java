package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.base.ConstantBean;
import com.pony.sc_home_personal.bean.base.TypeManageBean;
import com.pony.sc_home_personal.bean.response.*;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ResultStatus;
import com.pony.sc_home_personal.common.ViewBean;
import com.pony.sc_home_personal.service.ImageFeign;
import com.pony.sc_home_personal.service.personal.TypeManageFeign;
import com.pony.sc_home_personal.util.PathUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hanshuang
 * @date 2020/07/07 9:33
 **/
@Component
public class TypeManageFacadeImpl implements TypeManageFacade {

    @Resource
    private TypeManageFeign typeManageFeign;
    @Resource
    private ImageFeign imageFeign;

    @Override
    public ResponseResult<List<ConstantBean>> searchTypeMapList() {
        ViewBean<List<ConstantBean>> viewBean = typeManageFeign.searchTypeMapList();
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<TypeManagePageBean> searchTypeManagePageByType(int type, int currentPage, int everyPage) {
        ViewBean<TypeManagePageBean> viewBean = typeManageFeign.searchTypeManagePageByType(type, currentPage, everyPage);
        if (viewBean.getData() != null && viewBean.getData().getPageNavigator() != null) {
            viewBean.getData().getPageNavigator().getContent().forEach(typeManageBean -> {
                if (typeManageBean.getImg() != null && typeManageBean.getImg().length() > 0) {
                    typeManageBean.setImg(PathUtil.getEsPath() + PathUtil.typeImgPath + typeManageBean.getImg());
                }
            });
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<TypeManageInitBean> editTypeManageInit(long id) {
        ViewBean<TypeManageInitBean> viewBean = typeManageFeign.editTypeManageInit(id);
        if (viewBean.getData() != null && viewBean.getData().getTypeManageBean() != null &&
                viewBean.getData().getTypeManageBean().getImg() != null && viewBean.getData().getTypeManageBean().getImg().length() > 0) {
            viewBean.getData().getTypeManageBean().setImg(PathUtil.getEsPath() + PathUtil.typeImgPath + viewBean.getData().getTypeManageBean().getImg());
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult editTypeManage(long id, long parentId, String name, String nameEn, String img, int type) {
        if (img != null && img.length() > 0) {
            imageFeign.transferShortTimeImage(img, PathUtil.typeImgPath);
        }
        TypeManageBean typeManageBean = null;
        if (id > 0) {
            ViewBean<TypeManageInitBean> initViewBean = typeManageFeign.editTypeManageInit(id);
            if (initViewBean.getData() != null) {
                typeManageBean = initViewBean.getData().getTypeManageBean();
            }
        }
        ViewBean viewBean = typeManageFeign.editTypeManage(id, parentId, name, nameEn, img, type);
        if (viewBean.getCode() == ResultStatus.SUCCESS_UPDATE.getCode() &&
                typeManageBean != null && typeManageBean.getImg() != null && typeManageBean.getImg().length() > 0) {
            imageFeign.deleteImage(typeManageBean.getImg(), PathUtil.typeImgPath);
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult deleteTypeManage(long id) {
        ViewBean viewBean = typeManageFeign.deleteTypeManage(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<TypeManageListBean> searchParentListByType(int type) {
        ViewBean<TypeManageListBean> viewBean = typeManageFeign.searchParentListByType(type);
        if (viewBean.getData() != null && viewBean.getData().getTypeManageBeanList() != null) {
            viewBean.getData().getTypeManageBeanList().forEach(typeManageBean -> {
                if (typeManageBean.getImg() != null && typeManageBean.getImg().length() > 0) {
                    typeManageBean.setImg(PathUtil.getEsPath() + PathUtil.typeImgPath + typeManageBean.getImg());
                }
            });
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<TypeManageListBean> selectAllTypeManage() {
        ViewBean<TypeManageListBean> viewBean = typeManageFeign.selectAllTypeManage();
        if (viewBean.getData() != null && viewBean.getData().getTypeManageBeanList() != null) {
            viewBean.getData().getTypeManageBeanList().forEach(typeManageBean -> {
                if (typeManageBean.getImg() != null && typeManageBean.getImg().length() > 0) {
                    typeManageBean.setImg(PathUtil.getEsPath() + PathUtil.typeImgPath + typeManageBean.getImg());
                }
            });
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<DeviceFunctionManagePageBean> searchDeviceFunctionManagePage(long typeId, int currentPage, int everyPage) {
        ViewBean<DeviceFunctionManagePageBean> viewBean = typeManageFeign.searchDeviceFunctionManagePage(typeId, currentPage, everyPage);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<DeviceFunctionManageInitBean> editDeviceFunctionManageInit(long id) {
        ViewBean<DeviceFunctionManageInitBean> viewBean = typeManageFeign.editDeviceFunctionManageInit(id);
        if (viewBean.getData() != null && viewBean.getData().getTypeManageBeanList() != null) {
            viewBean.getData().getTypeManageBeanList().forEach(typeManageBean -> {
                if (typeManageBean.getImg() != null && typeManageBean.getImg().length() > 0) {
                    typeManageBean.setImg(PathUtil.getEsPath() + PathUtil.typeImgPath + typeManageBean.getImg());
                }
            });
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult editDeviceFunctionManage(long id, long typeId, String name) {
        ViewBean viewBean = typeManageFeign.editDeviceFunctionManage(id, typeId, name);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult deleteDeviceFunctionManage(long id) {
        ViewBean viewBean = typeManageFeign.deleteDeviceFunctionManage(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }
}
