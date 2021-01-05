package com.pony.sc_home_personal.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 获取byte数组工具
 */
public class ByteUtil {

    /**
     * 16进制字符对应int值
     */
    private static Map<String, Integer> strToByteMap = new HashMap<String, Integer>() {{
        put("0", 0);put("1", 1);put("2", 2);put("3", 3);put("4", 4);
        put("5", 5);put("6", 6);put("7", 7);put("8", 8);put("9", 9);
        put("a", 10);put("b", 11);put("c", 12);put("d", 13);put("e", 14);put("f", 15);
        put("A", 10);put("B", 11);put("C", 12);put("D", 13);put("E", 14);put("F", 15);
    }};

    /**
     * 将16进制字符串转为byte数组
     */
    public static byte[] getByteFromString(String data) {
        String[] strArray = data.trim().split(" ");
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
     * 将byte数组转为16进制字符串
     */
    public static String getStringFromByte(byte[] data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : data) {
            stringBuilder
                    .append(Integer.toHexString((b >> 4) & (byte) 0x0F))
                    .append(Integer.toHexString((b & (byte) 0x0F)))
                    .append(" ");
        }
        return stringBuilder.toString().trim().toUpperCase();
    }

    /**
     * 将10进制数转为BCD码数组
     */
    public static byte[] getBCDFromInteger(int data) {
        String str = String.valueOf(data);
        char[] strArray = str.toCharArray();
        byte[] byteArray;
        if (strArray.length % 2 == 0) {
            byteArray = new byte[strArray.length / 2];
            for (int i = 0; i < byteArray.length; i++) {
                int integer1 = strToByteMap.get(String.valueOf(strArray[i * 2]));
                int integer2 = strToByteMap.get(String.valueOf(strArray[i * 2 + 1]));
                byteArray[i] = (byte) ((byte) (integer1 << 4 ) | (byte) integer2);
            }
        } else {
            byteArray = new byte[strArray.length / 2 + 1];
            int integer = strToByteMap.get(String.valueOf(strArray[0]));
            byteArray[0] = (byte) integer;
            for (int i = 1; i < byteArray.length; i++) {
                int integer1 = strToByteMap.get(String.valueOf(strArray[i * 2 - 1]));
                int integer2 = strToByteMap.get(String.valueOf(strArray[i * 2]));
                byteArray[i] = (byte) ((byte) (integer1 << 4 ) | (byte) integer2);
            }
        }
        return byteArray;
    }

    /**
     * 将BCD码数组转为10进制数
     */
    public static int getIntegerFromBCD(byte[] data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : data) {
            stringBuilder.append(Integer.toString((b >> 4) & (byte) 0x0F)).append(Integer.toString(b & (byte) 0x0F));
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    /**
     * 将2进制数转为10进制数
     */
    public static int getIntegerFromByte(byte data) {
        int data1 = (data >> 4) & (byte) 0x0F;
        int data2 = data & (byte) 0x0F;
        return data1 * 16 + data2;
    }
}
