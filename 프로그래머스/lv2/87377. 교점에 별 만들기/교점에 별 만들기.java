import java.io.*;
import java.util.HashSet;
import java.util.Set;

class Solution {
    static class Point {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        // 객체 비교, 가독성 좋음
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Point)) {
                return false;
            }
            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        // 객체 비교, 객체로 부터 고유키를 뽑아낸다.(int), 대량비교 좋음, 가독성 나쁨
        @Override
        public int hashCode() {
            int result = (int) (x ^ (x >>> 32));
            result = 31 * result + (int) (y ^ (y >>> 32));
            return result;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private static Set<Point> sets = new HashSet<>();

    public static String[] solution(int[][] line) {

        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for (int i = 0; i < line.length - 1; i++) {
            double A = line[i][0];
            double B = line[i][1];
            double E = line[i][2];

            for (int j = i + 1; j < line.length; j++) {
                double C = line[j][0];
                double D = line[j][1];
                double F = line[j][2];

                if (A * D == B * C) {
                    continue;
                }
                double xCalc = (B * F - E * D) / (A * D - B * C);
                double yCalc = (E * C - A * F) / (A * D - B * C);

                long x = (long) xCalc;
                if (x != xCalc) {
                    continue;
                }
                long y = (long) yCalc;
                if (y != yCalc) {
                    continue;
                }
                sets.add(new Point(x, y));
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }
        }
        int yCnt = (int) (maxX - minX + 1);
        int xCnt = (int) (maxY - minY + 1);

        String[] answer = new String[xCnt];
        for (int i = xCnt - 1; i >= 0; i--) {
            answer[i] = "";
            for (int j = 0; j < yCnt; j++) {
                if (sets.contains(new Point(j + minX, maxY - i))) {
                    answer[i] += '*';
                } else {
                    answer[i] += '.';
                }
            }
        }
        return answer;
    }
}