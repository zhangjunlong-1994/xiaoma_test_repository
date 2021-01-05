package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.bean.base.RoomBean;
import com.pony.sc_home_personal.bean.response.*;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.common.ResultStatus;
import com.pony.sc_home_personal.config.CheckToken;
import com.pony.sc_home_personal.facade.HouseCustomerFacade;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 房产
 *
 * @author suntai
 * @date 2019/11/25 11:56
 */
@RestController
@RequestMapping("/ScHouseCustomer")
public class HouseCustomerController {

    private final HouseCustomerFacade houseCustomerFacade;

    @Autowired
    public HouseCustomerController(HouseCustomerFacade houseCustomerFacade) {
        this.houseCustomerFacade = houseCustomerFacade;
    }

    /**
     * 获取房产分页列表
     *
     * @param province      省份
     * @param city          市
     * @param region        区县
     * @param communityName 小区
     * @param customerId    用户Id
     * @param currentPage   当前页数（从0开始）
     * @param everyPage     每页条数
     * @author suntai
     * @date 2019/12/16 10:19
     **/
    @CheckToken
    @PostMapping("/SearchHousePage.do")
    public ResponseResult<HousePageBean> searchHouseCustomerPage(@RequestParam String province,
                                                                 @RequestParam String city,
                                                                 @RequestParam String region,
                                                                 @RequestParam String communityName,
                                                                 @RequestParam long customerId,
                                                                 @RequestParam int currentPage,
                                                                 @RequestParam int everyPage) {
        return houseCustomerFacade.searchHouseCustomerPage(province, city, region, communityName, customerId, currentPage, everyPage);
    }

    /**
     * 获取房产列表
     *
     * @param customerId 用户Id
     * @author haozhongyu
     * @date 2019/12/28 10:13
     **/
    @CheckToken
    @PostMapping("/SearchHouseListByCustomerId.do")
    public ResponseResult<HouseCustomerListBean> searchHouseListByCustomerId(@RequestParam long customerId) {
        return houseCustomerFacade.searchHouseListByCustomerId(customerId);
    }

    /**
     * APP获取房产列表
     *
     * @author liuwenbo
     * @date 2020/7/13 13:33
     **/
    @CheckToken
    @PostMapping("/SearchAppHouseListByCustomerId.do")
    public ResponseResult<HouseCustomerListBean> searchAppHouseListByCustomerId(HttpServletRequest request) {
        long userId = Long.parseLong(String.valueOf(request.getAttribute("userId")));
        return houseCustomerFacade.searchHouseListByCustomerId(userId);
    }

    /**
     * 编辑房产初始化
     *
     * @param houseId 房产Id
     * @author suntai
     * @date 2019/11/25 12:01
     **/
    @CheckToken
    @PostMapping("/EditHouseInit.do")
    public ResponseResult<HouseInitBean> editHouseInit(@RequestParam long houseId) {
        return houseCustomerFacade.editHouseInit(houseId);
    }

    /**
     * 编辑房产
     *
     * @param houseId        房产Id
     * @param province       省份
     * @param city           市
     * @param region         区县
     * @param communityName  小区
     * @param building       楼号
     * @param unit           单元号
     * @param floor          楼层
     * @param num            门牌号
     * @param apartment      户型
     * @param area           面积
     * @param customerIdList 成员列表
     * @author suntai
     * @date 2019/11/26 9:21
     **/
    @CheckToken
    @PostMapping("/EditHouse.do")
    public ResponseResult editHouse(@RequestParam long houseId,
                                    @RequestParam String province,
                                    @RequestParam String city,
                                    @RequestParam String region,
                                    @RequestParam String communityName,
                                    @RequestParam String building,
                                    @RequestParam String unit,
                                    @RequestParam String floor,
                                    @RequestParam String num,
                                    @RequestParam String apartment,
                                    @RequestParam Double area,
                                    @RequestParam List<Long> customerIdList) {
        return houseCustomerFacade.editHouse(houseId, province, city, region, communityName, building, unit, floor, num, apartment, area, customerIdList);
    }

    /**
     * 删除房产
     *
     * @param houseId 房产Id
     * @author suntai
     * @date 2019/11/26 9:24
     **/
    @CheckToken
    @PostMapping("/DeleteHouse.do")
    public ResponseResult deleteHouse(@RequestParam long houseId) {
        return houseCustomerFacade.deleteHouse(houseId);
    }

    /**
     * 获取房间分页列表初始化
     *
     * @param houseId     房产Id
     * @param currentPage 当前页数（从0开始）
     * @param everyPage   每页条数
     * @author suntai
     * @date 2019/11/26 10:45
     **/
    @CheckToken
    @PostMapping("/SearchRoomPageInit.do")
    public ResponseResult<RoomInitBean> searchRoomPageInit(@RequestParam long houseId,
                                                           @RequestParam int currentPage,
                                                           @RequestParam int everyPage) {
        return houseCustomerFacade.searchRoomPageInit(houseId, currentPage, everyPage);
    }

    /**
     * 获取房间分页列表
     *
     * @param houseId     房产Id
     * @param currentPage 当前页数（从0开始）
     * @param everyPage   每页条数
     * @author suntai
     * @date 2019/11/26 9:43
     **/
    @CheckToken
    @PostMapping("/SearchRoomPage.do")
    public ResponseResult<RoomPageBean> searchRoomPage(@RequestParam long houseId,
                                                       @RequestParam int currentPage,
                                                       @RequestParam int everyPage) {
        return houseCustomerFacade.searchRoomPageByHouseId(houseId, currentPage, everyPage);
    }


