package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.response.*;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ViewBean;
import com.pony.sc_home_personal.service.personal.HouseCustomerFeign;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author suntai
 * @date 2019/11/25 11:47
 */
@Component
public class HouseCustomerFacadeImpl implements HouseCustomerFacade {

    @Resource
    private HouseCustomerFeign houseCustomerFeign;

    @Override
    public ResponseResult<HousePageBean> searchHouseCustomerPage(String province, String city, String region, String communityName,
                                                                 long customerId, int currentPage, int everyPage) {
        ViewBean<HousePageBean> viewBean = houseCustomerFeign.searchHousePage(
                province, city, region, communityName, customerId, currentPage, everyPage);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<HouseCustomerListBean> searchHouseListByCustomerId(long customerId) {
        ViewBean<HouseCustomerListBean> viewBean = houseCustomerFeign.searchHouseListByCustomerId(customerId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<HouseInitBean> editHouseInit(long houseId) {
        ViewBean<HouseInitBean> viewBean = houseCustomerFeign.searchHouse(houseId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult editHouse(long houseId, String province, String city, String region, String communityName, String building,
                                    String unit, String floor, String num, String apartment, Double area, List<Long> customerIdList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < customerIdList.size(); i++) {
            if (i == customerIdList.size() - 1) {
                stringBuilder.append(customerIdList.get(i));
            } else {
                stringBuilder.append(customerIdList.get(i)).append(",");
            }
        }
        ViewBean viewBean = houseCustomerFeign.editHouse(houseId, province, city, region, communityName,
                building, unit, floor, num, apartment, area == null ? 0 : area, stringBuilder.toString());
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult deleteHouse(long houseId) {
        ViewBean viewBean = houseCustomerFeign.deleteHouse(houseId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<RoomInitBean> searchRoomPageInit(long houseId, int currentPage, int everyPage) {
        ViewBean<RoomInitBean> viewBean = houseCustomerFeign.searchRoomPageInit(houseId, currentPage, everyPage);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<RoomPageBean> searchRoomPageByHouseId(long houseId, int currentPage, int everyPage) {
        ViewBean<RoomPageBean> viewBean = houseCustomerFeign.searchRoomPage(houseId, currentPage, everyPage);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<RoomListBean> searchRoomListByHouseId(long houseId) {
        ViewBean<RoomListBean> viewBean = houseCustomerFeign.searchRoomList(houseId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult editRoom(long houseId, long roomId, String name, long typeId, double area) {
        ViewBean viewBean = houseCustomerFeign.editRoom(houseId, roomId, name, typeId, area);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult<RoomListBean> addRoomList(RoomListBean roomListBean) {
        ViewBean<RoomListBean> viewBean = houseCustomerFeign.addRoomList(roomListBean);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    @Override
    public ResponseResult deleteRoom(long roomId) {
        ViewBean viewBean = houseCustomerFeign.deleteRoom(roomId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    /**
     * @author wang
     * @date 2020/12/22 15:21
     * @param id 房产id
     **/
    @Override
    public ResponseResult independentPasswordIsDetermined(long id) {
        ViewBean viewBean = houseCustomerFeign.selectById(id);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    /**
     * @author wang
     * 根设置独立密码
     * @param id 房产id
     * @param oldIdPassword 密码
     * @param newIdPassword 确认密码
     * @return 修改结果
     **/
    @Override
    public ResponseResult independentPassword(long id, String oldIdPassword, String newIdPassword) {
        ViewBean viewBean = houseCustomerFeign.selectByIdPassword(id, oldIdPassword, newIdPassword);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    /**
     * @author wang
     * 根据原密码修改密码
     * @param id 房产id
     * @param oldIdPassword 原密码
     * @param newIdPassword 新密码
     * @param confirmIdPassword 确认密码
     * @return 修改结果
     **/
    @Override
    public ResponseResult modifyPasswordForIdPassword(long id, String oldIdPassword, String newIdPassword,
                                                      String confirmIdPassword) {
        ViewBean viewBean = houseCustomerFeign.selectByModifyPasswordForIdPassword(id, oldIdPassword,
                newIdPassword, confirmIdPassword);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }

    /**
     * @author wang
     * @date 2020/12/22 17:20
     * 房主重置独立密码
     * @param customerId 用户id
     * @param houseId 房产id
     * @return 用户是否为房主
     **/
    @Override
    public ResponseResult userHomeownerOrNot(long customerId, long houseId) {
        ViewBean viewBean = houseCustomerFeign.selectByUserHomeownerOrNot(customerId, houseId);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }
    /**
     * @author wang
     * 根据房主密码重置独立密码
     * @param id 房主id
     * @param houseId 房产id
     * @param password 房主密码
     * @param newIdPassword 新密码
     * @param confirmIdPassword 确认密码
     * @return 修改结果
     */
    @Override
    public ResponseResult homeownerResetPassword(long id, long houseId, String password, String newIdPassword,
                                                 String confirmIdPassword) {
        ViewBean viewBean = houseCustomerFeign.selectByHomeownerResetPassword(id, houseId, password,
                newIdPassword, confirmIdPassword);
        return ResponseResult.success(viewBean.getCode(), viewBean.getData());
    }
}
