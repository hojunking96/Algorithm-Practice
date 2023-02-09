import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.x > o2.x) {
                return 1;
            }
            if (o1.x == o2.x) {
                if (o1.y > o2.y) {
                    return 1;
                }
            }
            return -1;
        });
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            pq.add(new Node(v1, v2));
        }
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            sb.append(node.x).append(" ").append(node.y).append("\n");
        }
        System.out.println(sb);
    }
}