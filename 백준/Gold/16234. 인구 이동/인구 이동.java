import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class XY {
        public int x;
        public int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int N, L, R;
    public static int[][] graph;
    public static boolean[][] visited;

    public static int[] dX = {1, 0, -1, 0};
    public static int[] dY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                graph[i][j] = num;
            }
        }
        int dayCnt = calculate();
        System.out.println(dayCnt);
    }

    public static int calculate() {
        int dayCnt = 0;
        boolean hasMoved = true;
        while (hasMoved) {
            hasMoved = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int sum = 0;
                    if (!visited[i][j]) {
                        List<XY> union = BFS(new XY(i, j));
                        if (union.size() > 1) {
                            for (XY xy : union) {
                                sum += graph[xy.x][xy.y];
                            }
                            int avg = sum / union.size();
                            for (XY xy : union) {
                                graph[xy.x][xy.y] = avg;
                            }
                            hasMoved = true;
                        }
                    }
                }
            }
            if (hasMoved)
                dayCnt++;
        }
        return dayCnt;
    }

    public static List<XY> BFS(XY start) {
        Queue<XY> q = new LinkedList<>();
        List<XY> union = new ArrayList<>();
        q.add(start);
        union.add(start);
        visited[start.x][start.y] = true;
        while (!q.isEmpty()) {
            XY now = q.poll();
            for (int i = 0; i < 4; i++) {
                XY next = new XY(now.x + dX[i], now.y + dY[i]);
                if (next.x >= 0 && next.x < N && next.y >= 0 && next.y < N) {
                    int diff = graph[next.x][next.y] - graph[now.x][now.y];
                    if (!visited[next.x][next.y] && Math.abs(diff) >= L && Math.abs(diff) <= R) {
                        q.add(next);
                        union.add(next);
                        visited[next.x][next.y] = true;
                    }
                }
            }
        }
        return union;
    }
}
