import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class XY {
        int x;
        int y;
        int direction;
        int cnt;

        public XY(int x, int y, int direction, int cnt) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cnt = cnt;
        }
    }

    public static boolean[][] graph;
    public static boolean[][][] visited;
    public static int[] dX = {0, 0, 0, 1, -1};
    public static int[] dY = {0, 1, -1, 0, 0};
    public static int N, M;

//  4
//2   1
//  3

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new boolean[N][M];
        visited = new boolean[N][M][5];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                if (input[j].equals("0")) {
                    graph[i][j] = true;
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken()) - 1;
        int startY = Integer.parseInt(st.nextToken()) - 1;
        int startDirection = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int endX = Integer.parseInt(st.nextToken()) - 1;
        int endY = Integer.parseInt(st.nextToken()) - 1;
        int endDirection = Integer.parseInt(st.nextToken());

        int min = BFS(new XY(startX, startY, startDirection, 0), new XY(endX, endY, endDirection, 0));
        System.out.print(min);
    }

    public static int BFS(XY start, XY end) {
        Queue<XY> q = new LinkedList<>();
        int cnt = Integer.MAX_VALUE;
        q.add(start);
        visited[start.x][start.y][start.direction] = true;

        while (!q.isEmpty()) {
            XY now = q.poll();
            if (now.direction == end.direction && now.x == end.x && now.y == end.y) {
                cnt = Math.min(cnt, now.cnt);
            }
            int nowD = now.direction;
            for (int i = 1; i <= 3; i++) {
                int nextX = now.x + dX[now.direction] * i;
                int nextY = now.y + dY[now.direction] * i;
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    break;
                }
                if (!graph[nextX][nextY])
                    break;
                if (!visited[nextX][nextY][nowD]) {
                    q.add(new XY(nextX, nextY, nowD, now.cnt + 1));
                    visited[nextX][nextY][nowD] = true;

                }
            }
            for (int i = 1; i <= 4; i++) {
                int directionDiff = calculate(now.direction, i);
                if (!visited[now.x][now.y][i]) {
                    q.add(new XY(now.x, now.y, i, now.cnt + directionDiff));
                    visited[now.x][now.y][i] = true;
                }
            }
        }
        return cnt;
    }

    public static int calculate(int a, int b) {
        if (a * b == 2 || a * b == 12) {
            return 2;
        }
        return 1;
    }
}


//  4
//1   2
//  3

