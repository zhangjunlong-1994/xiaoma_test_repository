package com.pony.sc_home_personal.common;

import lombok.Data;

/**
 * @author gaofeng
 * @date 2020/1/2 9:56
 **/
@Data
public class ViewBean<T> {

    private int code;
    private T data;
}
