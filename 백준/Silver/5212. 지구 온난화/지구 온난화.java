import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int R;
    private static int C;
    private static boolean[][] isLand;
    private static boolean[][] newMap;
    private static final int[] dX = {-1, 0, 0, 1};
    private static final int[] dY = {0, -1, 1, 0};
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        isLand = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                if (input.charAt(j) == 'X') {
                    isLand[i][j] = true;
                }
            }
        }
        deepCopy(isLand);
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (isLand[i][j]) {
                    update(new Point(i, j));
                }
            }
        }
        updateMap();
        System.out.println(sb);
    }

    private static void deepCopy(boolean[][] k) {
        newMap = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            System.arraycopy(k[i], 0, newMap[i], 0, C);
        }
    }

    private static void update(Point now) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = now.x + dX[i];
            int nextY = now.y + dY[i];
            if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) {
                cnt++;
                continue;
            }
            if (!isLand[nextX][nextY]) {
                cnt++;
            }
        }
        if (cnt >= 3) {
            newMap[now.x][now.y] = false;
        }
    }

    private static void updateMap() {
        int startR = checkRStart();
        int startC = checkCStart();
        int endR = checkREnd();
        int endC = checkCEnd();

        for (int i = startR; i <= endR; i++) {
            for (int j = startC; j <= endC; j++) {
                if (newMap[i][j]) {
                    sb.append("X");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }
    }

    private static int checkRStart() {
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            boolean canEraseLine = true;
            for (int j = 0; j < C; j++) {
                if (newMap[i][j]) {
                    canEraseLine = false;
                    break;
                }
            }
            if (canEraseLine) {
                cnt++;
            } else {
                return cnt;
            }
        }
        return cnt;
    }

    private static int checkCStart() {
        int cnt = 0;
        for (int i = 0; i < C; i++) {
            boolean canEraseLine = true;
            for (int j = 0; j < R; j++) {
                if (newMap[j][i]) {
                    canEraseLine = false;
                    break;
                }
            }
            if (canEraseLine) {
                cnt++;
            } else {
                return cnt;
            }
        }
        return cnt;
    }

    private static int checkREnd() {
        int cnt = 0;
        for (int i = R - 1; i >= 0; i--) {
            boolean canEraseLine = true;
            for (int j = 0; j < C; j++) {
                if (newMap[i][j]) {
                    canEraseLine = false;
                    break;
                }
            }
            if (canEraseLine) {
                cnt++;
            } else {
                return R - cnt - 1;
            }
        }
        return R - cnt - 1;
    }

    private static int checkCEnd() {
        int cnt = 0;
        for (int i = C - 1; i >= 0; i--) {
            boolean canEraseLine = true;
            for (int j = 0; j < R; j++) {
                if (newMap[j][i]) {
                    canEraseLine = false;
                    break;
                }
            }
            if (canEraseLine) {
                cnt++;
            } else {
                return C - cnt - 1;
            }
        }
        return C - cnt - 1;
    }
}