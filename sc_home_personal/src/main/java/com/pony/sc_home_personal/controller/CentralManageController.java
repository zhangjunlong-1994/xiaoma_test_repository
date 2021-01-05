package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.bean.base.CentralBean;
import com.pony.sc_home_personal.bean.response.CentralInitBean;
import com.pony.sc_home_personal.bean.response.CentralListBean;
import com.pony.sc_home_personal.bean.response.CentralPageBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.config.CheckToken;
import com.pony.sc_home_personal.facade.CentralManageFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 网关
 *
 * @author suntai
 * @date 2019/11/26 15:06
 **/
@RestController
@RequestMapping("/ScCentral")
public class CentralManageController {

    private final CentralManageFacade centralManageFacade;

    @Autowired
    public CentralManageController(CentralManageFacade centralManageFacade) {
        this.centralManageFacade = centralManageFacade;
    }

    /**
     * 获取网关分页列表
     *
     * @param province      省份
     * @param city          市
     * @param region        区县
     * @param communityName 小区（模糊查询）
     * @param customerId    用户Id（所有用户时为0）
     * @param currentPage   当前页数（从0开始）
     * @param everyPage     每页条数
     * @author suntai
     * @date 2019/11/26 15:24
     **/
    @CheckToken
    @PostMapping("/SearchPage.do")
    public ResponseResult<CentralPageBean> searchPage(@RequestParam String province,
                                                      @RequestParam String city,
                                                      @RequestParam String region,
                                                      @RequestParam String communityName,
                                                      @RequestParam long customerId,
                                                      @RequestParam int currentPage,
                                                      @RequestParam int everyPage) {
        return centralManageFacade.searchPage(province, city, region, communityName, customerId, currentPage, everyPage);
    }

    /**
     * 根据用户Id获取网关列表
     *
     * @param customerId 用户Id
     * @author chujialin
     * @date 2020/10/9 10:31
     **/
    @CheckToken
    @PostMapping("/SearchListByCustomerId.do")
    public ResponseResult<CentralListBean> searchListByCustomerId(@RequestParam long customerId) {
        return centralManageFacade.searchListByCustomerId(customerId);
    }

    /**
     * 根据Id获取网关
     *
     * @param houseId 房产Id
     * @author suntai
     * @date 2019/11/28 13:08
     **/
    @CheckToken
    @PostMapping("/SearchByHouseId.do")
    public ResponseResult<CentralBean> searchByHouseId(@RequestParam long houseId) {
        return centralManageFacade.searchByHouseId(houseId);
    }

    /**
     * 根据mac获取网关
     *
     * @param mac 网关mac
     * @author chujialin
     * @date 2020/4/2 11:32
     **/
    @CheckToken
    @PostMapping("/SearchByMac.do")
    public ResponseResult<CentralBean> searchByMac(@RequestParam String mac) {
        return centralManageFacade.searchByMac(mac);
    }

    /**
     * 网关编辑初始化
     *
     * @param id 网关Id（新增时为0）
     * @author suntai
     * @date 2019/11/26 15:15
     **/
    @CheckToken
    @PostMapping("/EditCentralInit.do")
    public ResponseResult<CentralInitBean> editCentralInit(@RequestParam long id) {
        return centralManageFacade.editCentralInit(id);
    }

    /**
     * 编辑网关
     *
     * @param id        Id
     * @param mac       网关mac
     * @param state     网关状态（对应Constant中设备状态）
     * @param editionId 版本Id
     * @author suntai
     * @date 2019/11/26 15:15
     **/
    @CheckToken
    @PostMapping("/EditCentral.do")
    public ResponseResult editCentral(@RequestParam long id,
                                      @RequestParam String mac,
                                      @RequestParam int state,
                                      @RequestParam long editionId) {
        return centralManageFacade.editCentral(id, mac, state, editionId);
    }

    /**
     * 根据Id删除网关
     *
     * @param id 网关Id
     * @author suntai
     * @date 2019/11/26 15:15
     **/
    @CheckToken
    @PostMapping("/DeleteCentral.do")
    public ResponseResult deleteCentral(@RequestParam long id) {
        return centralManageFacade.deleteCentral(id);
    }
}
