import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class XY {
        int x;
        int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int M, N;
    public static int[][] graph;
    public static int[] dX = {-1, 0, 0, 1};
    public static int[] dY = {0, 1, -1, 0};
    public static Queue<XY> q = new LinkedList<>();

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1) {
                    q.add(new XY(i, j));
                }
            }
        }
        BFS();
        System.out.print(calculate() - 1);
    }

    public static void BFS() {
        while (!q.isEmpty()) {
            XY now = q.poll();
            for (int i = 0; i < 4; i++) {
                XY next = new XY(now.x + dX[i], now.y + dY[i]);
                if (next.x >= 0 && next.x < N && next.y >= 0 && next.y < M) {
                    if (graph[next.x][next.y] == 0) {
                        graph[next.x][next.y] = graph[now.x][now.y] + 1;    //하나씩 더하면 결국 며칠째인지 알 수 있음
                        q.add(next);
                    }
                }
            }
        }
    }

    public static int calculate() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    return 0;
                }
                if (max < graph[i][j]) {
                    max = graph[i][j];
                }
            }
        }
        return max;
    }
}
