package com.pony.sc_home_personal.service.personal;

import com.pony.sc_home_personal.bean.base.EditionBean;
import com.pony.sc_home_personal.bean.response.EditionInitBean;
import com.pony.sc_home_personal.bean.response.EditionListBean;
import com.pony.sc_home_personal.bean.response.EditionPageBean;
import com.pony.sc_home_personal.common.ViewBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liguotao
 * @date 2020/8/28 14:51
 */
@FeignClient(name = "sp-home-personal")
@RequestMapping("/Edition")
public interface EditionFeign {

    /**
     * @author liguotao
     * @date 2020/8/28 15:01
     **/
    @PostMapping(value = "/SearchEditionPageByTypeAndName.do")
    ViewBean<EditionPageBean> searchEditionPageByTypeAndName(@RequestParam("type") int type,
                                                             @RequestParam("hardwareType") int hardwareType,
                                                             @RequestParam("name") String name,
                                                             @RequestParam("currentPage") int currentPage,
                                                             @RequestParam("everyPage") int everyPage);

    /**
     * @author chujialin
     * @date 2020/9/25 16:42
     **/
    @PostMapping(value = "/SearchEditionList.do")
    ViewBean<EditionListBean> searchEditionList(@RequestParam("type") int type,
                                                @RequestParam("hardwareType") int hardwareType);

    /**
     * @author chujialin
     * @date 2020/11/17 15:15
     **/
    @PostMapping(value = "/SearchEdition.do")
    ViewBean<EditionBean> searchEdition(@RequestParam("id") long id);

    /**
     * @author liguotao
     * @date 2020/8/28 15:01
     **/
    @PostMapping(value = "/DeleteEdition.do")
    ViewBean<EditionBean> deleteEdition(@RequestParam("id") long id);

    /**
     * @author liguotao
     * @date 2020/8/28 15:01
     **/
    @PostMapping(value = "/EditEditionInit.do")
    ViewBean<EditionInitBean> editEditionInit(@RequestParam("id") long id);

    /**
     * @author liguotao
     * @date 2020/8/28 15:01
     **/
    @PostMapping(value = "/SearchEditionNameExist.do")
    ViewBean searchEditionNameExist(@RequestParam("name") String name,
                                    @RequestParam("equipmentType") int equipmentType,
                                    @RequestParam("hardwareType") int hardwareType);

    /**
     * @author liguotao
     * @date 2020/8/28 15:02
     **/
    @PostMapping(value = "/SearchNewEdition.do")
    ViewBean<String> searchNewEdition(@RequestParam("equipmentType") int equipmentType,
                                      @RequestParam("hardwareType") int hardwareType);

    /**
     * @author liguotao
     * @date 2020/8/28 15:00
     **/
    @PostMapping(value = "/EditEdition.do")
    ViewBean editEdition(
            @RequestParam("id") long id,
            @RequestParam("name") String name,
            @RequestParam("hardwareType") int hardwareType,
            @RequestParam("equipmentType") int equipmentType,
            @RequestParam("fileName") String fileName,
            @RequestParam("explain") String explain);
}
