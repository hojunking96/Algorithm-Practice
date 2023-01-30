import java.io.*;
import java.util.*;

public class Main {

    public static int N, T;
    public static boolean[][] graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        int cnt = 0;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1][v2] = true;
            graph[v2][v1] = true;
        }
        DFS(1);
        for (int j = 2; j <= N; j++) {
            if (visited[j])
                cnt++;
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
