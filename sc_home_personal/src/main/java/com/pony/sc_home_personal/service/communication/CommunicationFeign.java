package com.pony.sc_home_personal.service.communication;

import com.pony.sc_home_personal.bean.util.MessageBean;
import com.pony.sc_home_personal.common.ViewBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wenxufeng
 * @date 2019/12/6 14:31
 **/
@FeignClient(name = "sp-communication-gateway")
@RequestMapping("/Device")
public interface CommunicationFeign {

    /**
     * @author wenxufeng
     * @date 2020/1/10 10:25
     **/
    @PostMapping("/SaveDevice.do")
    void saveDevice(@RequestParam("mac") String mac);

    /**
     * @author wenxufeng
     * @date 2020/1/15 9:59
     **/
    @PostMapping("/DeleteByMac.do")
    void deleteByMac(@RequestParam("mac") String mac);

    /**
     * @author wenxufeng
     * @date 2020/1/15 9:59
     **/
    @PostMapping("/SearchStateByMac.do")
    ViewBean<Integer> searchStateByMac(@RequestParam("mac") String mac);

    /**
     * @author wenxufeng
     * @date 2019/12/6 14:34
     **/
    @PostMapping("/SendMessage.do")
    void sendMessage(@RequestBody MessageBean messageBean);
}
