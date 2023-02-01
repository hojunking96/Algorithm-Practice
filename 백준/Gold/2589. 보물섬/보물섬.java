import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class XY {
        public int x;
        public int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int N;
    public static int M;
    public static int[][] visited;

    public static int[] dX = {1, 0, -1, 0};
    public static int[] dY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[][] graph = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char type = input.charAt(j);
                if (type == 'L') {
                    graph[i][j] = true;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j]) {
                    visited = new int[N][M];
                    int cnt = BFS(graph, new XY(i, j));
                    if (cnt > max) {
                        max = cnt;
                    }
                }
            }
        }
        System.out.println(max - 1);
    }

    public static int BFS(boolean[][] graph, XY start) {
        int max = 0;
        Queue<XY> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = 1;
        while (!q.isEmpty()) {
            XY now = q.poll();
            for (int i = 0; i < 4; i++) {
                XY next = new XY(now.x + dX[i], now.y + dY[i]);
                if (next.x >= 0 && next.x < N && next.y >= 0 && next.y < M) {
                    if (graph[next.x][next.y] && visited[next.x][next.y] == 0) {
                        q.add(next);
                        visited[next.x][next.y] = visited[now.x][now.y] + 1;
                        if (visited[next.x][next.y] > max)
                            max = visited[next.x][next.y];
                    }
                }
            }
        }
        return max;
    }
}
