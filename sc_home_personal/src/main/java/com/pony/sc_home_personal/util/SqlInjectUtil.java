package com.pony.sc_home_personal.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author gaofeng
 * @date 2019/12/22 16:05
 **/
public class SqlInjectUtil {

    private static String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|" +
            "(\\b(select|update|and|or|delete|insert|trancate|char|into|" +
            "substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";

    private static Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE); //表示忽略大小写

    public static boolean isSqlValid(String... str) {
        for (String math : str) {
            Matcher matcher = sqlPattern.matcher(math);
            if (matcher.find()) {
                return false;
            }
        }
        return true;
    }
}
