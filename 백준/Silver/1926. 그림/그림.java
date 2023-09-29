import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int n, m;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int max = 0;
    private static int count = 0;
    private static int[] dX = {-1, 0, 0, 1};
    private static int[] dY = {0, -1, 1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    BFS(new Node(i, j));
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    private static void BFS(Node start) {
        int cnt = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dX[i];
                int nextY = now.y + dY[i];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }
                if (!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                    q.add(new Node(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
        max = Math.max(max, cnt);
    }
}