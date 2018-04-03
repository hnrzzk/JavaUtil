package utils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangkai
 * @date 2017-9-21 15:20
 */
public class DateUtils {
    public static final long WEEK_TOTAL_MILLISECOND	=   7L * 24L * 60L * 60L * 1000L;
    public static final long DAY_TOTAL_MILLISECOND	=   24L * 60L * 60L * 1000L;
    public static final long HOUR_TOTAL_MILLISECOND =   60L * 60L * 1000L;
    public static final long MINUTE_TOTAL_MILLISECOND = 60L * 1000L;
    public static final long SECOND_TOTAL_MILLISECOND = 1000L;

    public static final String PATTERN_DAY = "yyyy-MM-dd";
    public static final String PATTERN_MONRH_DAY = "MM-dd";
    public static final String PATTERN_YYYYMMDD = "yyyyMMdd";
    public static final String PATTERN_YYYYMM = "yyyyMM";
    public static final String PATTERN_FULL = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String MINUTE_MIN = " 00:00:00";
    public static final String MINUTE_MAX = " 23:59:59";

    private static Map<String, ThreadLocal<SimpleDateFormat>> threadLocalMap = new ConcurrentHashMap();
    private static SimpleDateFormat osdf = new SimpleDateFormat( PATTERN_FULL );

    private DateUtils() {
    }

    private static class DateUtilsHandle{
        private static final DateUtils INSTANCE = new DateUtils();
    }

    public static DateUtils getInstance() {
        return DateUtilsHandle.INSTANCE;
    }

    public SimpleDateFormat getSimpleDateFormat(String pattern) {
        ThreadLocal<SimpleDateFormat> threadLocal = (ThreadLocal)threadLocalMap.get(pattern);
        if(threadLocal == null) {
            threadLocal = new ThreadLocal();
            threadLocalMap.put(pattern, threadLocal);
        }

        SimpleDateFormat sdf = (SimpleDateFormat)threadLocal.get();
        if(sdf == null) {
            sdf = new SimpleDateFormat(pattern);
            threadLocal.set(sdf);
        }

        return sdf;
    }

    public  String formatDateWrong(Date date, String pattern) {
        return date != null?osdf.format(date):"";
    }

    public  String formatDateMan(Date date, String pattern) {
        if(date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.format(date);
        } else {
            return "";
        }
    }

    public String formatDate(Date date) {
        SimpleDateFormat sdf = getSimpleDateFormat(PATTERN_DAY);
        return date != null?sdf.format(date):sdf.format(parseDate("1970-01-01", PATTERN_DAY));
    }

    public String formatDateYMDHMS(Date date) {
        SimpleDateFormat sdf = getSimpleDateFormat(PATTERN_FULL);
        return date != null?sdf.format(date):sdf.format(parseDate("1970-01-01", PATTERN_DAY));
    }

    public String formatDate(Date date, String pattern) {
        if(date != null) {
            SimpleDateFormat sdf = getSimpleDateFormat(pattern);
            return sdf.format(date);
        } else {
            return "";
        }
    }

    public String formatTime(Date date) {
        return date != null?formatDate(date, PATTERN_FULL):"";
    }

    public Date parseDate(String dateStr, String pattern) {

        if (System.currentTimeMillis() < 100)
        {

        }
        try {
            SimpleDateFormat sdf = getSimpleDateFormat(pattern);
            return sdf.parse(dateStr);
        } catch (Exception var3) {
            return parseDate("1970-01-01", PATTERN_DAY);
        }
    }

    public long between(Date start, Date end, TimeUnit unit) {
        if(start != null && end != null && unit != null) {
            long duration = end.getTime() - start.getTime();
            return unit.convert(duration, TimeUnit.MILLISECONDS);
        } else {
            return 0L;
        }
    }

    public long betweenSeconds(Date startDate, Date endDate) {
        return Math.abs((startDate.getTime() - endDate.getTime()) / 1000L);
    }

    public long betweenMinutes(Date startDate, Date endDate) {
        long diffSeconds = betweenSeconds(startDate, endDate);
        return diffSeconds / 60L;
    }

