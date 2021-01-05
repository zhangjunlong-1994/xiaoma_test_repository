package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.base.CustomerServiceBean;
import com.pony.sc_home_personal.bean.base.StaffBean;
import com.pony.sc_home_personal.bean.response.*;
import com.pony.sc_home_personal.common.Constant;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ResultStatus;
import com.pony.sc_home_personal.common.ViewBean;
import com.pony.sc_home_personal.service.ImageFeign;
import com.pony.sc_home_personal.service.common.InstitutionManageFeign;
import com.pony.sc_home_personal.service.personal.CustomerServerFeign;
import com.pony.sc_home_personal.socket.WebSocketServer;
import com.pony.sc_home_personal.util.PathUtil;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author suntai
 * @date 2019/12/2 11:01
 */
@Component
public class CustomerServiceFacadeImpl implements CustomerServiceFacade {

    @Resource
    private CustomerServerFeign customerServerFeign;
    @Resource
    private ImageFeign imageFeign;
    @Resource
    private InstitutionManageFeign institutionManageFeign;

    @Override
    public ResponseResult<CustomerServiceMessageListBean> searchCustomerMessageInit(String nameOrMobile) {
        ViewBean<CustomerServiceMessageListBean> viewBean = customerServerFeign.searchCustomerMessageInit(nameOrMobile);
        if (viewBean.getData() != null && viewBean.getData().getCustomerServiceMessageBeanList() != null) {
            viewBean.getData().getCustomerServiceMessageBeanList().forEach(customerServiceMessageBean -> {
                if (customerServiceMessageBean.getCustomerBean() != null &&
                        customerServiceMessageBean.getCustomerBean().getImg() != null &&
                        customerServiceMessageBean.getCustomerBean().getImg().length() > 0) {
                    customerServiceMessageBean.getCustomerBean().setImg(
                            PathUtil.getEsPath() + PathUtil.customerImgPath + customerServiceMessageBean.getCustomerBean().getImg());
                }
                if(customerServiceMessageBean.getPageNavigator() != null) {
                    customerServiceMessageBean.getPageNavigator().getContent().forEach(customerServiceBean -> {
                        if (customerServiceBean.getType() == 2) {
                            customerServiceBean.setContent(PathUtil.getEsPath() + PathUtil.customerServicePath + customerServiceBean.getContent());
                        }
                    });
                }
            });
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<CustomerServiceMessageBean> searchCustomerMessageByCustomerId(
            long customerId, long manageId, String name, int currentPage, int everyPage) {
        ViewBean<CustomerServiceMessageBean> viewBean = customerServerFeign.searchCustomerMessageByCustomerId(customerId, currentPage, everyPage);
        //拼接图片
        if(viewBean.getCode() == 10001) {
            String img = PathUtil.getEsPath() + PathUtil.customerImgPath + viewBean.getData().getCustomerBean().getImg();
            viewBean.getData().getCustomerBean().setImg(img);
        }
        customerServerFeign.editMessageReaded(customerId, WebSocketServer.TYPE_USER);
        if (viewBean.getData() != null && viewBean.getData().getPageNavigator() != null &&
                viewBean.getData().getPageNavigator().getContent() != null && !viewBean.getData().getPageNavigator().getContent().isEmpty()) {
            List<CustomerServiceBean> customerServiceBeanList = viewBean.getData().getPageNavigator().getContent();
            if (!customerServiceBeanList.get(customerServiceBeanList.size() - 1).isReaded() &&
                    customerServiceBeanList.get(customerServiceBeanList.size() - 1).getManageId() == 0) {
                editCustomerServiceMessage(manageId, customerId, WebSocketServer.TYPE_MANAGER, 0, "客服" + name + "正在进行解答");
            }
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<CustomerServiceAppMessageListBean> searchAppCustomerMessageByCustomerId(long customerId, int currentPage, int everyPage) {
        ViewBean<CustomerServiceMessageBean> viewBean = customerServerFeign.searchCustomerMessageByCustomerId(customerId, currentPage, everyPage);
        customerServerFeign.editMessageReaded(customerId, WebSocketServer.TYPE_MANAGER);
        if (viewBean.getData() != null && viewBean.getData().getPageNavigator() != null &&
                viewBean.getData().getPageNavigator().getContent() != null) {
            if (viewBean.getData().getPageNavigator().getContent().isEmpty()) {
                return ResponseResult.success(ResultStatus.SUCCESS_NO_DATA.getCode(), null);
            }
            List<CustomerServiceBean> customerServiceBeanList = viewBean.getData().getPageNavigator().getContent();
            CustomerServiceAppMessageListBean customerServiceAppMessageListBean = new CustomerServiceAppMessageListBean();

            //消息数据
            List<CustomerServiceAppMessageBean> customerServiceAppMessageBeanList = customerServiceBeanList.stream().map(customerServiceBean -> {
//                ViewBean<StaffBean> staffViewBean = institutionManageFeign.searchStaff(customerServiceBean.getManageId());
                CustomerServiceAppMessageBean customerServiceAppMessageBean = new CustomerServiceAppMessageBean();
                if (customerServiceBean.getType() == Constant.customerServiceTypeImage
                        && customerServiceBean.getContent() != null
                        && customerServiceBean.getContent().length() > 0) {
                    customerServiceBean.setContent(PathUtil.getEsPath() + PathUtil.customerServicePath + customerServiceBean.getContent());
                }
                customerServiceAppMessageBean.setCustomerServiceBean(customerServiceBean);
//                customerServiceAppMessageBean.setStaffImg(
//                        staffViewBean == null || staffViewBean.getData() == null || staffViewBean.getData().getHeadImg() == null
//                                ? "" : PathUtil.getEsPath() + PathUtil.staffImgPath + staffViewBean.getData().getHeadImg());
                return customerServiceAppMessageBean;
            }).collect(Collectors.toList());
            customerServiceAppMessageListBean.setCustomerServiceAppMessageBeanList(customerServiceAppMessageBeanList);
            return ResponseResult.success(viewBean.getCode(), customerServiceAppMessageListBean);
        } else {
            return ResponseResult.success(viewBean.getCode(), null);
        }
    }

    @Override
    public ResponseResult editMessageReaded(long customerId, int sender) {
        ViewBean viewBean = customerServerFeign.editMessageReaded(customerId, sender);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<StaffInstitutionAllInfoListBean> searchCustomerServerList() {
//        ViewBean<StaffInstitutionAllInfoListBean> viewBean = institutionManageFeign.
//                searchStaffInstitutionAllInfoListByCompanyIdAndDepartmentId(0, 0);
//        if (viewBean.getCode() != 10001) {
//            return ResponseResult.success(viewBean.getCode(), viewBean.getData());
//        }
//        List<StaffInstitutionAllInfoBean> staffList = viewBean.getData().getStaffInstitutionAllInfoBeanList();
//        staffList.forEach(staffInstitutionAllInfoBean -> {
//            ViewBean<PermissionViewListBean> permissionViewListBeanViewBean =
//                    permissionFeign.searchPermissionListByTypeAndPositionIdAndProfessionId(1,
//                            staffInstitutionAllInfoBean.getPositionId(), 0);
//            if (permissionViewListBeanViewBean.getCode() == 10001) {
//                staffInstitutionAllInfoBean.setRole(permissionViewListBeanViewBean.getData().getPositionBeanList().get(0).getValue());
//            }
//        });
//        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
        return null;
    }

    @Override
    public ResponseResult<CustomerServiceBean> editCustomerServiceMessage(long manageId, long customerId, int sender, int type, String content) {
        if (type == 2) {
            imageFeign.transferShortTimeImage(content, PathUtil.customerServicePath);
        }
        ViewBean<CustomerServiceBean> viewBean = customerServerFeign.editCustomerServiceMessage(manageId, customerId, sender, type, content);
        if (viewBean.getCode() == ResultStatus.SUCCESS_INSERT.getCode()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("socketType", WebSocketServer.MESSAGE_CUSTOMER_SERVICE);
            jsonObject.put("id", viewBean.getData().getId() + "");
            jsonObject.put("manageId", viewBean.getData().getManageId() + "");
            jsonObject.put("customerId", viewBean.getData().getCustomerId() + "");
            jsonObject.put("sender", viewBean.getData().getSender());
            jsonObject.put("read", viewBean.getData().isReaded());
            jsonObject.put("type", viewBean.getData().getType());
            jsonObject.put("content", viewBean.getData().getContent());
            jsonObject.put("createDate", viewBean.getData().getCreateDate());

            //查询管理员信息
//            ViewBean<StaffBean> staffViewBean = institutionManageFeign.searchStaff(manageId);
//            if (staffViewBean.getCode() == ResultStatus.SUCCESS_SELECT.getCode()) {
//                if (staffViewBean.getData().getHeadImg() == null || staffViewBean.getData().getHeadImg().length() == 0) {
//                    jsonObject.put("staffImg", "");
//                } else {
//                    jsonObject.put("staffImg", PathUtil.getEsPath() + PathUtil.staffImgPath + staffViewBean.getData().getHeadImg());
//                }
//            }

            //保存成功后，将数据发送给客服与用户
            if (viewBean.getData().getManageId() != 0) {
                WebSocketServer.sendMessageToUser(WebSocketServer.TYPE_MANAGER, viewBean.getData().getManageId(), jsonObject.toString());
            } else {
                WebSocketServer.sendMessageToAllManager(jsonObject.toString());
            }
            if (viewBean.getData().getCustomerId() != 0) {
                WebSocketServer.sendMessageToUser(WebSocketServer.TYPE_USER, viewBean.getData().getCustomerId(), jsonObject.toString());
            }
        }
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }
}
