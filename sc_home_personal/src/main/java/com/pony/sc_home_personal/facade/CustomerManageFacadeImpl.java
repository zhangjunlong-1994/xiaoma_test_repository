package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.base.CustomerBean;
import com.pony.sc_home_personal.bean.response.CustomerInitBean;
import com.pony.sc_home_personal.bean.response.CustomerListBean;
import com.pony.sc_home_personal.bean.response.CustomerPageBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ResultStatus;
import com.pony.sc_home_personal.common.ViewBean;
import com.pony.sc_home_personal.service.ImageFeign;
import com.pony.sc_home_personal.service.personal.CustomerManageFeign;
import com.pony.sc_home_personal.util.PathUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haozhongyu
 * @date 2019/11/26 14:29
 **/
@Component
public class CustomerManageFacadeImpl implements CustomerManageFacade {

    @Resource
    private CustomerManageFeign customerManageFeign;
    @Resource
    private ImageFeign imageFeign;

    @Override
    public ResponseResult<CustomerPageBean> SearchCustomerPageById(long userId, int currentPage, int everyPage) {
        ViewBean<CustomerPageBean> viewBean = customerManageFeign.SearchCustomerPageById(userId, currentPage, everyPage);
        if (viewBean.getData() != null && viewBean.getData().getCustomerPageBean() != null &&
                viewBean.getData().getCustomerPageBean().getContent() != null) {
            List<CustomerBean> customerBeanList = viewBean.getData().getCustomerPageBean().getContent();
            for (CustomerBean customerBean : customerBeanList) {
                if (customerBean != null && customerBean.getImg() != null && customerBean.getImg().length() > 0) {
                    customerBean.setImg(PathUtil.getEsPath() + PathUtil.customerImgPath + customerBean.getImg());
                }
            }
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<CustomerListBean> SearchCustomerListByNameOrMobile(String nameOrMobile) {
        ViewBean<CustomerListBean> viewBean = customerManageFeign.searchCustomerListByNameOrMobile(nameOrMobile);
        if (viewBean.getData() != null && viewBean.getData().getCustomerBeanList() != null) {
            List<CustomerBean> customerBeanList = viewBean.getData().getCustomerBeanList();
            for (CustomerBean customerBean : customerBeanList) {
                if (customerBean != null && customerBean.getImg() != null && customerBean.getImg().length() > 0) {
                    customerBean.setImg(PathUtil.getEsPath() + PathUtil.customerImgPath + customerBean.getImg());
                }
            }
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<CustomerInitBean> editCustomerInit(long id) {
        ViewBean<CustomerInitBean> viewBean = customerManageFeign.editCustomerInit(id);
        if (viewBean.getData() != null && viewBean.getData().getCustomerBean() != null) {
            CustomerBean customerBean = viewBean.getData().getCustomerBean();
            if (customerBean != null && customerBean.getImg() != null && customerBean.getImg().length() > 0) {
                customerBean.setImg(PathUtil.getEsPath() + PathUtil.customerImgPath + customerBean.getImg());
            }
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult editCustomer(long id, String name, String img, String mobile,
                                       String birth, int sex, boolean enabled, String accounts) {
        CustomerBean customerBean = null;
        if (id > 0) {
            ViewBean<CustomerInitBean> customerInitViewBean = customerManageFeign.editCustomerInit(id);
            if (customerInitViewBean.getCode() == ResultStatus.SUCCESS_SELECT.getCode()) {
                customerBean = customerInitViewBean.getData().getCustomerBean();
            }
        }
        ViewBean viewBean = customerManageFeign.editCustomer(id, name, img, mobile, birth, sex, enabled, accounts);
        //新增
        if (viewBean.getCode() == ResultStatus.SUCCESS_INSERT.getCode() && img != null && img.length() > 0) {
            imageFeign.transferShortTimeImage(img, PathUtil.customerImgPath);
        }
        //修改
        if (viewBean.getCode() == ResultStatus.SUCCESS_UPDATE.getCode() && img != null && img.length() > 0) {
            imageFeign.transferShortTimeImage(img, PathUtil.customerImgPath);
            if (customerBean != null && customerBean.getImg() != null && customerBean.getImg().length() > 0) {
                imageFeign.deleteImage(customerBean.getImg(), PathUtil.customerImgPath);
            }
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult editCustomerEnabled(long id, boolean enabled) {
        ViewBean viewBean = customerManageFeign.editCustomerEnabled(id, enabled);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult deleteCustomer(long id) {
        ViewBean viewBean = customerManageFeign.deleteCustomer(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult resetPassword(long id) {
        ViewBean viewBean = customerManageFeign.resetPassword(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }
}
