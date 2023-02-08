import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class XY {
        int x;
        int y;
        int cnt;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public XY(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static int N;
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[] dX = {-1, 0, 0, 1};
    public static int[] dY = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int level = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1) {
                    level++;
                    initGraph(level, new XY(i, j));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] != 0) {
                    min = Math.min(min, BFS(new XY(i, j)));
                    visited = new boolean[N][N];
                }
            }
        }
        System.out.print(min);
    }

    public static void initGraph(int level, XY start) {
        Queue<XY> q = new LinkedList<>();
        q.add(start);
        graph[start.x][start.y] = level;
        while (!q.isEmpty()) {
            XY now = q.poll();
            for (int i = 0; i < 4; i++) {
                XY next = new XY(now.x + dX[i], now.y + dY[i]);
                if (next.x >= 0 && next.x < N && next.y >= 0 && next.y < N) {
                    if (graph[next.x][next.y] == 1) {
                        graph[next.x][next.y] = level;
                        q.add(next);
                    }
                }
            }
        }
    }

    public static int BFS(XY start) {
        Queue<XY> q = new LinkedList<>();
        q.add(start);
        int level = graph[start.x][start.y];
        visited[start.x][start.y] = true;
        while (!q.isEmpty()) {
            XY now = q.poll();
            for (int i = 0; i < 4; i++) {
                XY next = new XY(now.x + dX[i], now.y + dY[i]);
                if (next.x >= 0 && next.x < N && next.y >= 0 && next.y < N) {
                    if (!visited[next.x][next.y]) {
                        if (graph[next.x][next.y] == 0) {
                            q.add(new XY(next.x, next.y, now.cnt + 1));
                        } else if (graph[next.x][next.y] != 0 && graph[next.x][next.y] != level) {
                            return now.cnt;
                        }
                        visited[next.x][next.y] = true;
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
