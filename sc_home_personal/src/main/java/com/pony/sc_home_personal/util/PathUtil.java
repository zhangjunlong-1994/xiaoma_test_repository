package com.pony.sc_home_personal.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 路径工具类
 */
@Component
public class PathUtil {

    private static String esPath;

    @Value("${es-path}")
    private void setEsPath(String esPath) {
        PathUtil.esPath = esPath;
    }

    public static String getEsPath() {
        return esPath;
    }

    /**
     * 用户照片
     */
    public static final String customerImgPath = "images/customer/";

    /**
     * 类型照片
     */
    public static final String typeImgPath = "images/type/";

    /**
     * 房间照片
     */
    public static final String roomImgPath = "images/room/";

    /**
     * 房产照片
     */
    public static final String houseImgPath = "images/house/";

    /**
     * 设备照片
     */
    public static final String deviceImgPath = "images/device/";

    /**
     * 用户-房产 关联照片
     */
    public static final String relationImgPath = "images/relation/";

    /**
     * 员工照片
     */
    public static final String staffImgPath = "staff/";

    /**
     * 中控器照片
     */
    public static final String centralImgPath = "images/centralController/";

    /**
     * 客服用户聊天照片
     */
    public static final String customerServicePath = "images/customerService/";

    /**
     * 版本类型文件
     */
    public static final String editionFilePath = "edition/";
}
