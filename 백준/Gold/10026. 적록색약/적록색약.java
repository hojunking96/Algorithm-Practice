import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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

    public static int[] dX = {1, 0, -1, 0};
    public static int[] dY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] graph = new char[N][N];
        char[][] weak = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                char color = input.charAt(j);
                graph[i][j] = color;
                weak[i][j] = color;
            }
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 'R') {
                    BFS1(graph, new XY(i, j), 'R');
                    cnt1++;
                }
                if (graph[i][j] == 'G') {
                    BFS1(graph, new XY(i, j), 'G');
                    cnt1++;
                }
                if (graph[i][j] == 'B') {
                    BFS1(graph, new XY(i, j), 'B');
                    cnt1++;
                }
                if (weak[i][j] == 'R' || weak[i][j] == 'G') {
                    BFS2(weak, new XY(i, j));
                    cnt2++;
                }
                if (weak[i][j] == 'B') {
                    BFS1(weak, new XY(i, j), 'B');
                    cnt2++;
                }
            }
        }
        System.out.println(cnt1 + " " + cnt2);
    }

    public static void BFS1(char[][] graph, XY start, char color) {
        Queue<XY> q = new LinkedList<>();
        q.add(start);
        graph[start.x][start.y] = 'X';
        while (!q.isEmpty()) {
            XY now = q.poll();
            for (int i = 0; i < 4; i++) {
                XY next = new XY(now.x + dX[i], now.y + dY[i]);
                if (next.x >= 0 && next.x < N && next.y >= 0 && next.y < N) {
                    if (graph[next.x][next.y] == color) {
                        q.add(next);
                        graph[next.x][next.y] = 'X';
                    }
                }
            }
        }
    }

    public static void BFS2(char[][] graph, XY start) {
        Queue<XY> q = new LinkedList<>();
        q.add(start);
        graph[start.x][start.y] = 'X';
        while (!q.isEmpty()) {
            XY now = q.poll();
            for (int i = 0; i < 4; i++) {
                XY next = new XY(now.x + dX[i], now.y + dY[i]);
                if (next.x >= 0 && next.x < N && next.y >= 0 && next.y < N) {
                    if (graph[next.x][next.y] == 'R' || graph[next.x][next.y] == 'G') {
                        q.add(next);
                        graph[next.x][next.y] = 'X';
                    }
                }
            }
        }
    }
}
