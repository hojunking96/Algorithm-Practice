import java.io.*;
import java.util.*;

public class Main {

    public static int N, T;
    public static boolean[][] graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            int cnt = 0;
            graph = new boolean[N + 1][N + 1];
            visited = new boolean[N + 1];
            int[] arr = new int[N + 1];
            int[] arr2 = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                arr[j] = j;
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr2[j] = Integer.parseInt(st.nextToken());
                graph[arr[j]][arr2[j]] = true;
            }
            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    DFS(j);
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
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
