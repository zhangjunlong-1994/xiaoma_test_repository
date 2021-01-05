package com.pony.springboot_demo.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zjl
 * @date 2020/10/17 9:50
 * Json数据封装类
 */
@ApiModel("用户详细信息JSON数据")
@Data
public class ViewBean<T> {

    /**
     * 返回值代码
     */
    @JsonProperty("code:")
    @ApiModelProperty("返回值代码")
    private Integer code;

    /**
     * 返回值提示信息
     */
    @JsonProperty("message:")
    @ApiModelProperty("返回值提示信息")
    private String message;

    /**
     * 返回Json数据
     */
    @JsonProperty("data:")
    @ApiModelProperty("返回数据")
    private T data;
}
