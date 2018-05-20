package com.dsj361.common.utils;

import java.math.BigDecimal;

public class NumberUtils {

    /**
     * 小数点保留，数字a保留scale位，直接舍去<br>
     *
     * <pre>
     * scaleRundDown(65.5856, 2) = 65.58
     * </pre>
     *
     * @param a
     * @param scale
     * @return
     */
    public static double scaleRundDown(Number a, int scale) {
        Double flag = null;
        String text = a.toString();
        BigDecimal bd = new BigDecimal(text).setScale(scale, BigDecimal.ROUND_DOWN);
        flag = bd.doubleValue();
        return flag;
    }
}
