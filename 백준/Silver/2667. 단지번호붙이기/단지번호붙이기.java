import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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
    public static boolean[][] graph;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new boolean[N][N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int houseCnt = 0;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                if (input.charAt(j) == '1') {
                    graph[i][j] = true;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j]) {
                    pq.add(BFS(i, j));
                    houseCnt++;
                }
            }
        }
        sb.append(houseCnt).append("\n");
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }

    public static int BFS(int startX, int startY) {
        int cnt = 0;
        Queue<XY> q = new LinkedList<>();
        q.add(new XY(startX, startY));
        while (!q.isEmpty()) {
            XY newXY = q.poll();
            int x = newXY.x;
            int y = newXY.y;
            if (!graph[x][y])
                continue;
            graph[x][y] = false;
            cnt++;
            if (x > 0)
                if (graph[x - 1][y]) {
                    q.add(new XY(x - 1, y));
                }
            if (x < N - 1)
                if (graph[x + 1][y]) {
                    q.add(new XY(x + 1, y));
                }
            if (y > 0)
                if (graph[x][y - 1]) {
                    q.add(new XY(x, y - 1));
                }
            if (y < N - 1)
                if (graph[x][y + 1]) {
                    q.add(new XY(x, y + 1));
                }
        }
        return cnt;
    }
}