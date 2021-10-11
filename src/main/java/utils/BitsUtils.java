package utils;

public class BitsUtils {
    public final static int INT_MAX_BITS_COUNT = 32;
    public final static int LONG_MAX_BITS_COUNT = 64;
    public final static int FLOAT_MAX_BITS_COUNT = 32;
    public final static int DOUBLE_MAX_BITS_COUNT = 64;

    public static int getLower(int number, int byteCount) {
        int baseNum = (int)Math.pow(2, byteCount) - 1;
        return number & baseNum;
    }

    /**
     * 获取高n位。
     * 包括符号位，例如：获取高1位则是符号位
     * @param number 目标数字
     * @param byteCount 要截取多少位
     * @return 截取@byteCount位后的结果
     */
    public static int getHigh(int number, int byteCount) {
        return number >>> (INT_MAX_BITS_COUNT - byteCount);
    }

    public static int getLower(float number, int byteCount) {
        int intBits = Float.floatToIntBits(number);
        int baseNum = (int)Math.pow(2, byteCount) - 1;
        return intBits & baseNum;
    }

    /**
     * 获取高n位。
     * 包括符号位，例如：获取高1位则是符号位
     * @param number 目标数字
     * @param byteCount 要截取多少位
     * @return 截取@byteCount位后的结果
     */
    public static int getHigh(float number, int byteCount) {
        int intBits = Float.floatToIntBits(number);
        return intBits >>> (FLOAT_MAX_BITS_COUNT - byteCount);
    }

    public static long getLower(long number, int byteCount) {
        long baseNum = (long)Math.pow(2, byteCount) - 1;
        return number & baseNum;
    }

    /**
     * 获取高n位。
     * 包括符号位，例如：获取高1位则是符号位
     * @param number 目标数字
     * @param byteCount 要截取多少位
     * @return 截取@byteCount位后的结果
     */
    public static long getHigh(long number, int byteCount) {
        return number >>> (LONG_MAX_BITS_COUNT - byteCount);
    }

    public static long getLower(double number, int byteCount) {
        long longBits = Double.doubleToLongBits(number);
        long baseNum = (long)Math.pow(2, byteCount) - 1;
        return longBits & baseNum;
    }

    /**
     * 获取高n位。
     * 包括符号位，例如：获取高1位则是符号位
     * @param number 目标数字
     * @param byteCount 要截取多少位
     * @return 截取@byteCount位后的结果
     */
    public static long getHigh(double number, int byteCount) {
        long longBits = Double.doubleToLongBits(number);
        return longBits >>> (DOUBLE_MAX_BITS_COUNT - byteCount);
    }
}
