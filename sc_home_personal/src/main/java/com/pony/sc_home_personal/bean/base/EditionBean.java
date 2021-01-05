package com.pony.sc_home_personal.bean.base;

import lombok.Data;

/**
 * @author liguotao
 * @date 2020/8/28 11:21
 */
@Data
public class EditionBean {

    private long id;
    private String name;
    private int hardwareType;//硬件类型
    private int equipmentType;//设备类型
    private String equipmentTypeName;
    private String hardwareTypeName;
    private String fileName;
    private String explain;
    private String createDate;
}
