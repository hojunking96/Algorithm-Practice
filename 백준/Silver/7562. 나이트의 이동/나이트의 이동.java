import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    private static int n, l;
    private static int[] dX = {-2, -2, 2, 2, 1, 1, -1, -1};
    private static int[] dY = {-1, 1, -1, 1, 2, -2, 2, -2};
    private static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            l = Integer.parseInt(br.readLine());
            visited = new boolean[l][l];
            st = new StringTokenizer(br.readLine());
            int nowX = Integer.parseInt(st.nextToken());
            int nowY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int nextX = Integer.parseInt(st.nextToken());
            int nextY = Integer.parseInt(st.nextToken());
            int count = BFS(new Node(nowX, nowY, 0), new Node(nextX, nextY, 0));
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static int BFS(Node start, Node end) {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        int cnt = 0;
        visited[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.x == end.x && now.y == end.y) {
                return now.cnt;
            }
            cnt++;
            for (int i = 0; i < 8; i++) {
                int nextX = now.x + dX[i];
                int nextY = now.y + dY[i];
                if (nextX < 0 || nextX >= l || nextY < 0 || nextY >= l) {
                    continue;
                }
                if (!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    q.add(new Node(nextX, nextY, now.cnt + 1));
                }
            }
        }
        return cnt;
    }

}