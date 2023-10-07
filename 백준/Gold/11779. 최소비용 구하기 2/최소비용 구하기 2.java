import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int v;
        int cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    private static int n, m, start, end;
    private static List<Edge>[] graph;
    private static int[] dist;
    private static int[] destination;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[v1].add(new Edge(v2, cost));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        destination = new int[n + 1];
        Arrays.fill(dist, 1_000_000_000);
        visited = new boolean[n + 1];
        Dijkstra();

        List<Integer> route = new ArrayList<>();
        int now = end;
        while (now != 0) {
            route.add(now);
            now = destination[now];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]).append("\n");
        sb.append(route.size()).append("\n");
        for (int i = route.size() - 1; i >= 0; i--) {
            sb.append(route.get(i)).append(" ");
        }
        System.out.println(sb);

    }

    private static void Dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Edge(start, 0));
        dist[start] = 0;
        destination[start] = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (!visited[now.v]) {
                visited[now.v] = true;
                for (Edge next : graph[now.v]) {
                    if (dist[next.v] > dist[now.v] + next.cost) {
                        dist[next.v] = dist[now.v] + next.cost;
                        pq.add(new Edge(next.v, dist[next.v]));
                        destination[next.v] = now.v;
                    }
                }
            }
        }
    }
}
