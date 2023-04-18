import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Planet {
        int num;
        int x;
        int y;
        int z;

        public Planet(int num, int x, int y, int z) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static class Edge implements Comparable<Edge> {
        public int start;
        public int end;
        public long weight;

        public Edge(int start, int end, long weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return (int) (this.weight - o.weight);
        }
    }

    private static int N;
    private static int[] parent;
    private static final PriorityQueue<Edge> edges = new PriorityQueue<>();
    private static final List<Planet> planets = new ArrayList<>();


    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            planets.add(new Planet(i, A, B, C));
        }
// x, y, z 각각에 대해서 정렬하고 각 행성의 번호와 비용을 edgeList에 추가.
        planets.sort(Comparator.comparingInt(o -> o.x));
        for (int i = 0; i < N - 1; i++) {
            int weight = Math.abs(planets.get(i).x - planets.get(i + 1).x);

            edges.add(new Edge(planets.get(i).num, planets.get(i + 1).num, weight));
        }

        planets.sort(Comparator.comparingInt(p -> p.y));
        for (int i = 0; i < N - 1; i++) {
            int weight = Math.abs(planets.get(i).y - planets.get(i + 1).y);

            edges.add(new Edge(planets.get(i).num, planets.get(i + 1).num, weight));
        }

        planets.sort(Comparator.comparingInt(p -> p.z));
        for (int i = 0; i < N - 1; i++) {
            int weight = Math.abs(planets.get(i).z - planets.get(i + 1).z);

            edges.add(new Edge(planets.get(i).num, planets.get(i + 1).num, weight));
        }

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }


        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
        System.out.println(Kruscal());
    }

    private static long Kruscal() {
        long totalWeight = 0;
        int cnt = 0;
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            int start = edge.start;
            int end = edge.end;
            if (findParent(start) != findParent(end)) {
                union(start, end);
                totalWeight += edge.weight;
                if (++cnt == N - 1) break;
            }
        }
        return totalWeight;
    }

    private static int findParent(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = findParent(parent[x]);
    }

    private static void union(int v1, int v2) {
        v1 = findParent(v1);
        v2 = findParent(v2);
        if (v1 != v2) {
            parent[v2] = v1;
        }
    }
}