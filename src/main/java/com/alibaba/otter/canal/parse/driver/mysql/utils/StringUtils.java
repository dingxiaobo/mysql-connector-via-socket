package com.alibaba.otter.canal.parse.driver.mysql.utils;

public class StringUtils {

    public static String[] split(String sequence, String delimiter) {
        if (sequence == null) {
            return null;
        }
        return sequence.split(delimiter);
    }

    public static String join(String[] sequence, String delimiter) {
        if (sequence == null) {
            return null;
        }
        return String.join(delimiter, sequence);
    }

    public static boolean endsWithIgnoreCase(String sequence, String suffix) {
        if (sequence == null) {
            return false;
        }
        if (suffix == null) {
            return false;
        }
        return sequence.toLowerCase().endsWith(suffix.toLowerCase());
    }

    public static boolean isNotEmpty(String str) {
        if (str == null) {
            return false;
        }
        return str.length() > 0;
    }

    public static boolean isEmpty(String str) {
        return !isNotEmpty(str);
    }

}
