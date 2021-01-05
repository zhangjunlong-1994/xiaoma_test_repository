package com.pony.springboot_demo.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zjl
 * @date 2020/10/17 9:55
 * 用户详细信息实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户详细信息")
public class UserInfo {

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
