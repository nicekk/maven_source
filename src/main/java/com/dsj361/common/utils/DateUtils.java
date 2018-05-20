package com.dsj361.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author wangkai
 * Create on 2018/3/16 12:00
 */
public class DateUtils {

    public final static String newFormat = "yyyy-MM-dd HH:mm:ss";
    public final static String newFormat2 = "yyyy-M-d H:m:s";
    public static final String shortFormat = "yyyyMMdd";
    public final static String shortDateFormat = "MM-dd";
    public final static String yyyyMMddHH = "yyyyMMddHH";

    public static String getDateString(Date date, DateFormat dateFormat) {
        if (date == null || dateFormat == null) {
            return null;
        }
        return dateFormat.format(date);
    }

    public static String getNewFormatDateString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(newFormat);
        return getDateString(date, dateFormat);
    }

    public static Date parseDateNewFormat(String sDate) {
        Date d = null;
        if (sDate != null) {
            if (sDate.length() == newFormat.length()) {
                try {
                    DateFormat dateFormat = new SimpleDateFormat(newFormat);
                    d = dateFormat.parse(sDate);
                } catch (ParseException ex) {
                    return null;
                }
            } else {
                try {
                    DateFormat dateFormat = new SimpleDateFormat(newFormat2);
                    d = dateFormat.parse(sDate);
                } catch (ParseException ex) {
                    return null;
                }
            }
        }
        return d;
    }

    /**
     * 计算当前时间几小时之后的时间
     *
     * @param date
     * @param hours
     *
     * @return
     */
    public static Date addHours(Date date, long hours) {
        return addMinutes(date, hours * 60);
    }

    /**
     * 计算当前时间几分钟之后的时间
     *
     * @param date
     * @param minutes
     *
     * @return
     */
    public static Date addMinutes(Date date, long minutes) {
        return addSeconds(date, minutes * 60);
    }

    /**
     * @param date1
     * @param secs
     *
     * @return
     */

    public static Date addSeconds(Date date1, long secs) {
        return new Date(date1.getTime() + (secs * 1000));
    }

    /**
     * 当天的时间格式化为MM-dd
     *
     * @param date
     * @return
     */
    public static String getShortDateString(Date date) {
        DateFormat df = getNewDateFormat(shortDateFormat);

        return df.format(date);
    }

    public static DateFormat getNewDateFormat(String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);

        df.setLenient(false);
        return df;
    }

    /**
     * @return 当天的时间格式化为"yyyyMMdd"
     */
    public static String getDateString(Date date) {
        DateFormat df = getNewDateFormat(shortFormat);

        return df.format(date);
    }

    /**
     * @param date
     * @return
     */
    public static String getDateyyyyMMddHHString(Date date) {
        DateFormat df = getNewDateFormat(yyyyMMddHH);
        return df.format(date);
    }

    public static Date parseDate(String sDate, String dateFormatString) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        if ((sDate == null) || (sDate.length() < dateFormatString.length())) {
            throw new ParseException("length too little", 0);
        }

        return dateFormat.parse(sDate);
    }

    /**
     * 取得两个日期的间隔小时数
     *
     * @param one
     * @param two
     *
     * @return 间隔小时数
     */
    public static long getDiffHours(Date one, Date two) {
        return getDiffHours(one, two, false);
    }

    /**
     * 得到差异的小时数，<br>
     * 如果leftMiniutesToHour为ture，且日期相差的分钟数不能被60整除(表示2个日期差，有X小时Y分钟)，则额外增加1小时返回（
     * 返回的是X+1）
     *
     * @param one
     * @param two
     * @param leftMiniutesToHour
     * @return
     */
    public static long getDiffHours(Date one, Date two, boolean leftMiniutesToHour) {
        Calendar sysDate = new GregorianCalendar();

        sysDate.setTime(one);

        Calendar failDate = new GregorianCalendar();

        failDate.setTime(two);
        long differHours = (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) / (60 * 60 * 1000);
        if (leftMiniutesToHour && (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) % (60 * 60 * 1000) != 0) {
            differHours += 1;
        }
        return differHours;
    }

}
