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

    public static int n, m, t;
    public final static int INF = 3000000;
    public static ArrayList<ArrayList<Node>> graph;
    public static int[] dist; //첫 번째 인덱스에서 두 번째 인덱스로 가는 최소 길이

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            int s, g, h, a, b, d;
            int ghLength = 0;

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                graph.get(a).add(new Node(b, d));
                graph.get(b).add(new Node(a, d));
                if (a == g && b == h || a == h && b == g) {
                    ghLength = d;
                }
            }
            int[] x = new int[t];
            for (int j = 0; j < t; j++) {
                x[j] = Integer.parseInt(br.readLine());
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            //s ~ g + g ~ h 길이 + h ~ 다른곳 = s ~ 다른 곳
            for (int k : x) {
                int root1 = dijkstra(s, g) + ghLength + dijkstra(h, k);
                int root2 = dijkstra(s, h) + ghLength + dijkstra(g, k);
                int root = dijkstra(s, k);
                if (root1 == root || root2 == root) {
                    pq.add(k);
                }
            }
            while (!pq.isEmpty()) {
                sb.append(pq.poll()).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int dijkstra(int start, int end) {
        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.v] < now.w)
                continue;
            for (Node next : graph.get(now.v)) {
                if (dist[next.v] > dist[now.v] + next.w) {
                    dist[next.v] = dist[now.v] + next.w;
                    pq.offer(new Node(next.v, dist[now.v] + next.w));
                }
            }
        }
        return dist[end];
    }
}