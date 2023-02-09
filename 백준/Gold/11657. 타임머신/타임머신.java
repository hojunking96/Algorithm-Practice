import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int v;
        int c;

        public Node(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }

    public static ArrayList<ArrayList<Node>> graph;
    public static final int INF = 60000000;
    public static long[] dist;
    public static int N, M;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.get(A).add(new Node(B, C));
        }
        StringBuilder sb = new StringBuilder();
        if (bellmanFord()) {
            sb.append("-1\n");
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    sb.append("-1\n");
                } else {
                    sb.append(dist[i]).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    public static boolean bellmanFord() {
        dist[1] = 0;
        boolean hasChanged = false;
        for (int i = 1; i < N; i++) {
            hasChanged = false;
            for (int j = 1; j <= N; j++) {
                for (Node node : graph.get(j)) {
                    if (dist[j] == INF) {
                        break;
                    }
                    if (dist[node.v] > dist[j] + node.c) {
                        dist[node.v] = dist[j] + node.c;
                        hasChanged = true;
                    }
                }
            }
            // 더 이상 최단거리 초기화가 일어나지 않았을 경우 반복문을 종료.
            if (!hasChanged) {
                return false;
            }
        }
        // (정점의 개수 - 1)번까지 계속 업데이트가 발생했을 경우
        // (정점의 개수)번도 업데이트 발생하면 음수 사이클이 일어난 것을 의미함.
        if (hasChanged) {
            for (int i = 1; i <= N; i++) {
                for (Node node : graph.get(i)) {
                    if (dist[i] == INF) {
                        break;
                    }
                    if (dist[node.v] > dist[i] + node.c) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}