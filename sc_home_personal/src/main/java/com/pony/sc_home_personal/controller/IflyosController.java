package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.bean.response.IflyosInitBean;
import com.pony.sc_home_personal.bean.response.IflyosPageBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.facade.IflyosFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 蓝小飞
 *
 * @author chujialin
 * @date 2020/5/9 15:43
 **/
@RestController
@RequestMapping("/ScIflyos")
public class IflyosController {

    private final IflyosFacade iflyosFacade;

    @Autowired
    public IflyosController(IflyosFacade iflyosFacade) {
        this.iflyosFacade = iflyosFacade;
    }

    /**
     * 发送控制指令
     *
     * @param iflyosId 蓝小飞Id
     * @param action   动作
     * @param position 位置
     * @param device   设备
     * @author chujialin
     * @date 2020/5/8 14:11
     **/
    @PostMapping("/SendControlMessageByIflyos.do")
    public ResponseResult sendControlMessageByIflyos(@RequestParam String iflyosId,
                                                     @RequestParam String action,
                                                     @RequestParam(required = false) String position,
                                                     @RequestParam String device) {
        return iflyosFacade.sendControlMessage(iflyosId, action, position, device);
    }

    /**
     * 根据情景模式，发送控制指令
     *
     * @param iflyosId 蓝小飞Id
     * @param scenario 情景模式
     * @author chujialin
     * @date 2020/5/8 14:11
     **/
    @PostMapping("/SendControlMessageByScenario.do")
    public ResponseResult sendControlMessageByScenario(@RequestParam String iflyosId,
                                                       @RequestParam String scenario) {
        return iflyosFacade.sendControlMessageByScenario(iflyosId, scenario);
    }

    /**
     * 获取蓝小飞分页列表
     *
     * @param currentPage 当前页数（从0开始）
     * @param everyPage   每页条数
     * @author liguotao
     * @date 2020/8/31 20:31
     **/
    @PostMapping("/SelectIflyosByPage.do")
    public ResponseResult<IflyosPageBean> selectIflyosByPage(@RequestParam int currentPage,
                                                             @RequestParam int everyPage) {
        return iflyosFacade.selectIflyosByPage(currentPage, everyPage);
    }

    /**
     * 删除蓝小飞
     *
     * @param id 蓝小飞Id
     * @author liguotao
     * @date 2020/8/31 20:33
     **/
    @PostMapping("/DeleteIflyosById.do")
    public ResponseResult deleteIflyosById(@RequestParam String id) {
        return iflyosFacade.deleteIflyosById(id);
    }

    /**
     * 编辑初始化
     *
     * @param id 蓝小飞Id
     * @author liguotao
     * @date 2020/8/31 20:35
     **/
    @PostMapping("/EditIflyosInit.do")
    public ResponseResult<IflyosInitBean> editIflyosInit(@RequestParam String id) {
        return iflyosFacade.editIflyosInit(id);
    }

    /**
     * 编辑蓝小飞
     *
     * @param id        蓝小飞Id
     * @param centralId 网关Id
     * @param snNumber  SN码
     * @author liguotao
     * @date 2020/8/31 20:36
     **/
    @PostMapping("/SaveIflyos.do")
    public ResponseResult saveIflyos(@RequestParam String id,
                                     @RequestParam long centralId,
                                     @RequestParam String snNumber) {
        return iflyosFacade.saveIflyos(id, centralId, snNumber);
    }

    /**
     * @author wang
     * @date 2020/12/30 20:36
     **/
    @PostMapping("/SaveIflyosMac.do")
    public ResponseResult saveIflyosMac(@RequestParam String sNNumber) {
        return iflyosFacade.saveIflyosMac(sNNumber);
    }
}
