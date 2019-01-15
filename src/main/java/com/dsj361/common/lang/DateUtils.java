package com.dsj361.common.lang;

import oracle.sql.TIMESTAMP;

import java.sql.Timestamp;
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
    public final static String yyyyMMddHHmm = "yyyyMMddHHmm";
    public final static String shortDateFormat = "MM-dd";
    public final static String yyyyMMddHH = "yyyyMMddHH";
    public final static String webFormat = "yyyy-MM-dd";
    public final static String dayOnlyFormat = "dd";
    public final static String monthOnlyFormat = "MM";

    public final static long ONE_DAY_SECONDS = 86400;

    public final static long ONE_DAY_MILL_SECONDS = 86400000;

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
     * @return
     */
    public static Date addMinutes(Date date, long minutes) {
        return addSeconds(date, minutes * 60);
    }

    /**
     * @param date1
     * @param secs
     * @return
     */

    public static Date addSeconds(Date date1, long secs) {
        return new Date(date1.getTime() + (secs * 1000));
    }

    /**
     * 取得新的日期
     *
     * @param date1 日期
     * @param days  天数
     * @return 新的日期
     */
    public static Date addDays(Date date1, long days) {
        return addSeconds(date1, days * ONE_DAY_SECONDS);
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

    /**
     * @param date
     * @return
     */
    public static String getDateyyyyMMddHHmmString(Date date) {
        DateFormat df = getNewDateFormat(yyyyMMddHHmm);

        return df.format(date);
    }

    public static Date parseDate(String sDate, String dateFormatString) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        if ((sDate == null) || (sDate.length() < dateFormatString.length())) {
            throw new ParseException("length too little", 0);
        }

        return dateFormat.parse(sDate);
    }

    public static Date parseDateNoTime(String sDate) {
        if (sDate == null) {
            return null;
        }
        DateFormat dateFormat = new SimpleDateFormat(shortFormat);
        try {
            return dateFormat.parse(sDate);
        } catch (ParseException ex) {
            return null;
        }
    }

    /**
     * 取得两个日期的间隔小时数
     *
     * @param one
     * @param two
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

    public static String getWebDateString(Date date) {
        DateFormat dateFormat = getNewDateFormat(webFormat);

        return getDateString(date, dateFormat);
    }

    /**
     * 获取小时
     *
     * @param date
     * @return
     */
    public static String getHour(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        return hour < 10 ? "0" + hour : Integer.toString(hour);
    }

    /**
     * 返回当前日期的星级几
     *
     * @param dt 日期
     * @return 1..7, 对应:"7=周日,1=周一...6=周六"
     */
    public static int getIntWeekOfDate(Date dt) {
        Integer[] weekDays = {7, 1, 2, 3, 4, 5, 6};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
    }


    /**
     * 获取几号
     *
     * @param date
     * @return
     */
    public static String getDay(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(dayOnlyFormat);
        return getDateString(date, dateFormat);
    }

    /**
     * 获取月份
     *
     * @param date
     * @return
     */
    public static String getMonth(Date date) {
        DateFormat dateFormat = new SimpleDateFormat(monthOnlyFormat);
        return getDateString(date, dateFormat);
    }

    /**
     * 从时间戳获得小时数
     *
     * @param timestamp
     * @return
     */
    public static String getHourFromTimeStamp(long timestamp) {
        return getHour(new Date(timestamp));
    }

    /**
     * 获得指定前几天的日期字符串yyyymmdd
     *
     * @param days
     * @return
     */
    public static String getBeforeDayString(int days) {
        Date date = new Date(System.currentTimeMillis() - (ONE_DAY_MILL_SECONDS * days));
        DateFormat dateFormat = getNewDateFormat(shortFormat);

        return getDateString(date, dateFormat);
    }

    public static long getDiffMinutes(Date one, Date two) {
        return getDiffMinutes(one, two, false);
    }

    /**
     * 计算2个时间的差异分钟数，如果leftSecondsToMinutes为ture，且日期相差的秒数数不能被60整除(表示2个日期差，有X分Y秒) ， 则额外增加1分返回
     *
     * @param one
     * @param two
     * @param leftSecondsToMinute
     * @return
     */
    public static long getDiffMinutes(Date one, Date two, boolean leftSecondsToMinute) {
        Calendar sysDate = new GregorianCalendar();

        sysDate.setTime(one);

        Calendar failDate = new GregorianCalendar();

        failDate.setTime(two);
        long diffMinutes = (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) / (60 * 1000);
        if (leftSecondsToMinute && (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) % (60 * 1000) > 0) {
            diffMinutes += 1;
        }
        return diffMinutes;
    }

    /**
     * 获得当前的oracle时间
     *
     * @return
     */
    public static TIMESTAMP getCurrentOracleTimestamp() {
        return new oracle.sql.TIMESTAMP(new Timestamp(new Date().getTime()));
    }

    /**
     * 计算相差的天数
     *
     * @param one
     * @param two
     * @return �������
     */
    public static long getDiffDays(Date one, Date two) {
        Calendar sysDate = new GregorianCalendar();

        sysDate.setTime(one);

        Calendar failDate = new GregorianCalendar();

        failDate.setTime(two);
        return (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) / (24 * 60 * 60 * 1000);
    }

    /**
     * 计算相差的天数
     *
     * @param one
     * @param two
     * @param leftHoursToDay
     * @return
     */
    public static long getDiffDays(Date one, Date two, boolean leftHoursToDay) {
        Calendar sysDate = new GregorianCalendar();

        sysDate.setTime(one);

        Calendar failDate = new GregorianCalendar();

        failDate.setTime(two);
        long differDays = (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) / (24 * 60 * 60 * 1000);
        if (leftHoursToDay && (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) % (24 * 60 * 60 * 1000) > 0) {
            differDays += 1;
        }
        return differDays;
    }

    /**
     * 取得两个日期间隔秒数（日期1-日期2）
     *
     * @param one
     *            日期1
     * @param two
     *            日期2
     *
     * @return 间隔秒数
     */
    public static long getDiffSeconds(Date one, Date two) {
        Calendar sysDate = new GregorianCalendar();

        sysDate.setTime(one);

        Calendar failDate = new GregorianCalendar();

        failDate.setTime(two);
        return (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) / 1000;
    }

    public static void main(String[] args) {
        System.out.println(getDateyyyyMMddHHmmString(new Date()));
    }
}
