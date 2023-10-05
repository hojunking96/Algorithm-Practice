import java.io.*;
import java.util.*;

public class Main {
    private static int k;
    private static List<List<Integer>> graph;
    private static int[] group;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            graph = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            for (int j = 0; j < f1; j++) {
                graph.add(new ArrayList<>());
            }
            for (int j = 0; j < f2; j++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken()) - 1;
                int v2 = Integer.parseInt(st.nextToken()) - 1;
                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }
            if (check(f1)) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean check(int n) {
        group = new int[n];
        for (int i = 0; i < n; i++) {
            if (group[i] == 0) {
                if (!BFS(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        group[start] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph.get(now)) {
                if (group[now] == group[next]) {
                    return false;
                }
                if (group[next] == 0) {
                    if (group[now] == 1) {
                        group[next] = 2;
                    } else {
                        group[next] = 1;
                    }
                    q.add(next);
                }
            }
        }
        return true;
    }
}
