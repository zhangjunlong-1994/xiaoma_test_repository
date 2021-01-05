package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.response.*;
import com.pony.sc_home_personal.common.ResponseResult;

import java.util.List;

/**
 * @author suntai
 * @date 2019/11/25 11:47
 */
public interface HouseCustomerFacade {

    /**
     * @author suntai
     * @date 2019/12/16 10:19
     **/
    ResponseResult<HousePageBean> searchHouseCustomerPage(String province, String city, String region, String communityName,
                                                          long customerId, int currentPage, int everyPage);

    /**
     * @author suntai
     * @date 2019/12/16 11:37
     **/
    ResponseResult<HouseCustomerListBean> searchHouseListByCustomerId(long customerId);

    /**
     * @author suntai
     * @date 2019/11/25 11:41
     **/
    ResponseResult<HouseInitBean> editHouseInit(long houseId);

    /**
     * @author suntai
     * @date 2019/11/25 11:42
     **/
    ResponseResult editHouse(long houseId, String province, String city, String region, String communityName, String building,
                             String unit, String floor, String num, String apartment, Double area, List<Long> customerIdList);

    /**
     * @author suntai
     * @date 2019/11/25 11:43
     **/
    ResponseResult deleteHouse(long houseId);

    /**
     * @author suntai
     * @date 2019/11/25 11:45
     **/
    ResponseResult<RoomInitBean> searchRoomPageInit(long houseId, int currentPage, int everyPage);

    /**
     * @author suntai
     * @date 2019/11/25 11:44
     **/
    ResponseResult<RoomPageBean> searchRoomPageByHouseId(long houseId, int currentPage, int everyPage);

    /**
     * @author suntai
     * @date 2019/11/25 11:44
     **/
    ResponseResult<RoomListBean> searchRoomListByHouseId(long houseId);

    /**
     * @author suntai
     * @date 2019/11/25 11:46
     **/
    ResponseResult editRoom(long houseId, long roomId, String name, long typeId, double area);

    /**
     * @author liuwenbo
     * @date 2020/8/3 11:25
     **/
    ResponseResult<RoomListBean> addRoomList(RoomListBean roomListBean);

    /**
     * @author suntai
     * @date 2019/11/25 11:46
     **/
    ResponseResult deleteRoom(long roomId);

    /**
     * @author wang
     * @date 2020/12/22 16:00
     * @param id 房产id
     * @return 是否设置
     **/
    ResponseResult independentPasswordIsDetermined(long id);

    /**
     * @author wang
     * @date 2020/12/22 17:20
     * 根设置独立密码
     * @param id 房产id
     * @param oldIdPassword 密码
     * @param newIdPassword 确认密码
     * @return 修改结果
     **/
    ResponseResult independentPassword(long id, String oldIdPassword, String newIdPassword);

    /**
     * @author wang
     * @date 2020/12/22 17:20
     * 根据原独立密码修改独立密码
     * @param id 房产id
     * @param oldIdPassword 原密码
     * @param newIdPassword 新密码
     * @param confirmIdPassword 确认密码
     * @return 修改结果
     */
    ResponseResult modifyPasswordForIdPassword(long id, String oldIdPassword, String newIdPassword,
                                               String confirmIdPassword);

    /**
     * @author wang
     * @date 2020/12/22 17:20
     * 房主重置独立密码
     * @param customerId 用户id
     * @param houseId 房产id
     * @return 用户是否为房主
     **/
    ResponseResult userHomeownerOrNot(long customerId, long houseId);

    /**
     * @author wang
     * @date 2020/12/22 17:20
     * 根据房主密码重置独立密码
     * @param id 房主id
     * @param houseId 房产id
     * @param password 房主密码
     * @param newIdPassword 新密码
     * @param confirmIdPassword 确认密码
     * @return 修改结果
     */
    ResponseResult homeownerResetPassword(long id, long houseId, String password, String newIdPassword,
                                          String confirmIdPassword);

}
