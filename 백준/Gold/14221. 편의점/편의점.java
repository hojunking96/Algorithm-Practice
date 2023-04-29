import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int v;
        int c;

        public Node(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }

    private static List<List<Node>> graph;
    private static int[] dist;
    private static int min = Integer.MAX_VALUE;
    private static int minIndex = 0;
    private static int N;
    private static Set<Integer> Qs = new HashSet<>();
    private static Set<Integer> Ps = new HashSet<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()) - 1;
            int E = Integer.parseInt(st.nextToken()) - 1;
            int T = Integer.parseInt(st.nextToken());
            graph.get(S).add(new Node(E, T));
            graph.get(E).add(new Node(S, T));
        }

        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < P; i++) {
            Ps.add(Integer.parseInt(st.nextToken()) - 1);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            Qs.add(Integer.parseInt(st.nextToken()) - 1);
        }


        Dijkstra();

        System.out.println(minIndex + 1);
    }

    private static void Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.c));
        dist = new int[N];
        visited = new boolean[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int q : Qs) {
            pq.add(new Node(q, 0));
            dist[q] = 0;
            visited[q] = true;
        }


        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (Ps.contains(now.v)) {
                if (min > dist[now.v]) {
                    minIndex = now.v;
                    min = dist[now.v];
                } else if (min == dist[now.v]) {
                    minIndex = Math.min(minIndex, now.v);
                }
            }

            visited[now.v] = true;

            for (Node next : graph.get(now.v)) {
                if (visited[next.v]) {
                    continue;
                }
                if (dist[next.v] > dist[now.v] + next.c) {
                    dist[next.v] = dist[now.v] + next.c;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}