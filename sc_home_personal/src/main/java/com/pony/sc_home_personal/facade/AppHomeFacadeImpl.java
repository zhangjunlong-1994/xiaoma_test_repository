package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.base.*;
import com.pony.sc_home_personal.bean.response.*;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ResultStatus;
import com.pony.sc_home_personal.common.ViewBean;
import com.pony.sc_home_personal.service.personal.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author haozhongyu
 * @date 2020/1/2 11:43
 **/
@Component
public class AppHomeFacadeImpl implements AppHomeFacade {

    @Resource
    private HouseCustomerFeign houseCustomerFeign;
    @Resource
    private DeviceManageFeign deviceManageFeign;
    @Resource
    private ScenarioFeign scenarioFeign;
    @Resource
    private CustomerServerFeign customerServerFeign;
    @Resource
    private CentralManageFeign centralManageFeign;

    @Override
    public ResponseResult<AppHomeInitData> searchHomeInitData(long customerId, long houseId) {
        //将房产设为默认房产
        ViewBean viewBean = houseCustomerFeign.editHouseDefault(customerId, houseId);
        if (viewBean.getCode() == ResultStatus.SUCCESS_SETTING.getCode()) {
            //查询数据
            AppHomeInitData appHomeInitData = new AppHomeInitData();
            List<HouseCustomerBean> houseCustomerBeanList = new ArrayList<>();
            List<RoomWithDeviceBean> roomWithDeviceBeanList = new ArrayList<>();
            List<ScenarioBean> scenarioBeanList = new ArrayList<>();
            int unReadNum = 0;

            //房产-主机信息
            ViewBean<CentralBean> centralViewBean = centralManageFeign.searchCentralByHouseId(houseId);
            if (centralViewBean.getCode() == ResultStatus.SUCCESS_SELECT.getCode()) {
                appHomeInitData.setCentralBean(centralViewBean.getData());
            } else {
                appHomeInitData.setCentralBean(new CentralBean());
            }

            //房产-成员列表
            ViewBean<HouseCustomerListBean> houseCustomerListViewBean = houseCustomerFeign.searchHouseListByHouseId(houseId);
            if (houseCustomerListViewBean.getCode() == ResultStatus.SUCCESS_SELECT.getCode()) {
                houseCustomerBeanList = houseCustomerListViewBean.getData().getHouseCustomerListBean();
            }
            //房间-设备列表
            ViewBean<RoomListBean> roomListViewBean = houseCustomerFeign.searchRoomList(houseId);
            if (roomListViewBean.getCode() == ResultStatus.SUCCESS_SELECT.getCode()) {
                roomListViewBean.getData().getRoomBeanList().forEach(roomBean -> {
                    RoomWithDeviceBean roomWithDeviceBean = new RoomWithDeviceBean();
                    roomWithDeviceBean.setRoomBean(roomBean);

                    List<DeviceBean> deviceBeanList = new ArrayList<>();
                    ViewBean<DeviceListBean> deviceListViewBean =
                            deviceManageFeign.searchDeviceListByHouseIdAndRoomId(roomBean.getHouseId(), roomBean.getId());
                    if (deviceListViewBean.getCode() == ResultStatus.SUCCESS_SELECT.getCode()) {
                        deviceBeanList = deviceListViewBean.getData().getDeviceBeanList();
                    }
                    roomWithDeviceBean.setDeviceBeanList(deviceBeanList);
                    roomWithDeviceBeanList.add(roomWithDeviceBean);
                });
            }
            //情景模式列表
            ViewBean<ScenarioListBean> scenarioModeListViewBean = scenarioFeign.searchListByHouseId(houseId);
            if (scenarioModeListViewBean.getCode() == ResultStatus.SUCCESS_SELECT.getCode()) {
                scenarioBeanList = scenarioModeListViewBean.getData().getScenarioBeanList();
            }
            //未读客服消息数量
            ViewBean<CustomerServiceMessageBean> customerServerMessageViewBean = customerServerFeign.searchCustomerMessageByCustomerId(customerId,0,10);
            if (customerServerMessageViewBean.getCode() == ResultStatus.SUCCESS_SELECT.getCode()) {
                List<CustomerServiceBean> customerServiceBeanList = customerServerMessageViewBean.getData().getPageNavigator().getContent();
                for (CustomerServiceBean customerServiceBean : customerServiceBeanList) {
                    if (customerServiceBean.getSender() == 1 && !customerServiceBean.isReaded()) {
                        unReadNum ++;
                    }
                }
            }

            appHomeInitData.setHouseCustomerBeanList(houseCustomerBeanList);
            appHomeInitData.setRoomWithDeviceBeanList(roomWithDeviceBeanList);
            appHomeInitData.setScenarioBeanList(scenarioBeanList);
            appHomeInitData.setUnReadMessage(unReadNum);
            return ResponseResult.success(ResultStatus.SUCCESS_SELECT.getCode(), appHomeInitData);
        } else {
            return ResponseResult.success(viewBean.getCode(), null);
        }
    }
}
