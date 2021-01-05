package com.pony.springboot_demo.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zjl
 * @date 2020/10/17 9:38
 * 用户实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户基础信息")
public class User {

    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;

    /**
     * 用户年龄
     */
    @ApiModelProperty("用户年龄")
    private Integer userAge;

    /**
     * 用户性别
     */
    @ApiModelProperty("用户性别")
    private String sexType;
}
