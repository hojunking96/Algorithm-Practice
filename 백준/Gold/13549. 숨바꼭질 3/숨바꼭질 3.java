import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = Integer.MAX_VALUE;
    static int[] T;
    static int N, K;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    private static class Node implements Comparable<Node> {
        private int index;
        private int time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }

        public int getIndex() {
            return this.index;
        }

        public int getTime() {
            return this.time;
        }

        @Override
        public int compareTo(Node o) {
            if (this.time < o.time)
                return -1;
            return 1;
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        T[N] = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.getIndex();
            int t = node.getTime();

            now++;
            t++;

            if (now <= 100000 && t < T[now]) {
                T[now] = t;
                pq.add(new Node(now, t));
            }

            now -= 2;
            if (0 <= now && t < T[now]) {
                T[now] = t;
                pq.add(new Node(now, t));
            }
            now = (now + 1) * 2;
            t--;
            if (now <= 100000 && t < T[now]) {
                T[now] = t;
                pq.add(new Node(now, t));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        T = new int[100001];
        Arrays.fill(T, INF);

        for (int i = 1; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        dijkstra(N);
        bw.write(T[K] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
