package com.pony.sc_home_personal.service.personal;

import com.pony.sc_home_personal.bean.base.CentralBean;
import com.pony.sc_home_personal.bean.response.CentralInitBean;
import com.pony.sc_home_personal.bean.response.CentralListBean;
import com.pony.sc_home_personal.bean.response.CentralPageBean;
import com.pony.sc_home_personal.common.ViewBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author suntai
 * @date 2019/11/26 14:49
 */
@FeignClient(name = "sp-home-personal")
@RequestMapping("/Central")
public interface CentralManageFeign {

    /**
     * @author suntai
     * @date 2019/11/26 15:01
     **/
    @PostMapping("/SearchCentralPage.do")
    ViewBean<CentralPageBean> searchCentralPage(@RequestParam("province") String province,
                                                @RequestParam("city") String city,
                                                @RequestParam("region") String region,
                                                @RequestParam("communityName") String communityName,
                                                @RequestParam("customerId") long customerId,
                                                @RequestParam("currentPage") int currentPage,
                                                @RequestParam("everyPage") int everyPage);

    /**
     * @author chujialin
     * @date 2020/10/9 10:34
     **/
    @PostMapping("/SearchCentralListByCustomerId.do")
    ViewBean<CentralListBean> searchCentralListByCustomerId(@RequestParam("customerId") long customerId);

    /**
     * @author haozhongyu
     * @date 2020/1/14 15:48
     **/
    @PostMapping("/SearchCentralByHouseId.do")
    ViewBean<CentralBean> searchCentralByHouseId(@RequestParam("id") long id);

    /**
     * @author chujialin
     * @date 2020/4/2 11:30
     **/
    @PostMapping("/SearchCentralByMac.do")
    ViewBean<CentralBean> searchCentralByMac(@RequestParam("mac") String mac);

    /**
     * @author suntai
     * @date 2019/11/26 14:57
     **/
    @PostMapping("/EditCentralInit.do")
    ViewBean<CentralInitBean> editCentralInit(@RequestParam("id") long id);

    /**
     * @author suntai
     * @date 2019/11/26 14:56
     **/
    @PostMapping("/EditCentral.do")
    ViewBean editCentral(@RequestParam("id") long id,
                         @RequestParam("mac") String mac,
                         @RequestParam("state") int state,
                         @RequestParam("editionId") long editionId);

    /**
     * @author suntai
     * @date 2019/11/26 14:58
     **/
    @PostMapping("/DeleteCentral.do")
    ViewBean<CentralBean> deleteCentral(@RequestParam("id") long id);
}
