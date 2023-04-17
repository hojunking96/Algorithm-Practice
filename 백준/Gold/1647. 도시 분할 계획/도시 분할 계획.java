import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    private static int N;
    private static List<Edge> edges = new ArrayList<>();
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        parent = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges.add(new Edge(A, B, C));
        }
        Collections.sort(edges, (Comparator.comparingInt(o -> o.weight)));


        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }


        int max = 0;
        int sum = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            if (findParent(edge.start) == findParent(edge.end)) {
                continue;
            }
            sum += edge.weight;
            union(edge.start, edge.end);
            max = Math.max(max, edge.weight);
        }
        System.out.println(sum - max);
    }

    private static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }

    private static void union(int start, int end) {
        int parent1 = findParent(start);
        int parent2 = findParent(end);
        if (parent1 != parent2) {
            parent[parent2] = parent1;
        }
    }
}