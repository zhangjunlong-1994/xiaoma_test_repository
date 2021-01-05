package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.config.CheckToken;
import com.pony.sc_home_personal.facade.CommunicationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 网关通讯
 *
 * @author wenxufeng
 * @date 2019/12/5 17:52
 **/
@RestController
@RequestMapping("/Communication")
public class CommunicationController {

    private final CommunicationFacade communicationFacade;

    @Autowired
    public CommunicationController(CommunicationFacade communicationFacade) {
        this.communicationFacade = communicationFacade;
    }

    //region********************function********************

    /**
     * 发送学习指令
     *
     * @param userId       用户Id
     * @param userType     用户类型（1：管理员；2：用户）
     * @param mac          网关mac地址
     * @param functionType 指令功能类型（红外、射频433、射频315）
     * @param type         学习类型（1：普通学习；2：随机学习）
     * @author wenxufeng
     * @date 2019/12/6 13:28
     **/
    @CheckToken
    @PostMapping("/SendStudyMessage.do")
    public ResponseResult sendStudyMessage(@RequestParam long userId,
                                           @RequestParam int userType,
                                           @RequestParam String mac,
                                           @RequestParam int functionType,
                                           @RequestParam int type) {
        return communicationFacade.sendStudyMessage(userId, userType, mac, functionType, type);
    }

    /**
     * 发送控制指令
     *
     * @param userId       用户Id
     * @param userType     用户类型（1：管理员；2：用户）
     * @param mac          网关mac地址
     * @param relayMac     中继mac地址
     * @param deviceId     设备Id
     * @param functionId   功能Id
     * @param functionType 指令功能类型（红外、射频433、射频315）
     * @param functionCode 指令码
     * @author wenxufeng
     * @date 2019/12/6 13:38
     **/
    @CheckToken
    @PostMapping("/SendControlMessage.do")
    public ResponseResult sendControlMessage(@RequestParam long userId,
                                             @RequestParam int userType,
                                             @RequestParam String mac,
                                             @RequestParam String relayMac,
                                             @RequestParam long deviceId,
                                             @RequestParam long functionId,
                                             @RequestParam int functionType,
                                             @RequestParam String functionCode) {
        return communicationFacade.sendControlMessage(userId, userType, mac, relayMac, deviceId, functionId, functionType, functionCode);
    }

    /**
     * 根据情景模式，发送控制指令
     *
     * @param userId     用户Id
     * @param userType   用户类型（1：管理员；2：用户）
     * @param centralMac 网关mac
     * @param scenarioId 情景模式Id
     * @author liuwenbo
     * @date 2020/8/31 11:44
     **/
    @CheckToken
    @PostMapping("/SendControlMessageByScenarioId.do")
    public ResponseResult sendControlMessageByScenarioId(@RequestParam long userId,
                                                         @RequestParam int userType,
                                                         @RequestParam String centralMac,
                                                         @RequestParam long scenarioId) {
        return communicationFacade.sendControlMessageByScenarioId(userId, userType, centralMac, scenarioId);
    }

    /**
     * 发送查询指令（温湿度、PM值）
     *
     * @param userId   用户Id
     * @param userType 用户类型（1：管理员；2：用户）
     * @param mac      网关mac地址
     * @param relayMac 中继mac地址
     * @author hanshuang
     * @date 2020/07/01 10:18
     **/
    @CheckToken
    @PostMapping("/SendQueryMessage.do")
    public ResponseResult sendQueryMessage(@RequestParam long userId,
                                           @RequestParam int userType,
                                           @RequestParam String mac,
                                           @RequestParam String relayMac) {
        return communicationFacade.sendQueryMessage(userId, userType, mac, relayMac);
    }

    /**
     * 发送在线升级指令
     *
     * @param userId    用户Id
     * @param userType  用户类型（1：管理员；2：用户）
     * @param mac       网关mac地址
     * @param relayMac  中继mac地址
     * @param editionId 版本Id
     * @author chujialin
     * @date 2020/11/17 14:47
     **/
    @CheckToken
    @PostMapping("/SendUpdateMessage.do")
    public ResponseResult sendUpdateMessage(@RequestParam long userId,
                                            @RequestParam int userType,
                                            @RequestParam String mac,
                                            @RequestParam String relayMac,
                                            @RequestParam long editionId) {
        return communicationFacade.sendUpdateMessage(userId, userType, mac, relayMac, editionId);
    }

    /**
     * 根据网关mac地址，查询网关状态
     *
     * @param mac 网关mac地址
     * @author wenxufeng
     * @date 2020/1/8 14:52
     **/
    @CheckToken
    @PostMapping("/SearchStateByMac.do")
    public ResponseResult<Integer> searchStateByMac(@RequestParam String mac) {
        return communicationFacade.searchStateByMac(mac);
    }

    //endregion
    //region********************通讯SP反向触发********************

    /**
     * 指令执行结果回调（连接层调用）
     *
     * @param id       指令Id
     * @param userId   用户Id
     * @param userType 用户类型（1：管理员；2：用户）
     * @param success  执行是否成功
     * @param code     执行结果（学习时为学习到的内容，失败时为失败信息）
     * @author wenxufeng
     * @date 2019/12/11 15:30
     **/
    @PostMapping("/WorkCallback.do")
    public void workCallback(@RequestParam long id,
                             @RequestParam String userId,
                             @RequestParam int userType,
                             @RequestParam boolean success,
                             @RequestParam String code) {
        communicationFacade.workCallback(id, userId == null || userId.length() == 0 ? 0 : Long.parseLong(userId), userType, success, code);
    }

    /**
     * 报警触发回调（连接层调用）
     *
     * @param mac     网关mac
     * @param message 报警信息（报警码）
     * @author wenxufeng
     * @date 2020/1/8 10:25
     **/
    @PostMapping("/WarnFunctionTrigger.do")
    public void warnFunctionTrigger(@RequestParam String mac,
                                    @RequestParam String message) {
        communicationFacade.warnFunctionTrigger(mac, message);
    }

    //endregion
}
