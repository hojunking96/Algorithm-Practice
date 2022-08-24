import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] G;

    public static void find(int[][] graph) {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] == 1)
                        continue;
                    if (graph[i][k] == 1 && graph[k][j] == 1)
                        graph[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        G = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                G[i][j] = Integer.parseInt(st.nextToken());
        }
        find(G);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(G[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}