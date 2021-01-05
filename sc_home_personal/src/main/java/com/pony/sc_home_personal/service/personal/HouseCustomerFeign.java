package com.pony.sc_home_personal.service.personal;

import com.pony.sc_home_personal.bean.response.*;
import com.pony.sc_home_personal.common.ViewBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author suntai
 * @date 2019/11/25 11:22
 */
@FeignClient(name = "sp-home-personal")
@RequestMapping("/HouseCustomer")
public interface HouseCustomerFeign {

    /**
     * @author suntai
     * @date 2019/12/16 10:19
     **/
    @PostMapping(value = "/SearchHousePage.do")
    ViewBean<HousePageBean> searchHousePage(@RequestParam("province") String province,
                                            @RequestParam("city") String city,
                                            @RequestParam("region") String region,
                                            @RequestParam("communityName") String communityName,
                                            @RequestParam("customerId") long customerId,
                                            @RequestParam("currentPage") int currentPage,
                                            @RequestParam("everyPage") int everyPage);

    /**
     * @author suntai
     * @date 2019/12/16 11:37
     **/
    @PostMapping(value = "/SearchHouseListByCustomerId.do")
    ViewBean<HouseCustomerListBean> searchHouseListByCustomerId(@RequestParam("customerId") long customerId);

    /**
     * @author suntai
     * @date 2019/12/16 11:37
     **/
    @PostMapping(value = "/SearchHouseListByHouseId.do")
    ViewBean<HouseCustomerListBean> searchHouseListByHouseId(@RequestParam("houseId") long houseId);

    /**
     * @author suntai
     * @date 2019/11/25 11:41
     **/
    @PostMapping(value = "/EditHouseInit.do")
    ViewBean<HouseInitBean> searchHouse(@RequestParam("houseId") long houseId);

    /**
     * @author suntai
     * @date 2019/11/25 11:42
     **/
    @PostMapping(value = "/EditHouse.do")
    ViewBean editHouse(@RequestParam("houseId") long houseId,
                       @RequestParam("province") String province,
                       @RequestParam("city") String city,
                       @RequestParam("region") String region,
                       @RequestParam("communityName") String communityName,
                       @RequestParam("building") String building,
                       @RequestParam("unit") String unit,
                       @RequestParam("floor") String floor,
                       @RequestParam("num") String num,
                       @RequestParam("apartment") String apartment,
                       @RequestParam("area") double area,
                       @RequestParam("customerIdList") String customerIdList);

    @PostMapping(value = "/EditHouseDefault.do")
    ViewBean editHouseDefault(@RequestParam("customerId") long customerId,
                              @RequestParam("houseId") long houseId);

    /**
     * @author suntai
     * @date 2019/11/25 11:43
     **/
    @PostMapping(value = "/DeleteHouse.do")
    ViewBean deleteHouse(@RequestParam("houseId") long houseId);

    /**
     * @author suntai
     * @date 2019/11/25 11:44
     **/
    @PostMapping(value = "/SearchRoomPageInit.do")
    ViewBean<RoomInitBean> searchRoomPageInit(@RequestParam("houseId") long houseId,
                                              @RequestParam("currentPage") int currentPage,
                                              @RequestParam("everyPage") int everyPage);

    /**
     * @author suntai
     * @date 2019/11/25 11:44
     **/
    @PostMapping(value = "/SearchRoomPage.do")
    ViewBean<RoomPageBean> searchRoomPage(@RequestParam("houseId") long houseId,
                                          @RequestParam("currentPage") int currentPage,
                                          @RequestParam("everyPage") int everyPage);

    /**
     * @author suntai
     * @date 2019/11/25 11:44
     **/
    @PostMapping(value = "/SearchRoomList.do")
    ViewBean<RoomListBean> searchRoomList(@RequestParam("houseId") long houseId);

    /**
     * @author suntai
     * @date 2019/11/25 11:46
     **/
    @PostMapping(value = "/EditRoom.do")
    ViewBean editRoom(@RequestParam("houseId") long houseId,
                      @RequestParam("roomId") long roomId,
                      @RequestParam("name") String name,
                      @RequestParam("typeId") long typeId,
                      @RequestParam("area") Double area);

    /**
     * @author liuwenbo
     * @date 2020/8/3 11:18
     **/
    @PostMapping(value = "/AddRoomList.do")
    ViewBean<RoomListBean> addRoomList(@RequestBody RoomListBean roomListBean);

    /**
     * @author suntai
     * @date 2019/11/25 11:46
     **/
    @PostMapping(value = "/DeleteRoom.do")
    ViewBean deleteRoom(@RequestParam("roomId") long roomId);

    /**
     * @author wang
     * @date 2020/12/23 11:40
     **/
    @PostMapping(value = "/SelectById.do")
    ViewBean selectById(@RequestParam("id") long id);

    /**
     * @author wang
     * @date 2020/12/23 11:40
     **/
    @PostMapping(value = "/SelectByIdPassword.do")
    ViewBean selectByIdPassword(@RequestParam("id") long id,
                                @RequestParam("oldIdPassword") String oldIdPassword,
                                @RequestParam("newIdPassword") String newIdPassword);

    /**
     * @author wang
     * @date 2020/12/23 11:40
     **/
    @PostMapping(value = "/SelectByModifyPasswordForIdPassword.do")
    ViewBean selectByModifyPasswordForIdPassword(@RequestParam("id") long id,
                                                 @RequestParam("oldIdPassword") String oldIdPassword,
                                                 @RequestParam("newIdPassword") String newIdPassword,
                                                 @RequestParam("confirmIdPassword") String confirmIdPassword);

    /**
     * @author wang
     * @date 2020/12/23 11:40
     **/
    @PostMapping(value = "/SelectByUserHomeownerOrNot.do")
    ViewBean selectByUserHomeownerOrNot(@RequestParam("customerId") long customerId,
                                        @RequestParam("houseId") long houseId);

    /**
     * @author wang
     * @date 2020/12/23 11:40
     **/
    @PostMapping(value = "/SelectByHomeownerResetPassword.do")
    ViewBean selectByHomeownerResetPassword(@RequestParam("id") long id,
                                            @RequestParam("houseId") long houseId,
                                            @RequestParam("password") String password,
                                            @RequestParam("newIdPassword") String newIdPassword,
                                            @RequestParam("confirmIdPassword") String confirmIdPassword);
}
