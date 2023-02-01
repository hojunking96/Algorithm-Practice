import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static long A, B;
    public static HashMap<Long, Long> graph;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        graph = new HashMap<>();
        BFS();
        if (!graph.containsKey(B))
            System.out.println("-1");
        else {
            System.out.println(graph.get(B));
        }
    }

    public static void BFS() {
        Queue<Long> q = new LinkedList<>();
        q.add(A);
        graph.put(A, 1L);
        while (!q.isEmpty()) {
            long now = q.poll();
            if (now == B) {
                break;
            }
            long next = now * 2;
            if (next <= B) {
                if (!graph.containsKey(next)) {
                    q.add(next);
                    graph.put(next, graph.get(now) + 1);
                }
            }
            next = now * 10 + 1;
            if (next <= B) {
                if (!graph.containsKey(next)) {
                    q.add(next);
                    graph.put(next, graph.get(now) + 1);
                }
            }
        }
    }
}
