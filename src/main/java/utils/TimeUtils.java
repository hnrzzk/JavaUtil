package utils;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 时间工具类
 * Created by zhangkai on 2018/4/3.
 */
public class TimeUtils {
    public static final long SECOND_TOTAL_MILLISECOND = 1000L;
    public static final long MINUTE_TOTAL_MILLISECOND = 60L * SECOND_TOTAL_MILLISECOND;
    public static final long HOUR_TOTAL_MILLISECOND =   60L * MINUTE_TOTAL_MILLISECOND;
    public static final long DAY_TOTAL_MILLISECOND	=   24L * HOUR_TOTAL_MILLISECOND;
    public static final long WEEK_TOTAL_MILLISECOND	=   7L * DAY_TOTAL_MILLISECOND;

    public static final String PATTERN_DAY = "yyyy-MM-dd";
    public static final String PATTERN_MONRH_DAY = "MM-dd";
    public static final String PATTERN_YYYYMMDD = "yyyyMMdd";
    public static final String PATTERN_YYYYMM = "yyyyMM";
    public static final String PATTERN_FULL = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String MINUTE_MIN = " 00:00:00";
    public static final String MINUTE_MAX = " 23:59:59";

    private TimeUtils() {}

    private static class TimeUtilsInstance{
        private static final TimeUtils instance = new TimeUtils();
    }

    public static TimeUtils getInstance()
    {
        return TimeUtilsInstance.instance;
    }


    public boolean isSameDay(long date1, long date2)
    {
        return date1 / DAY_TOTAL_MILLISECOND == date2 /DAY_TOTAL_MILLISECOND;
    }
    public boolean isSameDay(Date date1, Date date2)
    {
        return isSameDay(date1.getTime(), date2.getTime());
    }
    public boolean isSampDay(Calendar date1, Calendar date2)
    {
        return isSameDay(date1.getTimeInMillis(), date2.getTimeInMillis());
    }

    public boolean isSameWeek(long date1, long date2)
    {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(date2);
        return isSameWeek(calendar1, calendar2);
    }
    public boolean isSameWeek(Date date1, Date date2)
    {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date2);
        return isSameWeek(calendar1, calendar2);
    }
    public boolean isSameWeek(Calendar date1, Calendar date2)
    {
        int date1Year = date1.get(Calendar.YEAR);
        int date1WeekOfYear = date1.get(Calendar.WEEK_OF_YEAR);
        int date2Year = date2.get(Calendar.YEAR);
        int date2WeekOfYear = date2.get(Calendar.WEEK_OF_YEAR);
        return date1Year == date2Year && date1WeekOfYear == date2WeekOfYear;
    }

    public String getDataFormatString(Date date, String formatString)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(formatString);
        return sdf.format(date);
    }

    private static Calendar getCalendarInstance()
    {
        Calendar calendar =  Calendar.getInstance();
        return calendar;
    }
}
