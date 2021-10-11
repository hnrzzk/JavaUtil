package utils;

import org.junit.Test;

public class TestBitsUtils {
    @Test
    public void testLowHighBit() {
        testLowHighBit(Long.MAX_VALUE, 32);
        System.out.println("============");
        testLowHighBit(Long.MIN_VALUE, 32);
        System.out.println("============");
        testLowHighBit(0, 16);
        System.out.println("============");
        testLowHighBit(-1, 16);
        System.out.println("============");
        testLowHighBit(10000, 16);
        System.out.println("============");
        testLowHighBit(1024, 16);
        System.out.println("============");
        testLowHighBit(Integer.MAX_VALUE, 16);
        System.out.println("============");
        testLowHighBit(Integer.MIN_VALUE, 16);
        System.out.println("============");
        testLowHighBit(65535, 16);
    }

    private void testLowHighBit(int number, int bitCount) {
        System.out.println("number：" + number);
        System.out.println("HexString：" + Integer.toHexString(number));
        System.out.println("LowHexString：" + Integer.toHexString(BitsUtils.getLowerSafe(number, bitCount)));
        System.out.println("HighHexString：" + Integer.toHexString(BitsUtils.getHighSafe(number, bitCount)));
    }
    private void testLowHighBit(float number, int bitCount) {
        System.out.println("number：" + number);
        System.out.println("HexString：" + Float.toHexString(number));
        System.out.println("LowHexString：" + Float.toHexString(BitsUtils.getLowerSafe(number, bitCount)));
        System.out.println("HighHexString：" + Float.toHexString(BitsUtils.getHighSafe(number, bitCount)));
    }
    private void testLowHighBit(long number, int bitCount) {
        System.out.println("number：" + number);
        System.out.println("HexString：" + Long.toHexString(number));
        System.out.println("LowHexString：" + Long.toHexString(BitsUtils.getLowerSafe(number, bitCount)));
        System.out.println("HighHexString：" + Long.toHexString(BitsUtils.getHighSafe(number, bitCount)));
    }
    private void testLowHighBit(double number, int bitCount) {
        System.out.println("number：" + number);
        System.out.println("HexString：" + Double.toHexString(number));
        System.out.println("LowHexString：" + Double.toHexString(BitsUtils.getLowerSafe(number, bitCount)));
        System.out.println("HighHexString：" + Double.toHexString(BitsUtils.getHighSafe(number, bitCount)));
    }
}
