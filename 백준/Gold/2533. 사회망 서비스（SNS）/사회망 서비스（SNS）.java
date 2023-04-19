import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static List<Integer>[] graph;
    private static int[][] dp;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N][2];
        visited = new boolean[N];
        graph = new List[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph[u].add(v);
            graph[v].add(u);
        }
        DFS(0);

        System.out.println(Math.min(dp[0][0], dp[0][1]));
    }

    private static void DFS(int start) {
        visited[start] = true;
        if (graph[start].size() == 1) {

        }
        dp[start][0] = 0;
        dp[start][1] = 1;
        for (int child : graph[start]) {
            if (!visited[child]) {
                DFS(child);
                dp[start][0] += dp[child][1];
                dp[start][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}