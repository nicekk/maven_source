package com.dsj361.common.lang;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * 取X个数据进行组合，每种组合个数为fixedSize个，总组合数不超过maxTotalAmount，返回这样的X值的最大值
     *
     * @param fixedSize
     * @param maxTotalAmount
     * @return
     */
    public static int getMaxToCombineElementCount(int fixedSize, int maxTotalAmount) {
        if (maxTotalAmount == 0 || fixedSize == 0) {
            return 0;
        }
        if (fixedSize == maxTotalAmount) {
            return 1;
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (combineCount(i, fixedSize) > maxTotalAmount) {
                return i - 1;
            }
        }
        return 0;
    }

    /**
     * 组合算法,计算个数
     *
     * @param totalSize
     * @param pickSize
     * @return
     */
    public static int combineCount(int totalSize, int pickSize) {

        if (totalSize < 0 || pickSize < 0) {
            return 0;
        }
        if (totalSize < pickSize) {
            return 0;
        }

        if (totalSize == pickSize) {
            return 1;
        }
        if (pickSize == 1) {
            return totalSize;
        }

        int count = 1;
        for (int i = 0; i < pickSize; i++) {
            count *= (totalSize - i);
        }
        return NumberUtils.toInt(count / org.apache.commons.math3.util.CombinatoricsUtils.factorial(pickSize));
    }

    /**
     * 将dataList中的数据分割,平均每个part份
     *
     * @param dataList
     * @param
     * @return
     */
    public static <E> List<List<E>> part(List<E> dataList, int part) {
        if (dataList.size() == 0) {
            return new ArrayList<List<E>>(0);
        }
        int count = dataList.size() / part;
        if (count * part != dataList.size()) {
            count = count + 1;
        }
        return average(dataList, count);
    }

    /**
     * 将dataList中的数据，平均分成resultCount份，返回
     *
     * @param dataList
     * @param resultCount
     * @return
     */
    public static <E> List<List<E>> average(List<E> dataList, int resultCount) {
        List<List<E>> resultList = new ArrayList<List<E>>();
        int eachSize = dataList.size() / resultCount;
        if ((eachSize * resultCount) / 2 < dataList.size() / 2) {
            eachSize = eachSize + 1;
        }
        for (int i = 0; i < resultCount; i++) {
            List<E> eachList = new ArrayList<E>();
            resultList.add(eachList);
            int endIndex = (i + 1) * eachSize;
            endIndex = endIndex >= dataList.size() ? dataList.size() : endIndex;
            if (i + 1 == resultCount) {
                endIndex = dataList.size();
            }
            if (i * eachSize < dataList.size()) {
                eachList.addAll(dataList.subList(i * eachSize, endIndex));
            }
        }
        return (List<List<E>>) resultList;
    }

}
