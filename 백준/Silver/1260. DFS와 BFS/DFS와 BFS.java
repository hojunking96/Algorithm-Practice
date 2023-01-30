import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, V;
    public static boolean[][] graph;
    public static StringBuilder sb = new StringBuilder();
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1][v2] = true;
            graph[v2][v1] = true;
        }
        DFS(V);
        sb.append("\n");
        initVisited();
        BFS(V);
        System.out.println(sb);
    }

    public static void initVisited() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    public static void DFS(int start) {
        sb.append(start).append(" ");
        visited[start] = true;
        for (int i = 1; i <= N; i++) {
            if (graph[start][i] && !visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            start = q.poll();
            sb.append(start).append(" ");
            for (int i = 1; i <= N; i++) {
                if (graph[start][i] && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}