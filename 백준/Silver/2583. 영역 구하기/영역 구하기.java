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

    private static int n, m, k;
    private static boolean[][] graph;
    private static int[] dX = {-1, 0, 0, 1};
    private static int[] dY = {0, -1, 1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        graph = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            for (int j = x1; j < x2; j++) {
                for (int l = y1; l < y2; l++) {
                    graph[j][l] = true;
                }
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j = 0; j < m; j++) {
            for (int l = 0; l < n; l++) {
                if (!graph[j][l]) {
                    int area = BFS(new Node(j, l));
                    pq.add(area);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()).append("\n");
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }
        System.out.println(sb);
    }

    private static int BFS(Node start) {
        int count = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        graph[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dX[i];
                int nextY = now.y + dY[i];
                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                    continue;
                }
                if (!graph[nextX][nextY]) {
                    q.add(new Node(nextX, nextY));
                    graph[nextX][nextY] = true;
                }
            }
        }
        return count;
    }
}