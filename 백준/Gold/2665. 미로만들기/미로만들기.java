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

    private static int n;
    private static int[] dX = {-1, 0, 0, 1};
    private static int[] dY = {0, -1, 1, 0};
    private static int[][] graph;
    private static int[][] cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        cnt = new int[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }
        cnt[0][0] = 1;
        BFS(new Node(0, 0));
        System.out.println(cnt[n - 1][n - 1] - 1);
    }

    private static void BFS(Node start) {
        Queue<Node> q = new LinkedList<>();
        Queue<Node> newQ = new LinkedList<>();
        q.add(start);
        while (true) {

            while (!q.isEmpty()) {
                Node now = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nextX = now.x + dX[i];
                    int nextY = now.y + dY[i];
                    int nowCnt = cnt[now.x][now.y];
                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                        continue;
                    }
                    if (cnt[nextX][nextY] != 0) {
                        continue;
                    }
                    if (graph[nextX][nextY] == 1) {
                        cnt[nextX][nextY] = nowCnt;
                        q.add(new Node(nextX, nextY));
                    } else {
                        cnt[nextX][nextY] = nowCnt + 1;
                        newQ.add(new Node(nextX, nextY));
                    }
                }
            }
            if (newQ.isEmpty()) {
                break;
            }
            q = newQ;
            newQ = new LinkedList<>();
        }
    }

}