    /**
     * 获取房间列表
     *
     * @param houseId 房产Id
     * @author suntai
     * @date 2019/11/26 10:41
     **/
    @CheckToken
    @PostMapping("/SearchRoomList.do")
    public ResponseResult<RoomListBean> searchRoomList(@RequestParam long houseId) {
        return houseCustomerFacade.searchRoomListByHouseId(houseId);
    }

    /**
     * 编辑房间
     *
     * @param houseId 房产Id
     * @param roomId  房间Id
     * @param name    房间名
     * @param typeId  房间类型
     * @param area    房间面积
     * @author suntai
     * @date 2019/11/26 10:46
     **/
    @CheckToken
    @PostMapping("/EditRoom.do")
    public ResponseResult editRoom(@RequestParam long houseId,
                                   @RequestParam long roomId,
                                   @RequestParam String name,
                                   @RequestParam long typeId,
                                   @RequestParam double area) {
        return houseCustomerFacade.editRoom(houseId, roomId, name, typeId, area);
    }

    /**
     * 批量添加房间
     *
     * @param roomArrayStr 房间列表json数据
     * @author liuwenbo
     * @date 2020/8/3 11:28
     **/
    @CheckToken
    @PostMapping("/AddRoomList.do")
    public ResponseResult<RoomListBean> addRoomList(@RequestParam String roomArrayStr) {
        List<RoomBean> roomBeanList = new ArrayList<>();
        try {
            JSONArray jsonArray = JSONArray.fromObject(roomArrayStr);
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                RoomBean roomBean = new RoomBean();
                roomBean.setHouseId(jsonObject.getLong("houseId"));
                roomBean.setName(jsonObject.getString("name"));
                roomBean.setTypeId(jsonObject.getLong("type"));
                roomBean.setArea(jsonObject.getDouble("area"));
                roomBeanList.add(roomBean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (roomBeanList.isEmpty()) {
            return ResponseResult.success(ResultStatus.EXISTENT_FAILED_JSON.getCode(), null);
        } else {
            RoomListBean roomListBean = new RoomListBean();
            roomListBean.setRoomBeanList(roomBeanList);
            return houseCustomerFacade.addRoomList(roomListBean);
        }
    }

    /**
     * 删除房间
     *
     * @param roomId 房间Id
     * @author suntai
     * @date 2019/11/26 10:51
     **/
    @CheckToken
    @PostMapping("/DeleteRoom.do")
    public ResponseResult deleteRoom(@RequestParam long roomId) {
        return houseCustomerFacade.deleteRoom(roomId);
    }

    /**
     * @param id 房产id
     * @author wang
     * 是否设置过独立密码接口
     * @date 2020/12/22 17:22
     */
    @CheckToken
    @PostMapping("/IndependentPasswordIsDetermined.do")
    public ResponseResult IndependentPasswordIsDetermined(@RequestParam long id) {
        return houseCustomerFacade.independentPasswordIsDetermined(id);
    }

    /**
     * @param id                房产id
     * @param newIdPassword     新独立密码
     * @param confirmIdPassword 确认独立密码
     * @return 设置结果
     * @author wang
     * 设置独立密码接口
     */
    @CheckToken
    @PostMapping("/IndependentPassword.do")
    public ResponseResult independentPassword(@RequestParam long id,
                                              @RequestParam String newIdPassword,
                                              @RequestParam String confirmIdPassword) {
        return houseCustomerFacade.independentPassword(id, newIdPassword, confirmIdPassword);
    }

    /**
     * @param id                房产id
     * @param oldIdPassword     原独立密码
     * @param newIdPassword     新独立密码
     * @param confirmIdPassword 确认独立密码
     * @return 修改结果
     * @author wang
     * 根据原密码修改密码
     */
    @CheckToken
    @PostMapping("/ModifyIdPasswordForIdPassword.do")
    public ResponseResult modifyPasswordForIdPassword(@RequestParam long id,
                                                      @RequestParam String oldIdPassword,
                                                      @RequestParam String newIdPassword,
                                                      @RequestParam String confirmIdPassword) {
        return houseCustomerFacade.modifyPasswordForIdPassword(id, oldIdPassword, newIdPassword, confirmIdPassword);
    }

    /**
     * @param customerId 用户id
     * @param houseId    房产id
     * @author wang
     * 验证用户是否为房主
     * @date 2020/12/22 17:22
     **/
    @CheckToken
    @PostMapping("/UserHomeownerOrNot.do")
    public ResponseResult userHomeownerOrNot(@RequestParam long customerId,
                                             @RequestParam long houseId) {
        return houseCustomerFacade.userHomeownerOrNot(customerId, houseId);
    }

    /**
     * @param id                房产id
     * @param houseId           房产id
     * @param password          房主密码
     * @param newIdPassword     新独立密码
     * @param confirmIdPassword 确认独立密码
     * @return 修改结果
     * @author wang
     * 根据房主密码重置独立密码
     */
    @CheckToken
    @PostMapping("/HomeownerResetPassword.do")
    public ResponseResult homeownerResetPassword(@RequestParam long id,
                                                 @RequestParam long houseId,
                                                 @RequestParam String password,
                                                 @RequestParam String newIdPassword,
                                                 @RequestParam String confirmIdPassword) {
        return houseCustomerFacade.homeownerResetPassword(id, houseId, password, newIdPassword, confirmIdPassword);
    }
}