    public long betweenDay(Date startDate, Date endDate) {
        long between = Math.abs((startDate.getTime() - endDate.getTime()) / 1000L);
        long day = between / 60L / 60L / 24L;
        return (long)Math.floor((double)day);
    }

    public boolean isBetween(Date date, Date start, Date end) {
        return date.getTime() > start.getTime() && date.getTime() < end.getTime();
    }

    public Date getFirstOfADay(String date) throws Exception {
        return getFirstOfADay(parseDate(date, PATTERN_DAY));
    }

    public Date getEndOfADay(String date) throws Exception {
        return getEndOfADay(parseDate(date, PATTERN_DAY));
    }

    public Date getFirstOfADay(Date date) throws Exception {
        SimpleDateFormat sdf = getSimpleDateFormat(PATTERN_DAY);
        return getSimpleDateFormat(PATTERN_FULL).parse(sdf.format(date) + MINUTE_MIN);
    }

    public Date getEndOfADay(Date date) throws Exception {
        SimpleDateFormat sdf = getSimpleDateFormat(PATTERN_DAY);
        return getSimpleDateFormat(PATTERN_FULL).parse(sdf.format(date) + MINUTE_MAX);
    }

    public Date getFirstOfAWeek(Date date) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(7, 2);
        return getFirstOfADay(calendar.getTime());
    }

    public Date getEndOfAWeek(Date date) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(7, 1);
        calendar.add(5, 7);
        return getEndOfADay(calendar.getTime());
    }

    public Date getFirstOfAMonth(Date date) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, 1);
        return getFirstOfADay(calendar.getTime());
    }

    public Date getEndOfAMonth(Date date) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, 1);
        calendar.roll(5, -1);
        return getEndOfADay(calendar.getTime());
    }

    public Date getFirstOfLastMonth(Date date) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2, -1);
        return getFirstOfAMonth(calendar.getTime());
    }

    public Date getEndOfLastMonth(Date date) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2, -1);
        return getEndOfAMonth(calendar.getTime());
    }

    public String getQuarterName(Date date, int changeNum) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2, changeNum * 3);
        return getQuarterName(calendar.getTime());
    }

    public String getQuarterName(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(1);
        int month = calendar.get(2);
        switch(month) {
            case 0:
            case 1:
            case 2:
                return year + " 第一季度";
            case 3:
            case 4:
            case 5:
                return year + " 第二季度";
            case 6:
            case 7:
            case 8:
                return year + " 第三季度";
            case 9:
            case 10:
            case 11:
                return year + " 第四季度";
            default:
                return year + "";
        }
    }

    public int dateSub(Date date1, Date date2) {
        return (int)Math.ceil((double)(date1.getTime() - date2.getTime()) / 8.64E7D);
    }

    public static Date getDateByAddDays(Date date, int days) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.add(5, days);
        return calender.getTime();
    }

    public Date getDateByAddDays(int days) {
        Date date = new Date();
        return getDateByAddDays(date, days);
    }

    public String getDateStrByAddDays(Date date, int days) {
        Date newDate = getDateByAddDays(date, days);
        return formatDate(newDate);
    }

    public String getDateStrByAddDays(int days) {
        Date newDate = getDateByAddDays(days);
        return formatDate(newDate);
    }

    public boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public List<String> getDateStrs(Date startDate, Date endDate, String pattern) {
        List<String> dates = new ArrayList();
        int i = 0;

        while(true) {
            Date date = getDateByAddDays(startDate, i);
            if(date.compareTo(endDate) > 0) {
                return dates;
            }

            dates.add(formatDate(date, pattern));
            ++i;
        }
    }

    public Long getMonthNo(Date date) {
        String monthNoStr = formatDate(date, "MM");
        Long monthNo = Long.valueOf(monthNoStr);
        return monthNo;
    }

    public Long getYearNo(Date date) {
        String yearNoStr = formatDate(date, "YYYY");
        Long yearNo = Long.valueOf(yearNoStr);
        return yearNo;
    }

    public Long getDayNo(Date date) {
        String dayNoStr = formatDate(date, "dd");
        Long dayNo = Long.valueOf(dayNoStr);
        return dayNo;
    }

    public Date parseUTCDate(String utcTime) {
        utcTime = utcTime.replace("Z", " UTC");
        return parseDate(utcTime, "yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    }

}
