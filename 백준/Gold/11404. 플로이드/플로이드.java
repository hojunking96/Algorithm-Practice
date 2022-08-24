import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, INF = Integer.MAX_VALUE;
    public static int[][] G;

    public static void init(int[][] graph) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                G[i][j] = INF;
    }

    public static void FW(int[][] graph) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j && graph[i][k] != INF && graph[k][j] != INF)
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        G = new int[n][n];
        init(G);
        m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            G[a - 1][b - 1] = Math.min(G[a - 1][b - 1], c);
        }
        FW(G);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (G[i][j] == INF)
                    G[i][j] = 0;
                if (i == j)
                    G[i][j] = 0;
                sb.append(G[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}