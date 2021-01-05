package com.pony.sc_home_personal.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wenxufeng
 * @description
 * @date 2019/12/6 15:14
 **/
public class DataConversionUtil {

    //16进制字符对应int值
    private static Map<String, Integer> strToByteMap = new HashMap<String, Integer>() {{
        put("0", 0);
        put("1", 1);
        put("2", 2);
        put("3", 3);
        put("4", 4);
        put("5", 5);
        put("6", 6);
        put("7", 7);
        put("8", 8);
        put("9", 9);
        put("a", 10);
        put("b", 11);
        put("c", 12);
        put("d", 13);
        put("e", 14);
        put("f", 15);
        put("A", 10);
        put("B", 11);
        put("C", 12);
        put("D", 13);
        put("E", 14);
        put("F", 15);
    }};

    private static final Map<Character, Integer> CHAR_INT = new HashMap<Character, Integer>() {{
        put('0', 0);
        put('1', 1);
        put('2', 2);
        put('3', 3);
        put('4', 4);
        put('5', 5);
        put('6', 6);
        put('7', 7);
        put('8', 8);
        put('9', 9);
        put('a', 0x0a);
        put('b', 0x0b);
        put('c', 0x0c);
        put('d', 0x0d);
        put('e', 0x0e);
        put('f', 0x0f);
        put('A', 0x0a);
        put('B', 0x0b);
        put('C', 0x0c);
        put('D', 0x0d);
        put('E', 0x0e);
        put('F', 0x0f);
    }};
    public static Map<String, String> studyNub = new HashMap<>();
    public static Map<String, String> studyDevice = new HashMap<>();

    /**
     * @param code 字符串
     * @return byte[]
     * @description 将字符串转换成16进制byte数组
     * @author wenxufeng
     * @date 2019/12/5 8:37
     **/
    public static byte[] getInformationCode(String code) {
        byte[] bytes = new byte[code.length() / 2];
        char[] chars = code.toCharArray();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) ((CHAR_INT.get(chars[2 * i]) << 4) | CHAR_INT.get(chars[2 * i + 1]));
        }
        return bytes;
    }

    /**
     * 16进制字符串与字节数组转换(空格分隔）
     *
     * @author chujialin
     * @date 2020/3/13 14:57
     **/
    public static byte[] hexStringToByteArray(String hexString) {
        String[] strArray = hexString.trim().split(" ");
        byte[] textByte = new byte[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].length() == 0 || strArray[i].length() > 2) {
                return null;
            } else {
                char[] chars = strArray[i].toCharArray();
                int char_int1 = strToByteMap.get(String.valueOf(chars[0]));
                int char_int2 = strToByteMap.get(String.valueOf(chars[1]));
                byte char_byte1 = (byte) (char_int1 << 4);
                byte char_byte2 = (byte) char_int2;
                textByte[i] = (byte) (char_byte1 | char_byte2);
            }
        }
        return textByte;
    }
    /**
     * @param code 回令字符串
     * @return byte[]
     * @description 将回令类型字符串转换成16进制数组
     * @author wenxufeng
     * @date 2019/12/6 17:20
     **/
    public static byte[] getResposeCode(String code) {
        byte[] bytes = new byte[code.length()];
        char[] chars = code.toCharArray();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = CHAR_INT.get(chars[i]).byteValue();
        }
        return bytes;
    }

    public static String getStringWithSpace(String res){
        String re="";
        char[] arr = res.toCharArray();
        if(arr.length>0){
            re = ""+ arr[0];
            for(int i=1;i<arr.length;i++){
                if (i % 2==0){
                    re = re + " "+ arr[i] ;
                }else{
                    re = re + arr[i];
                }
            }
        }
        return re;
    }
}
