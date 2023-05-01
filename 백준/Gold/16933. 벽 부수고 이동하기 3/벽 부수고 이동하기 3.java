import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class XY {
        int x;
        int y;
        int cnt;
        int breakCnt;

        public XY(int x, int y, int cnt, int breakCnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.breakCnt = breakCnt;
        }
    }

    public static int N, M, K;
    public static boolean[][] graph;
    public static boolean[][][] visited;
    public static int[] dX = {-1, 0, 0, 1};
    public static int[] dY = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new boolean[N][M];
        visited = new boolean[N][M][K + 1]; //벽 부수고 도착, 벽 안부수고 도착

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                if (input.charAt(j) == '0') {
                    graph[i][j] = true;
                }
            }
        }

        int min = BFS(new XY(0, 0, 1, 0));
        System.out.print(min);
    }

    public static int BFS(XY start) {
        PriorityQueue<XY> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cnt));
        q.add(start);
        for (int i = 0; i <= K; i++) {
            visited[start.x][start.y][K] = true;
        }

        while (!q.isEmpty()) {
            XY now = q.poll();
            if (now.x == N - 1 && now.y == M - 1) {
                return now.cnt;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dX[i];
                int nextY = now.y + dY[i];
                int nextCnt = now.cnt + 1;

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                    continue;
                }
                //No 벽
                if (graph[nextX][nextY]) {
                    if (!visited[nextX][nextY][now.breakCnt]) {
                        q.add(new XY(nextX, nextY, nextCnt, now.breakCnt));
                        visited[nextX][nextY][now.breakCnt] = true;
                    }
                } else {
                    if (now.breakCnt == K) {
                        continue;
                    }
                    if (nextCnt % 2 == 1) {
                        nextCnt++;
                    }
                    if (!visited[nextX][nextY][now.breakCnt + 1]) {
                        q.add(new XY(nextX, nextY, nextCnt, now.breakCnt + 1));
                        visited[nextX][nextY][now.breakCnt + 1] = true;
                    }
                }
            }
        }
        return -1;
    }
}
