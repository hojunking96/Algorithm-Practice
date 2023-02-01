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
    public static int[][] graph;
    public static boolean[][] safe;
    public static int maxHeight = 0;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                graph[i][j] = input;
                if (input > maxHeight) {
                    maxHeight = input;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < maxHeight; i++) {
            safe = new boolean[N][N];
            rainFall(i);
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (safe[j][k]) {
                        BFS(new XY(j, k));
                        cnt++;
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
            }
        }
        System.out.println(max);
    }

    public static void rainFall(int rainHeight) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] > rainHeight) {
                    safe[i][j] = true;
                }
            }
        }
    }

    public static void BFS(XY start) {
        int[] dX = {1, 0, -1, 0};
        int[] dY = {0, 1, 0, -1};

        Queue<XY> q = new LinkedList<>();
        q.add(start);
        safe[start.x][start.y] = false;
        while (!q.isEmpty()) {
            XY now = q.poll();
            for (int i = 0; i < 4; i++) {
                XY next = new XY(now.x + dX[i], now.y + dY[i]);
                if (next.x >= 0 && next.x < N && next.y >= 0 && next.y < N) {
                    if (safe[next.x][next.y]) {
                        q.add(next);
                        safe[next.x][next.y] = false;
                    }
                }
            }
        }
    }
}
