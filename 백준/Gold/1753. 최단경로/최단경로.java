import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static int V, E;
    public static int[] dist;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }
        visited = new boolean[V + 1];
        dist = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dijkstra(start);
        for (int i = 1; i <= V; i++) {
            if (i == start) {
                sb.append("0").append("\n");
                continue;
            }
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(dist[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
        dist[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (!visited[now.v]) {
                visited[now.v] = true;
                for (Node next : graph.get(now.v)) {
                    if (!visited[next.v] && dist[next.v] > dist[now.v] + next.w) {
                        dist[next.v] = dist[now.v] + next.w;
                        pq.add(new Node(next.v, dist[next.v]));
                    }
                }
            }
        }
    }
}