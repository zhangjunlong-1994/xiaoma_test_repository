package com.pony.sc_home_personal.service.personal;

import com.pony.sc_home_personal.bean.base.CustomerServiceBean;
import com.pony.sc_home_personal.bean.response.CustomerServiceMessageBean;
import com.pony.sc_home_personal.bean.response.CustomerServiceMessageListBean;
import com.pony.sc_home_personal.common.ViewBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author suntai
 * @date 2019/12/2 10:46
 */
@FeignClient(name = "sp-home-personal")
@RequestMapping("/CustomerServer")
public interface CustomerServerFeign {

    /**
     * @author suntai
     * @date 2019/12/2 11:02
     **/
    @PostMapping(value = "/SearchCustomerMessageInit.do")
    ViewBean<CustomerServiceMessageListBean> searchCustomerMessageInit(@RequestParam("nameOrMobile") String nameOrMobile);

    /**
     * @author suntai
     * @date 2019/12/2 13:39
     **/
    @PostMapping(value = "/SearchCustomerMessageByCustomerId.do")
    ViewBean<CustomerServiceMessageBean> searchCustomerMessageByCustomerId(@RequestParam("customerId") long customerId,
                                                                           @RequestParam("currentPage") long currentPage,
                                                                           @RequestParam("everyPage") long everyPage);

    /**
     * @author suntai
     * @date 2019/12/2 17:31
     **/
    @PostMapping(value = "/EditCustomerServiceMessage.do")
    ViewBean<CustomerServiceBean> editCustomerServiceMessage(@RequestParam("manageId") long manageId,
                                                             @RequestParam("customerId") long customerId,
                                                             @RequestParam("sender") int sender,
                                                             @RequestParam("type") int type,
                                                             @RequestParam("content") String content);

    /**
     * @author chujialin
     * @date 2020/4/29 11:29
     **/
    @PostMapping("/EditMessageReaded.do")
    ViewBean editMessageReaded(@RequestParam("customerId") long customerId,
                               @RequestParam("sender") int sender);
}
