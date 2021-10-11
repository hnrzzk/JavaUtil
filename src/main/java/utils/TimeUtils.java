package utils;

import java.util.Date;
import java.text.ParseException;
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

    public static final String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String PATTERN_MM_DD = "MM-dd";
    public static final String PATTERN_YYYYMMDD = "yyyyMMdd";
    public static final String PATTERN_YYYYMM = "yyyyMM";
    public static final String PATTERN_FULL = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String TIME_MIN = " 00:00:00";
    public static final String TIME_MAX = " 23:59:59";

    private TimeUtils() {}

    private static class TimeUtilsInstance{
        private static final TimeUtils instance = new TimeUtils();
    }

    public static TimeUtils getInstance()
    {
        return TimeUtilsInstance.instance;
    }


    public boolean isLastTimeOfDay(Long now , Calendar calendar) {
        calendar.setTimeInMillis(now);
        return calendar.get(Calendar.HOUR_OF_DAY) == 23
                && calendar.get(Calendar.MINUTE) == 59;
    }

    public boolean isSameDay(Long time1 , Long time2, Calendar calendar) {
        calendar.setTimeInMillis(time1);
        int time1Year = calendar.get(Calendar.YEAR);
        int time1DayOfYear = calendar.get(Calendar.DAY_OF_YEAR);

        calendar.setTimeInMillis(time2);
        int time2Year = calendar.get(Calendar.YEAR);
        int time2DayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        return time1Year == time2Year && time1DayOfYear == time2DayOfYear;
    }

    public boolean isSameWeek(long date1, long date2, Calendar calendar)
    {
        calendar.setTimeInMillis(date1);
        int date1Year = calendar.get(Calendar.YEAR);
        int date1WeekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);

        calendar.setTimeInMillis(date2);
        int date2Year = calendar.get(Calendar.YEAR);
        int date2WeekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        return date1Year == date2Year && date1WeekOfYear == date2WeekOfYear;
    }

    public String getDateFormatString(Date date, String formatString)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(formatString);
        return sdf.format(date);
    }

    public Date getDateByString(String date, String formatString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(formatString);
        return sdf.parse(date);
    }
}
