import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class XY {
        int x;
        int y;
        int cnt;
        boolean canBreak;

        public XY(int x, int y, int cnt, boolean canBreak) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.canBreak = canBreak;
        }
    }

    public static int N, M;
    public static boolean[][] graph;
    public static boolean[][][] visited;
    public static int[] dX = {-1, 0, 0, 1};
    public static int[] dY = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new boolean[N][M];
        visited = new boolean[N][M][2]; //벽 부수고 도착, 벽 안부수고 도착

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == '0') {
                    graph[i][j] = true;
                }
            }
        }

        int min = BFS(new XY(0, 0, 1, true));
        System.out.print(min);
    }

    public static int BFS(XY start) {
        Queue<XY> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y][0] = true;
        visited[start.x][start.y][1] = true;
        while (!q.isEmpty()) {
            XY now = q.poll();
            if (now.x == N - 1 && now.y == M - 1) {
                return now.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dX[i];
                int nextY = now.y + dY[i];
                int nextCnt = now.cnt + 1;
                boolean nextCanBreak = now.canBreak;

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }
                if (graph[nextX][nextY]) {
                    if (nextCanBreak && !visited[nextX][nextY][0]) {
                        q.add(new XY(nextX, nextY, nextCnt, true));
                        visited[nextX][nextY][0] = true;
                    } else if (!nextCanBreak && !visited[nextX][nextY][1]) {
                        q.add(new XY(nextX, nextY, nextCnt, false));
                        visited[nextX][nextY][1] = true;
                    }
                } else {
                    if (nextCanBreak) {
                        q.add(new XY(nextX, nextY, nextCnt, false));
                        visited[nextX][nextY][1] = true;
                    }
                }
            }
        }
        return -1;
    }
}
