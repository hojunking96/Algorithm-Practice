import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static boolean[][] graph;
    public static int cnt = 0;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1][v2] = true;
            graph[v2][v1] = true;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                DFS(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static void DFS(int start) {
        visited[start] = true;
        for (int i = 1; i <= N; i++) {
            if (graph[start][i] && !visited[i]) {
                DFS(i);
            }
        }
    }
}
