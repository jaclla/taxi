package com.logic.taxi.utils;

import cn.hutool.core.util.StrUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author sm
 * @since 2018/4/13
 */
public class DateUtils {
    private final static int[] DAY_ARR = new int[]{20, 19, 21, 20, 21, 22, 23,
            23, 23, 24, 23, 22};
    public final static String[] CONSTELLATION_ARR = new String[]{"摩羯座",
            "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座",
            "天蝎座", "射手座", "摩羯座"};
    public final static String[] YEARS = new String[]{"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊",
            "猴", "鸡", "狗", "猪"};
    public static final DateTimeFormatter yyyyMMdd = DateTimeFormatter.ofPattern("yyyy年MM月dd日");

    public static final DateTimeFormatter yyyyMM = DateTimeFormatter.ofPattern("yyyy年MM月");

    public static final DateTimeFormatter yyyy_MM = DateTimeFormatter.ofPattern("yyyy-MM");

    /**
     * 获取某月的最大天数
     *
     * @throws
     * @Title:getLastDayOfMonth
     * @Description:
     * @param:@param year
     * @param:@param month
     * @param:@return
     * @return:String
     */
    public static int getMaxDayOfMonth(Integer year, Integer month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        if (year != null && year > 0) {
            cal.set(Calendar.YEAR, year);
        }
        //设置月份
        if (month != null && month > 0) {
            cal.set(Calendar.MONTH, month - 1);
        }
        //获取某月最大天数
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }


    /**
     * 获取某月的最后一天
     *
     * @throws
     * @Title:getLastDayOfMonth
     * @Description:
     * @param:@param year
     * @param:@param month
     * @param:@return
     * @return:String
     */
    public static String getLastDayOfMonth(Integer year, Integer month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        if (year != null && year > 0) {
            cal.set(Calendar.YEAR, year);
        }
        //设置月份
        if (month != null && month > 0) {
            cal.set(Calendar.MONTH, month - 1);
        }
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(cal.getTime());
    }

    /**
     * 通过生日计算星座
     *
     * @param month
     * @param day
     * @return
     */
    public static String getConstellation(int month, int day) {
        return day < DAY_ARR[month - 1] ? CONSTELLATION_ARR[month - 1]
                : CONSTELLATION_ARR[month];
    }

    /**
     * 通过生日计算星座
     *
     * @param month
     * @param day
     * @return
     */
    public static Integer getConstellationInt(int month, int day) {
        return day < DAY_ARR[month - 1] ? month - 1
                : month;
    }

    /**
     * 通过生日计算属相
     *
     * @param year
     * @return
     */
    public static String getZodiac(int year) {
        if (year < 1900) {
            return "未知";
        }
        int start = 1900;
        return YEARS[(year - start) % YEARS.length];
    }

    /**
     * 通过生日计算属相
     *
     * @param year
     * @return
     */
    public static Integer getZodiacInt(int year) {
        if (year < 1900) {
            return null;
        }
        int start = 1900;
        return (year - start) % YEARS.length;
    }

    /**
     * 通过日期计算年月日
     *
     * @param date
     * @return
     */
    public static String getYearMonthDay(LocalDate date) {
        if (date != null) {
            Period period = Period.between(date, LocalDate.now());
            return period.getYears() + "年" + period.getMonths() + "月" + period.getDays() + "天";
        }
        return null;
    }

