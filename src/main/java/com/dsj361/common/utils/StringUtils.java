package com.dsj361.common.utils;

/**
 * String工具类
 * @author wangkai
 *
 */
public class StringUtils {

    /**
     * 判断两个字符串是否相等
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equals(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        return str1.equals(str2);
    }

    /**
     * 判断字符串是否为空
     *
     * @param string
     * @return
     */
    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

    /**
     * 判断字符串不为空
     *
     * @param string
     * @return
     */
    public static boolean isNotEmpty(String string) {
        return string != null && string.length() > 0;
    }
}
