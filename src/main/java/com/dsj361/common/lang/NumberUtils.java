package com.dsj361.common.lang;

import java.math.BigDecimal;

public class NumberUtils extends org.apache.commons.lang.math.NumberUtils {

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


    public static long toLong(Object obj) {
        return toLong(obj, 0);
    }

    public static long toLong(Object obj, long defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        return toLong(ObjectUtils.toString(obj), defaultValue);
    }

    public static int toInt(Object obj) {
        return toInt(obj, 0);
    }

    public static int toInt(Object obj, int defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue();
        }
        return toInt(ObjectUtils.toString(obj), defaultValue);
    }

    public static short toShort(Object obj) {
        return toShort(obj, (short) 0);
    }

    public static short toShort(Object obj, short defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        if (obj instanceof Number) {
            return ((Number) obj).shortValue();
        }
        return toShort(ObjectUtils.toString(obj), defaultValue);
    }

    public static short toShort(String str, short defaultValue) {
        if (str == null) {
            return defaultValue;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException nfe) {
            return defaultValue;
        }
    }

    public static float toFloat(Object obj) {
        return toFloat(obj, 0);
    }

    public static float toFloat(Object obj, float defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        return toFloat(ObjectUtils.toString(obj), defaultValue);
    }

    public static double toDouble(Object obj) {
        return toDouble(obj, 0);
    }

    public static double toDouble(Object obj, double defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        return toDouble(ObjectUtils.toString(obj), defaultValue);
    }




}