    /**
     * 获取两个日期之间的所有日期(按月)
     *
     * @param startTime 开始日期
     * @param endTime   结束日期
     * @return
     */
    public static List<String> getDays(String startTime, String endTime) {

        // 返回的日期集合
        List<String> days = new ArrayList<>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.MONTH, +1);// 日期加1(包含结束)
            while (tempStart.before(tempEnd)) {
                days.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.MONTH, 1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    /**
     * 获取两个年份之间的所有年
     *
     * @param startTime 开始年份
     * @param endTime   结束年份
     * @return
     */
    public static List<String> getYears(String startTime, String endTime) {

        // 返回的日期集合
        List<String> years = new ArrayList<>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.YEAR, +1);// 日期加1(包含结束)
            while (tempStart.before(tempEnd)) {
                years.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.YEAR, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return years;
    }

    /**
     * 获取两个年份加季度之间的所有日期
     *
     * @param startTime 开始年份-季度
     * @param endTime   结束年份-季度
     * @return
     */
    public static List<String> getQuarters(String startTime, String endTime) {
        String[] startSplit = startTime.split("-");
        if ("1".equals(startSplit[1])) {
            startTime = startSplit[0] + "-01";
        } else if ("2".equals(startSplit[1])) {
            startTime = startSplit[0] + "-04";
        } else if ("3".equals(startSplit[1])) {
            startTime = startSplit[0] + "-07";
        } else if ("4".equals(startSplit[1])) {
            startTime = startSplit[0] + "-10";
        }

        String[] endSplit = endTime.split("-");
        if ("1".equals(endSplit[1])) {
            endTime = endSplit[0] + "-03";
        } else if ("2".equals(endSplit[1])) {
            endTime = endSplit[0] + "-06";
        } else if ("3".equals(endSplit[1])) {
            endTime = endSplit[0] + "-09";
        } else if ("4".equals(endSplit[1])) {
            endTime = endSplit[0] + "-12";
        }

        // 返回的日期集合
        List<String> days = new ArrayList<>();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);

            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);

            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.MONTH, +1);// 日期加1(包含结束)
            while (tempStart.before(tempEnd)) {
                days.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.MONTH, 1);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    /**
     * 获得最近日期的指定多个月份
     *
     * @param i 获得最近几个月份
     * @return
     */
    public static List<String> getLastMonths(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -i);
        Date m = c.getTime();
        return getDays(sdf.format(m), sdf.format(new Date()));
    }

    /**
     * 获得最近日期的指定多个月份
     *
     * @param i 获得最近几个月份
     * @return
     */
    @SuppressWarnings("deprecation")
    public static List<String> getLastMonths(String date, int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        if (StrUtil.isNotEmpty(date)) {
            c.setTime(new Date(Date.parse(date.replace("-", "/") + "/1")));
            c.add(Calendar.MONTH, -i);
            Date m = c.getTime();
            return getDays(sdf.format(m), sdf.format(Date.parse(date.replace("-", "/") + "/1")));

        } else {
            c.setTime(new Date());
            c.add(Calendar.MONTH, -i);
            Date m = c.getTime();
            return getDays(sdf.format(m), sdf.format(new Date()));
        }
    }

    /**
     * 获得指定日期的上个月的日期
     *
     * @param date
     * @return
     */
    public static String getLastMonth(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date parse = sdf.parse(date);
        Calendar c = Calendar.getInstance();
        c.setTime(parse);
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        return sdf.format(m);
    }

    /**
     * 获得指定日期的下个月的日期
     *
     * @param date
     * @return
     */
    public static String getNextMonth(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date parse = sdf.parse(date);
        Calendar c = Calendar.getInstance();
        c.setTime(parse);
        c.add(Calendar.MONTH, +1);
        Date m = c.getTime();
        return sdf.format(m);
    }

    /**
     * 获得指定日期的上个年份的日期
     *
     * @param date
     * @return
     */
    public static String getLastYear(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date parse = sdf.parse(date);
        Calendar c = Calendar.getInstance();
        c.setTime(parse);
        c.add(Calendar.YEAR, -1);
        Date m = c.getTime();
        return sdf.format(m);
    }

    /**
     * between
     *
     * @param startTime
     * @param endTime
     * @return
     */
    public static Boolean between(LocalDate now, LocalDate startTime, LocalDate endTime) {
        return (now.isAfter(startTime) && now.isBefore(endTime)) || startTime.equals(now) || endTime.equals(now);
    }
}
