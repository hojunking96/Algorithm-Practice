import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static int N;
    public static int[][] dist;
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[] dX = {0, 1, 0, -1};
    public static int[] dY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            graph = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            visited = new boolean[N][N];
            dijkstra();
            cnt++;
            sb.append("Problem ").append(cnt).append(": ").append(dist[N - 1][N - 1]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        dist[0][0] = graph[0][0];
        visited[0][0] = true;
        pq.add(new Node(0, 0, dist[0][0]));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dX[i];
                int nextY = now.y + dY[i];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                    continue;
                }
                if (!visited[nextX][nextY]) {
                    if (dist[nextX][nextY] > dist[now.x][now.y] + graph[nextX][nextY]) {
                        dist[nextX][nextY] = dist[now.x][now.y] + graph[nextX][nextY];
                        visited[nextX][nextY] = true;
                        pq.add(new Node(nextX, nextY, dist[nextX][nextY]));
                    }
                }
            }
        }
    }
}