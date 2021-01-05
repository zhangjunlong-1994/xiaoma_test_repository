package com.pony.sc_home_personal.facade;


import com.pony.sc_home_personal.bean.response.IflyosInitBean;
import com.pony.sc_home_personal.bean.response.IflyosPageBean;
import com.pony.sc_home_personal.common.ResponseResult;

/**
 * @author chujialin
 * @date 2020/5/9 15:46
 **/
public interface IflyosFacade {

    /**
     * @author chujialin
     * @date 2020/4/11 8:40
     **/
    ResponseResult sendControlMessage(String iflyosId, String action, String position, String device);

    /**
     * @author chujialin
     * @date 2020/4/11 8:40
     **/
    ResponseResult sendControlMessageByScenario(String iflyosId, String scenario);


    /**
     * @author liguotao
     * @date 2020/8/31 20:15
     **/
    ResponseResult<IflyosPageBean> selectIflyosByPage(int currentPage, int everyPage);

    /**
     * @author liguotao
     * @date 2020/8/31 20:15
     **/
    ResponseResult deleteIflyosById(String id);

    /**
     * @author liguotao
     * @date 2020/8/31 20:16
     **/
    ResponseResult<IflyosInitBean> editIflyosInit(String id);

    /**
     * @author liguotao
     * @date 2020/8/31 20:17
     **/
    ResponseResult saveIflyos(String id, long centralId ,String snNumber);

    /**
     * @author wang
     * @date 2020/12/29 20:17
     **/
    ResponseResult saveIflyosMac(String sNNumber);
}
