import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Star {
        double x;
        double y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge {
        int v1;
        int v2;
        double weight;

        public Edge(int v1, int v2, double weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
    }

    private static int[] parent;
    private static int N;
    private static Star[] stars;
    private static List<Edge> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
        stars = new Star[N];
        edges = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i] = new Star(x, y);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    edges.add(new Edge(i, j, getDistance(stars[i].x, stars[i].y, stars[j].x, stars[j].y)));
                }
            }
        }
        Collections.sort(edges, ((o1, o2) -> (int) (o1.weight - o2.weight)));
        double sum = 0;
        int cnt = 0;
        for (Edge e : edges) {
            if (findParent(e.v1) != findParent(e.v2)) {
                union(e.v1, e.v2);
                sum += e.weight;
                cnt++;
            }
            if (cnt == N - 1) {
                break;
            }
        }
        System.out.println(String.format("%.2f", sum));
    }

    private static double getDistance(double x, double y, double x1, double y1) {
        double xd, yd;
        yd = Math.pow((y1 - y), 2);
        xd = Math.pow((x1 - x), 2);
        return Math.sqrt(yd + xd);
    }

    private static int findParent(int x) {
        if (parent[x] == x)
            return x;
        return findParent(parent[x]);
    }

    private static void union(int v1, int v2) {
        v1 = findParent(v1);
        v2 = findParent(v2);
        if (v1 > v2) {
            parent[v1] = v2;
        } else {
            parent[v2] = v1;
        }
    }

}