package com.pony.springboot_demo.bean.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zjl
 * @date 2020/10/17 10:01
 * 出参数据ViewBean.data封装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class UserInfoBean {

    /**
     * 用户工资
     */
    @ApiModelProperty("用户工资")
    private BigDecimal salary;

    /**
     * 用户职位
     */
    @ApiModelProperty("用户职位")
    private String grade;

    /**
     * 用户工龄
     */
    @ApiModelProperty("用户工龄")
    private Integer workAge;

    /**
     * 用户地址
     */
    @ApiModelProperty("用户地址")
    private String addr;
}
