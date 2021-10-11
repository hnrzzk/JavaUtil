package utils;

import org.junit.Test;

public class TestBitsUtils {
    @Test
    public void testLowHighBit() {
        testLowHighBit(Integer.MAX_VALUE, 16);
        testLowHighBit(Integer.MAX_VALUE, 0);
        testLowHighBit(Integer.MAX_VALUE, 1);

        testLowHighBit(Integer.MIN_VALUE, 16);
        testLowHighBit(Integer.MIN_VALUE, 0);
        testLowHighBit(Integer.MIN_VALUE, 1);


        testLowHighBit(0, 16);
        testLowHighBit(0, 1);
        testLowHighBit(0, 0);

        testLowHighBit(-1, 16);
        testLowHighBit(-1, 1);
        testLowHighBit(-1, 0);

        testLowHighBit(65535, 16);
        testLowHighBit(65535, 1);
        testLowHighBit(65535, 0);

        testLowHighBit(10000, 16);
        testLowHighBit(10000, 1);
        testLowHighBit(10000, 0);

        testLowHighBit(1024, 16);
        testLowHighBit(1024, 1);
        testLowHighBit(1024, 0);

        testLowHighBit(Long.MAX_VALUE, 32);
        testLowHighBit(Long.MAX_VALUE, 1);
        testLowHighBit(Long.MAX_VALUE, 0);

        testLowHighBit(Long.MIN_VALUE, 32);
        testLowHighBit(Long.MIN_VALUE, 1);
        testLowHighBit(Long.MIN_VALUE, 0);

        testLowHighBit(Float.MAX_VALUE, 32);
        testLowHighBit(Float.MAX_VALUE, 1);
        testLowHighBit(Float.MAX_VALUE, 0);

        testLowHighBit((float) 10000.001, 16);
        testLowHighBit((float) 10000.001, 1);
        testLowHighBit((float) 10000.001, 0);

        testLowHighBit(Float.MIN_VALUE, 32);
        testLowHighBit(Float.MIN_VALUE, 1);
        testLowHighBit(Float.MIN_VALUE, 0);

        testLowHighBit(Double.MAX_VALUE, 32);
        testLowHighBit(Double.MAX_VALUE, 1);
        testLowHighBit(Double.MAX_VALUE, 0);

        testLowHighBit(1000000.001, 16);
        testLowHighBit(1000000.001, 1);
        testLowHighBit(1000000.001, 0);

        testLowHighBit(Long.MIN_VALUE, 32);
        testLowHighBit(Long.MIN_VALUE, 1);
        testLowHighBit(Long.MIN_VALUE, 0);
    }

    private void testLowHighBit(int number, int bitCount) {
        System.out.println("===========Int=============");
        System.out.println("number：" + number + " bitCount:" + bitCount);
        System.out.println("HexString：" + Integer.toHexString(number));
        System.out.println("LowHexString：" + Integer.toHexString(BitsUtils.getLower(number, bitCount)));
        System.out.println("HighHexString：" + Integer.toHexString(BitsUtils.getHigh(number, bitCount)));
    }
    private void testLowHighBit(float number, int bitCount) {
        System.out.println("===========Float=============");
        System.out.println("number：" + number + " bitCount:" + bitCount);
        System.out.println("HexString：" + Integer.toHexString(Float.floatToIntBits(number)));
        System.out.println("LowHexString：" + Integer.toHexString(BitsUtils.getLower(number, bitCount)));
        System.out.println("HighHexString：" + Integer.toHexString(BitsUtils.getHigh(number, bitCount)));
    }
    private void testLowHighBit(long number, int bitCount) {
        System.out.println("===========Long=============");
        System.out.println("number：" + number + " bitCount:" + bitCount);
        System.out.println("HexString：" + Long.toHexString(number));
        System.out.println("LowHexString：" + Long.toHexString(BitsUtils.getLower(number, bitCount)));
        System.out.println("HighHexString：" + Long.toHexString(BitsUtils.getHigh(number, bitCount)));
    }
    private void testLowHighBit(double number, int bitCount) {
        System.out.println("===========Double=============");
        System.out.println("number：" + number + " bitCount:" + bitCount);
        System.out.println("HexString：" + Long.toHexString(Double.doubleToLongBits(number)));
        System.out.println("LowHexString：" + Long.toHexString(BitsUtils.getLower(number, bitCount)));
        System.out.println("HighHexString：" + Long.toHexString(BitsUtils.getHigh(number, bitCount)));
    }
}
