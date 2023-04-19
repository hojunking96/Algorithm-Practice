import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    private static boolean[][] visited;
    private static List<Node>[][] graph;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char key = input.charAt(j);
                connect(i, j, key);
            }
        }

        visited = new boolean[N][M];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    BFS(i, j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void connect(int nowX, int nowY, char key) {
        int nextX = nowX;
        int nextY = nowY;
        switch (key) {
            case 'D':
                nextX++;
                break;
            case 'U':
                nextX--;
                break;
            case 'L':
                nextY--;
                break;
            default:
                nextY++;
                break;
        }
        if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
            graph[nowX][nowY].add(new Node(nextX, nextY));
            graph[nextX][nextY].add(new Node(nowX, nowY));
        }
    }

    private static void BFS(int startX, int startY) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startX, startY));
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            for (Node next : graph[now.x][now.y]) {
                if (!visited[next.x][next.y]) {
                    q.add(next);
                    visited[next.x][next.y] = true;
                }
            }
        }
    }
}