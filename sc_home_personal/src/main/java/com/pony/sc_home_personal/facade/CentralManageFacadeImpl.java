package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.base.CentralBean;
import com.pony.sc_home_personal.bean.response.CentralInitBean;
import com.pony.sc_home_personal.bean.response.CentralListBean;
import com.pony.sc_home_personal.bean.response.CentralPageBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ResultStatus;
import com.pony.sc_home_personal.common.ViewBean;
import com.pony.sc_home_personal.service.communication.CommunicationFeign;
import com.pony.sc_home_personal.service.personal.CentralManageFeign;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author suntai
 * @date 2019/11/26 15:02
 */
@Component
public class CentralManageFacadeImpl implements CentralManageFacade {

    @Resource
    private CommunicationFeign communicationFeign;
    @Resource
    private CentralManageFeign centralManageFeign;

    @Override
    public ResponseResult<CentralPageBean> searchPage(String province, String city, String region, String communityName,
                                                      long customerId, int currentPage, int everyPage) {
        ViewBean<CentralPageBean> viewBean = centralManageFeign.searchCentralPage(
                province, city, region, communityName, customerId, currentPage, everyPage);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<CentralListBean> searchListByCustomerId(long customerId) {
        ViewBean<CentralListBean> viewBean = centralManageFeign.searchCentralListByCustomerId(customerId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<CentralBean> searchByHouseId(long houseId) {
        ViewBean<CentralBean> viewBean = centralManageFeign.searchCentralByHouseId(houseId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<CentralBean> searchByMac(String mac) {
        ViewBean<CentralBean> viewBean = centralManageFeign.searchCentralByMac(mac);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<CentralInitBean> editCentralInit(long id) {
        ViewBean<CentralInitBean> viewBean = centralManageFeign.editCentralInit(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult editCentral(long id, String mac, int state, long editionId) {
        //旧Mac
        ViewBean<CentralBean> centralViewBean = centralManageFeign.searchCentralByHouseId(id);

        ViewBean viewBean = centralManageFeign.editCentral(id, mac, state, editionId);
        if (viewBean.getCode() == ResultStatus.SUCCESS_INSERT.getCode() ||
                viewBean.getCode() == ResultStatus.SUCCESS_UPDATE.getCode()) {
            //删除旧Mac
            if (centralViewBean.getCode() == ResultStatus.SUCCESS_SELECT.getCode()) {
                communicationFeign.deleteByMac(centralViewBean.getData().getMac());
            }
            //添加新Mac
            communicationFeign.saveDevice(mac.trim().toUpperCase());
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult deleteCentral(long id) {
        ViewBean<CentralBean> viewBean = centralManageFeign.deleteCentral(id);
        if (viewBean.getCode() == ResultStatus.SUCCESS_DELETE.getCode()) {
            communicationFeign.deleteByMac(viewBean.getData().getMac());
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }
}
