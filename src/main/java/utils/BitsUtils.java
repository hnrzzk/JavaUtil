package utils;

public class BitsUtils {
    public static int getLowerSafe(int number, int byteCount) {
        int baseNum = (int)Math.pow(2, byteCount) - 1;
        return number & baseNum;
    }

    public static int getHighSafe(int number, int byteCount) {
        return number >>> byteCount;
    }

    public static int getLowerSafe(float number, int byteCount) {
        int intBits = Float.floatToIntBits(number);
        int baseNum = (int)Math.pow(2, byteCount) - 1;
        return intBits & baseNum;
    }

    public static int getHighSafe(float number, int byteCount) {
        int intBits = Float.floatToIntBits(number);
        return intBits >>> byteCount;
    }

    public static long getLowerSafe(long number, int byteCount) {
        long baseNum = (long)Math.pow(2, byteCount) - 1;
        return number & baseNum;
    }

    public static long getHighSafe(long number, int byteCount) {
        return number >>> byteCount;
    }

    public static long getLowerSafe(double number, int byteCount) {
        long longBits = Double.doubleToLongBits(number);
        long baseNum = (long)Math.pow(2, byteCount) - 1;
        return longBits & baseNum;
    }

    public static long getHighSafe(double number, int byteCount) {
        long longBits = Double.doubleToLongBits(number);
        return longBits >>> byteCount;
    }
}
