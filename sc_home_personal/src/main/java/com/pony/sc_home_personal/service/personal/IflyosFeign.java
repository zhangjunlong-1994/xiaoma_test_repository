package com.pony.sc_home_personal.service.personal;

import com.pony.sc_home_personal.bean.base.IflyosBean;
import com.pony.sc_home_personal.bean.response.IflyosInitBean;
import com.pony.sc_home_personal.bean.response.IflyosPageBean;
import com.pony.sc_home_personal.common.ViewBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chujialin
 * @date 2020/5/9 15:40
 **/
@FeignClient(name = "sp-home-personal")
@RequestMapping("/Iflyos")
public interface IflyosFeign {

    /**
     * @author liguotao
     * @date 2020/9/1 9:12
     **/
    @PostMapping(value = "/searchById.do")
    ViewBean<IflyosBean> searchById(@RequestParam("id") String id);

    /**
     * @author liguotao
     * @date 2020/9/1 9:12
     **/
    @PostMapping("/SelectIflyosByPage.do")
    ViewBean<IflyosPageBean> selectIflyosByPage(@RequestParam("currentPage") int currentPage,
                                                @RequestParam("everyPage") int everyPage);

    /**
     * @author liguotao
     * @date 2020/9/1 9:12
     **/
    @PostMapping("/DeleteIflyosById.do")
    ViewBean deleteIflyosById(@RequestParam("id") String id);

    /**
     * @author liguotao
     * @date 2020/9/1 9:13
     **/
    @PostMapping("/EditIflyosInit.do")
    ViewBean<IflyosInitBean> editIflyosInit(@RequestParam("id") String id);

    /**
     * @author liguotao
     * @date 2020/9/1 9:13
     **/
    @PostMapping("/SaveIflyos.do")
    ViewBean saveIflyos(@RequestParam("id") String id,
                        @RequestParam("centralId") long centralId,
                        @RequestParam("sNNumber") String sNNumber);

    /**
     * @author liguotao
     * @date 2020/9/1 9:13
     **/
    @PostMapping("/SaveIflyosMac.do")
    ViewBean saveIflyosMac(@RequestParam("sNNumber") String sNNumber);

}
