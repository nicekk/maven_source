package com.dsj361.common.lang;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author wangkai
 * @date 2018/7/5 21:31
 */
public class MathUtils {

    /**
     * 对BigDecimal型的值按指定取整方式取整。
     *
     * @param val
     *            待取整的BigDecimal值
     * @param roundingMode
     *            取整方式
     *
     * @return 取整后的long型值
     */
    public static long rounding(BigDecimal val, int roundingMode) {
        return val.setScale(0, roundingMode).longValue();
    }

    /**
     * 小数点保留,a除以b，保留scale位
     *
     * @param a
     * @param b
     * @param scale
     * @return
     */
    public static double scale(Number a, Number b, int scale) {
        return scale(a.doubleValue() / b.doubleValue(), scale);
    }

    /**
     * 小数点保留，保留scale位,如果clearLastZero为true,则清除最后的0
     *
     * @param a
     * @param scale
     * @param clearLastZero
     * @return
     */
    public static String scale(Number a, int scale, boolean clearLastZero) {
        String scaleValue = scaleString(a.doubleValue(), scale);
        if (!clearLastZero) {
            return scaleValue;
        }
        for (int i = 0; i < 10 && scaleValue.indexOf(".") > 0 && scaleValue.endsWith("0"); i++) {
            scaleValue = scaleValue.substring(0, scaleValue.length() - 1);
        }
        if (scaleValue.endsWith(".")) {
            scaleValue = scaleValue.substring(0, scaleValue.length() - 1);
        }
        return scaleValue;
    }

    /**
     * 小数点保留,a除以b，保留scale位,如果clearLastZero为true,则清除最后的0
     *
     * @param a
     * @param b
     * @param scale
     * @param clearLastZero
     * @return
     */
    public static String scale(Number a, Number b, int scale, boolean clearLastZero) {
        return scale(a.doubleValue() / b.doubleValue(), scale, clearLastZero);
    }

    /**
     * 小数点保留，数字a保留scale位
     *
     * @param a
     * @param scale
     * @return
     */
    public static double scale(Number a, int scale) {
        Double flag = null;
        String text = a.toString();
        BigDecimal bd = new BigDecimal(text).setScale(scale, BigDecimal.ROUND_HALF_UP);
        flag = bd.doubleValue();
        return flag;

    }

    /**
     * 小数点保留，数字a保留scale位，不足位用0补齐
     *
     * @param a
     * @param scale
     * @return
     */
    public static String scaleString(Number a, int scale) {
        return scaleString(new BigDecimal(a.toString()).setScale(scale, BigDecimal.ROUND_HALF_UP), scale);
    }

    public static String scaleString(Double a, int scale) {
        return scaleString(new BigDecimal(a).setScale(scale, BigDecimal.ROUND_HALF_UP), scale);
    }

    public static String scaleString(BigDecimal bd, int scale, boolean fillZero) {
        return scaleString(bd.doubleValue(), scale, fillZero);
    }

    /**
     * 小数点保留，数字a保留scale位，fillZeroe为true时，不足位用0补齐
     *
     * @param
     * @param scale
     * @param fillZero
     * @return
     */
    public static String scaleString(double value, int scale, boolean fillZero) {

        StringBuffer buf = new StringBuffer("0");
        if (scale > 0) {
            buf.append(".");
            for (int i = 0; i < scale; i++) {
                if (fillZero) {
                    buf.append("0");
                } else {
                    buf.append("#");
                }
            }
        }

        DecimalFormat g = new DecimalFormat(buf.toString());
        return g.format(value);
    }

    /**
     * 小数点保留，数字a保留scale位，不足位用0补齐
     *
     * @param
     * @param scale
     * @return
     */
    public static String scaleString(BigDecimal bd, int scale) {
        return scaleString(bd, scale, true);
    }

}
