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
    private static int[] returnDist;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;

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
        }

        dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;
        Dijkstra(X);
        
        returnDist = new int[N];
        for (int i = 0; i < N; i++) {
            returnDist[i] = dist[i];
        }

        for (int i = 0; i < N; i++) {
            if (i == X) {
                continue;
            }
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;
            Dijkstra(i);
            max = Math.max(max, dist[X] + returnDist[i]);
        }
        System.out.println(max);

    }

    private static void Dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.c));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            for (Node next : graph.get(now.v)) {
                if (dist[next.v] > dist[now.v] + next.c) {
                    dist[next.v] = dist[now.v] + next.c;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}