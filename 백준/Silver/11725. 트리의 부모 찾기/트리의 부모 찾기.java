import java.io.*;
import java.util.*;

public class Main {
    public static int[] parents;
    public static ArrayList<Integer>[] graph;
    public static int N;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        DFS(1, 0);
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void DFS(int start, int parent) {
        parents[start] = parent;
        for (int connected : graph[start]) {
            if (connected != parent) {
                DFS(connected, start);
            }
        }
    }
}