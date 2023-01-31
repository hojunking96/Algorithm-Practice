import java.io.*;
import java.util.*;

public class Main {

    public static int N, T, M, K;
    public static boolean[][] graph;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            graph = new boolean[N + 2][M + 2];
            visited = new boolean[N + 2][M + 2];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int Y = Integer.parseInt(st.nextToken());
                int X = Integer.parseInt(st.nextToken());
                graph[X + 1][Y + 1] = true;
            }
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (graph[i][j] && !visited[i][j]) {
                        DFS(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void DFS(int startX, int startY) {
        visited[startX][startY] = true;
        if (graph[startX + 1][startY] && !visited[startX + 1][startY]) {
            DFS(startX + 1, startY);
        }
        if (graph[startX][startY + 1] && !visited[startX][startY + 1]) {
            DFS(startX, startY + 1);
        }
        if (graph[startX - 1][startY] && !visited[startX - 1][startY]) {
            DFS(startX - 1, startY);
        }
        if (graph[startX][startY - 1] && !visited[startX][startY - 1]) {
            DFS(startX, startY - 1);
        }
    }
}
