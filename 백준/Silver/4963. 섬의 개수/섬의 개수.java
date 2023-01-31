import java.io.*;
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

    public static int h, w;
    public static boolean[][] graph;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            graph = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    int type = Integer.parseInt(st.nextToken());
                    if (type == 1) {
                        graph[i][j] = true;
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (graph[i][j]) {
                        BFS(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static void BFS(int startX, int startY) {
        int[] diff = {-1, 0, 1};
        Queue<XY> q = new LinkedList<>();
        q.add(new XY(startX, startY));
        while (!q.isEmpty()) {
            XY newXY = q.poll();
            int x = newXY.x;
            int y = newXY.y;
            if (!graph[x][y])
                continue;
            graph[x][y] = false;

            for (int i = 0; i < 3; i++) {
                int nextX = x + diff[i];
                if (nextX >= 0 && nextX <= h - 1) {
                    for (int j = 0; j < 3; j++) {
                        int nextY = y + diff[j];
                        if (nextY >= 0 && nextY <= w - 1) {
                            if (graph[nextX][nextY]) {
                                q.add(new XY(nextX, nextY));
                            }
                        }
                    }
                }
            }
        }
    }
}