package com.pony.sc_home_personal.controller;

import com.pony.sc_home_personal.bean.response.EditionInitBean;
import com.pony.sc_home_personal.bean.response.EditionListBean;
import com.pony.sc_home_personal.bean.response.EditionPageBean;
import com.pony.sc_home_personal.common.ResponseResult;
import com.pony.sc_home_personal.config.CheckToken;
import com.pony.sc_home_personal.facade.EditionFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 版本（网关、中继）
 *
 * @author liguotao
 * @date 2020/8/28 15:08
 */
@RestController
@RequestMapping("/ScEdition")
public class EditionController {

    private final EditionFacade editionFacade;

    @Autowired
    public EditionController(EditionFacade editionFacade) {
        this.editionFacade = editionFacade;
    }

    /**
     * 获取版本分页列表
     *
     * @param type         版本类别（所有：0；网关：1；中继：2）
     * @param hardwareType 硬件版本（所有：0）
     * @param name         名称（模糊查询，所有：""）
     * @param currentPage  当前页数（从0开始）
     * @param everyPage    每页条数
     * @author liguotao
     * @date 2020/8/28 15:13
     **/
    @CheckToken
    @PostMapping("/SearchEditionPageByTypeAndName.do")
    public ResponseResult<EditionPageBean> searchEditionPageByTypeAndName(@RequestParam int type,
                                                                          @RequestParam int hardwareType,
                                                                          @RequestParam String name,
                                                                          @RequestParam int currentPage,
                                                                          @RequestParam int everyPage) {
        return editionFacade.searchEditionPageByTypeAndName(type, hardwareType, name, currentPage, everyPage);
    }

    /**
     * 获取版本列表
     *
     * @param type         版本类别（所有：0；网关：1；中继：2）
     * @param hardwareType 硬件版本（所有：0）
     * @author chujialin
     * @date 2020/9/25 16:34
     **/
    @CheckToken
    @PostMapping("/SearchEditionList.do")
    public ResponseResult<EditionListBean> searchEditionList(@RequestParam int type,
                                                             @RequestParam int hardwareType) {
        return editionFacade.searchEditionList(type, hardwareType);
    }

    /**
     * 删除版本
     *
     * @param id 版本Id
     * @author liguotao
     * @date 2020/8/28 15:13
     **/
    @CheckToken
    @PostMapping("/DeleteEdition.do")
    public ResponseResult deleteEdition(@RequestParam long id) {
        return editionFacade.deleteEdition(id);
    }

    /**
     * 编辑初始化
     *
     * @param id 版本Id
     * @author liguotao
     * @date 2020/8/28 15:13
     **/
    @CheckToken
    @PostMapping("/EditEditionInit.do")
    public ResponseResult<EditionInitBean> editEditionInit(@RequestParam long id) {
        return editionFacade.editEditionInit(id);
    }

    /**
     * 查询版本名称是否存在
     *
     * @param name          版本名称
     * @param equipmentType 版本类别（所有：0；网关：1；中继：2）
     * @param hardwareType  硬件版本号
     * @author liguotao
     * @date 2020/8/28 15:13
     **/
    @CheckToken
    @PostMapping("/SearchEditionNameExist.do")
    public ResponseResult searchEditionNameExist(@RequestParam String name,
                                                 @RequestParam int equipmentType,
                                                 @RequestParam int hardwareType) {
        return editionFacade.searchEditionNameExist(name, equipmentType, hardwareType);
    }

    /**
     * 获取最新版本号
     *
     * @param equipmentType 版本类别（所有：0；网关：1；中继：2）
     * @param hardwareType  硬件版本号
     * @author liguotao
     * @date 2020/8/28 15:14
     **/
    @CheckToken
    @PostMapping("/SearchNewEdition.do")
    public ResponseResult<String> searchNewEdition(@RequestParam int equipmentType,
                                                   @RequestParam int hardwareType) {
        return editionFacade.searchNewEdition(equipmentType, hardwareType);
    }

    /**
     * 编辑版本
     *
     * @param id            版本Id
     * @param name          版本名称
     * @param hardwareType  硬件版本号
     * @param equipmentType 版本类别
     * @param fileName      固件临时文件名
     * @param explain       版本说明
     * @author liguotao
     * @date 2020/8/28 15:14
     **/
    @CheckToken
    @PostMapping("/EditEdition.do")
    public ResponseResult editEdition(@RequestParam long id,
                                      @RequestParam String name,
                                      @RequestParam int hardwareType,
                                      @RequestParam int equipmentType,
                                      @RequestParam String fileName,
                                      @RequestParam String explain) {
        return editionFacade.editEdition(id, name, hardwareType, equipmentType, fileName, explain);
    }
}
