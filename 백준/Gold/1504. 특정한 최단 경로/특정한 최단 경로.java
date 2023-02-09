import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public static int N, E;
    public static int[] dist;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int must1 = Integer.parseInt(st.nextToken());
        int must2 = Integer.parseInt(st.nextToken());

        int cost1 = dijkstra(1, must1) + dijkstra(must1, must2) + dijkstra(must2, N);
        int cost2 = dijkstra(1, must2) + dijkstra(must2, must1) + dijkstra(must1, N);
        if (cost1 >= 300000000 && cost2 >= 300000000) {
            System.out.println("-1");
        } else {
            System.out.println(Math.min(cost1, cost2));
        }
    }

    public static int dijkstra(int start, int end) {
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dist[i] = 300000000;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        dist[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (!visited[now.v]) {
                visited[now.v] = true;
                for (Node next : graph.get(now.v)) {
                    if (!visited[next.v] && dist[next.v] > dist[now.v] + next.cost) {
                        dist[next.v] = dist[now.v] + next.cost;
                        pq.add(new Node(next.v, dist[next.v]));
                    }
                }
            }
        }
        return dist[end];
    }
}