import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Node o) {
        if (this.distance < o.distance)
            return -1;
        return 1;
    }
}

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    static int[] d;
    static int X, N, M;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[X] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();
            if (d[now] < dist)
                continue;
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int flag = 0;

        d = new int[N + 1];
        Arrays.fill(d, INF);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Node(B, 1));
        }
        dijkstra(X);

        for (int i = 1; i <= N; i++) {
            if (d[i] == K) {
                bw.write(i + "\n");
                flag = 1;
            }
        }
        if (flag == 0)
            bw.write(-1 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
