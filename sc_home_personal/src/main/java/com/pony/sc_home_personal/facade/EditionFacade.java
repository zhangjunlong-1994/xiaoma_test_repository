package com.pony.sc_home_personal.facade;

import com.pony.sc_home_personal.bean.response.EditionInitBean;
import com.pony.sc_home_personal.bean.response.EditionListBean;
import com.pony.sc_home_personal.bean.response.EditionPageBean;
import com.pony.sc_home_personal.common.ResponseResult;

/**
 * @author liguotao
 * @date 2020/8/28 14:54
 */
public interface EditionFacade {

    /**
     * @author liguotao
     * @date 2020/8/28 14:53
     **/
    ResponseResult<EditionPageBean> searchEditionPageByTypeAndName(int type, int hardwareType, String name, int currentPage, int everyPage);

    /**
     * @author chujialin
     * @date 2020/9/25 16:43
     **/
    ResponseResult<EditionListBean> searchEditionList(int type, int hardwareType);

    /**
     * @author liguotao
     * @date 2020/8/28 14:53
     **/
    ResponseResult deleteEdition(long id);

    /**
     * @author liguotao
     * @date 2020/8/28 14:53
     **/
    ResponseResult<EditionInitBean> editEditionInit(long id);

    /**
     * @author liguotao
     * @date 2020/8/28 14:53
     **/
    ResponseResult searchEditionNameExist(String name, int equipmentType, int hardwareType);

    /**
     * @author liguotao
     * @date 2020/8/28 14:53
     **/
    ResponseResult<String> searchNewEdition(int equipmentType, int hardwareType);

    /**
     * @author liguotao
     * @date 2020/8/28 14:53
     **/
    ResponseResult editEdition(long id, String name, int hardwareType, int equipmentType, String fileName, String explain);
}
