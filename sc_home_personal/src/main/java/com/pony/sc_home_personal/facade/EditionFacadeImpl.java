package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.base.EditionBean;
import com.pony.sc_home_personal.bean.response.EditionInitBean;
import com.pony.sc_home_personal.bean.response.EditionListBean;
import com.pony.sc_home_personal.bean.response.EditionPageBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ResultStatus;
import com.pony.sc_home_personal.common.ViewBean;
import com.pony.sc_home_personal.service.ImageFeign;
import com.pony.sc_home_personal.service.personal.EditionFeign;
import com.pony.sc_home_personal.util.PathUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author liguotao
 * @date 2020/8/28 14:54
 */
@Component
public class EditionFacadeImpl implements EditionFacade {

    @Resource
    private EditionFeign editionFeign;

    @Resource
    private ImageFeign imageFeign;

    @Override
    public ResponseResult<EditionPageBean> searchEditionPageByTypeAndName(int type, int hardwareType, String name, int currentPage, int everyPage) {
        ViewBean<EditionPageBean> viewBean = editionFeign.searchEditionPageByTypeAndName(type, hardwareType, name, currentPage, everyPage);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<EditionListBean> searchEditionList(int type, int hardwareType) {
        ViewBean<EditionListBean> viewBean = editionFeign.searchEditionList(type, hardwareType);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult deleteEdition(long id) {
        ViewBean<EditionBean> viewBean = editionFeign.deleteEdition(id);
        //删除成功，将对应的HEX文件删除
        if (viewBean.getCode() == ResultStatus.SUCCESS_DELETE.getCode()) {
            if (viewBean.getData() != null && viewBean.getData().getFileName() != null && viewBean.getData().getFileName().length() > 0) {
                imageFeign.deleteImage(viewBean.getData().getFileName(), PathUtil.editionFilePath);
            }
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<EditionInitBean> editEditionInit(long id) {
        ViewBean<EditionInitBean> viewBean = editionFeign.editEditionInit(id);
        if (viewBean.getData() != null && viewBean.getData().getEditionBean() != null &&
                viewBean.getData().getEditionBean().getFileName() != null && viewBean.getData().getEditionBean().getFileName().length() > 0) {
            viewBean.getData().getEditionBean().setFileName(PathUtil.getEsPath() + PathUtil.editionFilePath + viewBean.getData().getEditionBean().getFileName());
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult searchEditionNameExist(String name, int equipmentType, int hardwareType) {
        ViewBean viewBean = editionFeign.searchEditionNameExist(name, equipmentType, hardwareType);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<String> searchNewEdition(int equipmentType, int hardwareType) {
        ViewBean<String> viewBean = editionFeign.searchNewEdition(equipmentType, hardwareType);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult editEdition(long id, String name, int hardwareType, int equipmentType, String fileName, String explain) {
        //保存新的HEX文件
        if (fileName != null && fileName.length() > 0) {
            imageFeign.transferShortTimeImage(fileName, PathUtil.editionFilePath);
        }
        //保存版本信息
        ViewBean viewBean = editionFeign.editEdition(id, name, hardwareType, equipmentType, fileName, explain);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }
}
