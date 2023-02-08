import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int destination;
        int c;

        public Node(int v2, int c) {
            this.destination = v2;
            this.c = c;
        }
    }

    public static boolean[] visited;
    public static int[] dist;

    public static int N, M;
    public static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(v1).add(new Node(v2, c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        dist = new int[N + 1];

        dijkstra(start);

        System.out.println(dist[end]);

    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.c));
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (!visited[now.destination]) {
                visited[now.destination] = true;
                for (Node next : graph.get(now.destination)) {
                    if (!visited[next.destination] && dist[next.destination] > dist[now.destination] + next.c) {
                        dist[next.destination] = dist[now.destination] + next.c;
                        pq.add(new Node(next.destination, dist[next.destination]));
                    }
                }
            }
        }
    }
}