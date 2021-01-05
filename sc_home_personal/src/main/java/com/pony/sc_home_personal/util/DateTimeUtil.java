package com.pony.sc_home_personal.util;


import com.pony.sc_home_personal.common.DatePattern;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author liguotao
 * @date 2020/8/25 14:35
 */
public class DateTimeUtil {
    /**
     * @return java.sql.Timestamp
     * @description 取得Timestamp类型（数据库表字段DateTime类型）的当前系统时间，性能更好一些
     * @author gaofeng
     * @date 2019/12/10 14:59
     **/
    public static Timestamp getCurrentTime() {
        return new Timestamp(System.currentTimeMillis());
    }

//    public static long getLocalTimeLong() {
//        SimpleDateFormat format=new SimpleDateFormat(DatePattern.NORM_DATETIME);
//        java.util.Date localDate= new java.util.Date();
//        format.format(localDate);
//        Timestamp timestamp = new Timestamp(new Date(DatePattern.NORM_DATETIME).getTime());
//        return
//    }

    /**
     * @param timestamp 数据库表字段DateTime类型日期时间
     * @param pattern   格式
     * @return java.lang.String
     * @description 根据格式，日期时间转换成字符串
     * @author gaofeng
     * @date 2019/12/14 11:37
     **/
    public static String format(Timestamp timestamp, String pattern) {
        return null == timestamp ? "" : timestamp.toLocalDateTime().format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * @param date    数据库表字段Date类型日期
     * @param pattern 格式
     * @return java.lang.String
     * @description 根据格式，日期转换成字符串
     * @author gaofeng
     * @date 2019/12/14 11:37
     **/
    public static String format(Date date, String pattern) {
        return null == date ? "" : date.toLocalDate().format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * @param date    日期类型字符串
     * @param pattern 格式
     * @return java.sql.Date
     * @description 判断格式，日期字符串转换成数据库日期类型
     * @author gaofeng
     * @date 2019/12/18 9:43
     **/
    public static Date convert(String date, String pattern){
        if(isValidDate(date, pattern)){
            return Date.valueOf(date);
        }
        return null;
    }


    /**
     * @param data    当前日期
     * @return java.sql.Date
     * @description 判断当前日期是周几
     * @author liguotao
     * @date 2020/4/1 15:17
     **/
    public static String getWeek(Date data){
        String week = "";
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        int weekday = c.get(Calendar.DAY_OF_WEEK);
        if (weekday == 1) {
            week = "周日";
        } else if (weekday == 2) {
            week = "周一";
        } else if (weekday == 3) {
            week = "周二";
        } else if (weekday == 4) {
            week = "周三";
        } else if (weekday == 5) {
            week = "周四";
        } else if (weekday == 6) {
            week = "周五";
        } else if (weekday == 7) {
            week = "周六";
        }
        return week;
    }

    // 判断参数的格式是否为合法日期字符串
    private static boolean isValidDate(String str, String pattern) {
        try {
            if (str != null && !str.equals("")) {
                // PURE_DATE：8，"yyyyMMdd"，NORM_DATE：10，"yyyy-MM-dd"，CHINESE_DATE：11，"yyyy年MM月dd日"
                if (str.length() == pattern.length() && (pattern.length() == 8 || pattern.length() == 10 || pattern.length() == 11)) {
                    // 闰年标志
                    boolean isLeapYear = false;
                    String year = "", month = "", day = "";
                    switch (pattern){
                        case DatePattern.PURE_DATE:
                            year = str.substring(0, 4);
                            month = str.substring(4, 6);
                            day = str.substring(6, 8);
                            break;
                        case DatePattern.NORM_DATE:
                            year = str.substring(0, 4);
                            month = str.substring(5, 7);
                            day = str.substring(8, 10);
                            break;
                        case DatePattern.CHINESE_DATE:
                            year = str.substring(0, 4);
                            month = str.substring(5, 7);
                            day = str.substring(8, 10);
                            break;
                    }

                    int vYear = Integer.parseInt(year);
                    // 判断年份是否合法
                    if (vYear < 1900 || vYear > 2200) {
                        return false;
                    }
                    // 判断是否为闰年
                    if (vYear % 4 == 0 && vYear % 100 != 0 || vYear % 400 == 0) {
                        isLeapYear = true;
                    }
                    // 判断月份
                    // 1.判断月份
                    if (month.startsWith("0")) {
                        String units4Month = month.substring(1, 2);
                        int vUnits4Month = Integer.parseInt(units4Month);
                        if (vUnits4Month == 0) {
                            return false;
                        }
                        if (vUnits4Month == 2) {
                            // 获取2月的天数
                            int vDays4February = Integer.parseInt(day);
                            if (isLeapYear) {
                                if (vDays4February > 29)
                                    return false;
                            } else {
                                if (vDays4February > 28)
                                    return false;
                            }
                        }
                    } else {
                        // 2.判断非0打头的月份是否合法
                        int vMonth = Integer.parseInt(month);
                        if (vMonth != 10 && vMonth != 11 && vMonth != 12) {
                            return false;
                        }
                    }
                    // 判断日期
                    // 1.判断日期
                    if (day.startsWith("0")) {
                        String units4Day = day.substring(1, 2);
                        int vUnits4Day = Integer.parseInt(units4Day);
                        return vUnits4Day != 0;
                    } else {
                        // 2.判断非0打头的日期是否合法
                        int vDay = Integer.parseInt(day);
                        return vDay >= 10 && vDay <= 31;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /*===================================还未使用过的方法，不知道是否有用============================================*/



    /**
     * @param date java.sql.date
     * @return java.time.LocalDate
     * @description sql.Date转localDate
     * @author wenxufeng
     * @date 2019/11/14 13:59
     **/
    public static LocalDate sqlToLocal(Date date) {
        return date.toLocalDate();
    }

    /**
     * @param date   sql.date
     * @param format 字符串类型（yyyy-MM-dd）
     * @return java.lang.String
     * @describe sql.Date转自定义字符串
     * @author wenxufeng
     * @date 2019/11/14 14:01
     **/
    public static String sqlToString(Date date, String format) {
        if (date == null) {
            return null;
        }
        return date.toLocalDate().format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * @param date yyyy-MM-dd格式字符串
     * @return java.sql.Date
     * @describe 字符串转sql.Date
     * @author wenxufeng
     * @date 2019/11/14 14:18
     **/
    public static Date stringToSql(String date) {
        if (date == null) {
            return null;
        }
        return Date.valueOf(date);
    }

    /**
     * @param timestamp timestamp
     * @return java.time.LocalDateTime
     * @describe Timestamp转LocalDateTime
     * @author wenxufeng
     * @date 2019/11/14 14:37
     **/
    public static LocalDateTime timeToLocalDateTime(Timestamp timestamp) {
        return timestamp.toLocalDateTime();
    }


    /**
     * @param time yyyy-MM-dd HH:mm:ss格式字符串
     * @return java.sql.Timestamp
     * @describe 字符串转Timestamp
     * @author wenxufeng
     * @date 2019/11/14 14:47
     **/
    public static Timestamp stringToTime(String time) {
        if (time == null) {
            return null;
        }
        return Timestamp.valueOf(time);
    }


    /**
     * @return java.sql.Date
     * @describe 获取当前日期sql.Date格式
     * @author wenxufeng
     * @date 2019/11/14 14:49
     **/
    public static Date getLocalDate() {
        return Date.valueOf(LocalDate.now());
    }


    /**
     * @author shanzhibing
     * @date 2020/3/23 14:45
     * @describe 字符串转Time
     **/
    public static Time StingToTime(String time){
        return Time.valueOf(time);
    }

    /**
     * @author shanzhibing
     * @method
     **/
    public static List<Date> nowWeek(String time){
        List<Date> dateList = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        cal.setTime(Date.valueOf(time));
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一  
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了  
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天  
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 获得当前日期是一个星期的第几天  
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 获取该周第一天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        Date beginDate = Date.valueOf(sdf.format(cal.getTime()));
        // 获取该周最后一天
        cal.add(Calendar.DATE, 6);
        Date endDate = Date.valueOf(sdf.format(cal.getTime()));
        dateList.add(beginDate);
        dateList.add(endDate);
        return dateList;
    }
}
