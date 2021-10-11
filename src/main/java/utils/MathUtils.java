package utils;


public class MathUtils {
    public static class Point {
        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        private final double x;
        private final double y;

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        @Override
        public String toString() {
            return String.format("x:%s, y:%s", x, y);
        }
    }

    /**
     * 均分圆为n分
     * @param center 圆心坐标
     * @param radius 半径
     * @param count 均分次数
     */
    public static void bisectingCircle(Point center, double radius,  int count) {
        System.out.println("center:${center}, r:$r, count:$count==========");
        double radians = (2 * Math.PI / count);
        for (int i = 0; i < count; i++) {
            double x = center.x + radius * Math.sin(radians * i);
            double y = center.y + radius * Math.cos(radians * i);
            System.out.println(new Point(x, y));
        }
    }
}
