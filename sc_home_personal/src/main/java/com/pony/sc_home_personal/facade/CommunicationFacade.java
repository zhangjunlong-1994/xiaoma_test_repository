package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.common.ResponseResult;

/**
 * @author wenxufeng
 * @date 2019/12/6 13:42
 **/
public interface CommunicationFacade {

    /**
     * @author chujialin
     * @date 2020/4/9 16:02
     **/
    ResponseResult sendStudyMessage(long userId, int userType, String mac, int functionType, int type);

    /**
     * @author chujialin
     * @date 2020/4/9 16:02
     **/
    ResponseResult sendControlMessage(long userId, int userType, String mac, String relayMac, long deviceId, long functionId, int functionType, String functionCode);

    /**
     * @author liuwenbo
     * @date 2020/8/31 11:41
     **/
    ResponseResult sendControlMessageByScenarioId(long userId, int userType, String centralMac, long scenarioId);

    /**
     * @author hanshuang
     * @date 2020/07/01 10:20
     **/
    ResponseResult sendQueryMessage(long userId, int userType, String mac, String relayMac);

    /**
     * @author chujialin
     * @date 2020/11/17 15:03
     **/
    ResponseResult sendUpdateMessage(long userId, int userType, String mac, String relayMac, long editionId);

    /**
     * @author suntai
     * @date 2020/1/17 13:45
     **/
    ResponseResult<Integer> searchStateByMac(String mac);

    /**
     * @author chujialin
     * @date 2020/4/9 16:02
     **/
    void workCallback(long id, long userId, int userType, boolean success, String code);

    /**
     * @author wenxufeng
     * @date 2020/1/8 10:24
     **/
    void warnFunctionTrigger(String mac, String code);
}
