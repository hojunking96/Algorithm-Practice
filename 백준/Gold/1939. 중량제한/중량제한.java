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

    private static List<List<Node>> graph;
    private static int N, M;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.get(A - 1).add(new Node(B - 1, C));
            graph.get(B - 1).add(new Node(A - 1, C));
            if (C > right) {
                right = C;
            }
        }
        st = new StringTokenizer(br.readLine());
        int factoryNum1 = Integer.parseInt(st.nextToken()) - 1;
        int factoryNum2 = Integer.parseInt(st.nextToken()) - 1;
        while (left <= right) {
            //mid 는 적재량
            int mid = (left + right) / 2;
            //BFS true -> 안무너짐
            if (BFS(factoryNum1, factoryNum2, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left - 1);
    }

    private static boolean BFS(int start, int end, int weight) {
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == end) {
                return true;
            }
            for (int i = 0; i < graph.get(now).size(); i++) {
                Node next = graph.get(now).get(i);
                if (!visited[next.v] && next.w >= weight) {
                    q.add(next.v);
                    visited[next.v] = true;
                }
            }
        }
        return false;
    }
}