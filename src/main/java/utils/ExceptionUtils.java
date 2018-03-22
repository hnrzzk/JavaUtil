package utils;

/**
 * 异常处理工具（单例, 非线程安全）
 * Created by zhangkai on 2017/9/18.
 */
public class ExceptionUtils {

    private ExceptionUtils(){}

    private static class ExceptionUtilsHandle{
        private static final ExceptionUtils SingleInstance = new ExceptionUtils();
    }

    public static ExceptionUtils getInstance()
    {
        return ExceptionUtilsHandle.SingleInstance;
    }

    /**
     * 获取异常的调用栈
     * @param e 异常实例
     * @return 调用栈字符串
     */
    public String getExceptionStackTrace(Exception e) {
        StringBuffer result = new StringBuffer();

        result.append(e);

        StackTraceElement[] trace = e.getStackTrace();
        for ( StackTraceElement traceElement : trace )
        {
            result.append("\n\tat " + traceElement);
        }

        return result.toString();

    }

}
