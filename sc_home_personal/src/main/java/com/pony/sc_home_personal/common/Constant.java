package com.pony.sc_home_personal.common;

/**
 * @author chujialin
 * @date 2020/7/29 16:46
 **/
public class Constant {

    public final static byte FRAME_FUNCTION_STUDY = (byte) 0x01;            //学习
    public final static byte FRAME_FUNCTION_CONTROL = (byte) 0x02;          //控制
    public final static byte FRAME_FUNCTION_ALERT = (byte) 0x03;            //报警
    public final static byte FRAME_FUNCTION_QUERY = (byte) 0x05;            //查询
    public final static byte FRAME_FUNCTION_UPDATE = (byte) 0x11;           //升级
    public final static byte FRAME_FUNCTION_OFFLINE = (byte) 0x12;          //离线包

    public final static int DEVICE_STATE_UNBIND = 0;                        //设备未绑定
    public final static int DEVICE_STATE_ON = 1;                            //设备在线
    public final static int DEVICE_STATE_OFF = 2;                           //设备离线
    public final static int DEVICE_STATE_STUDY = 3;                         //设备学习中

    public final static int warnSettingExecuteTypeScenario = 1;
    public final static int warnSettingExecuteTypeCustom = 2;

    public final static int customerServiceTypeString = 1;
    public final static int customerServiceTypeImage = 2;
}
