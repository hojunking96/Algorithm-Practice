import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static boolean[][] graph;
    public static boolean[] invitable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new boolean[n + 1][n + 1];
        invitable = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            graph[f1][f2] = true;
            graph[f2][f1] = true;
        }
        DFS(1, 0);
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (invitable[i])
                cnt++;
        }
        System.out.println(cnt);
    }

    public static void DFS(int start, int depth) {
        invitable[start] = true;
        if (depth == 2) {
            return;
        }
        for (int i = 2; i <= n; i++) {
            if (graph[start][i]) {
                DFS(i, depth + 1);
            }
        }
    }
}