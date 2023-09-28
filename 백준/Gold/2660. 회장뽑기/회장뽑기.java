import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int next;
        int dist;

        public Node(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }
    }

    private static List<List<Integer>> graph = new ArrayList<>();
    private static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        while (true) {
            String input = br.readLine();
            if (input.equals("-1 -1")) {
                break;
            }
            String[] nums = input.split(" ");
            int v1 = Integer.parseInt(nums[0]) - 1;
            int v2 = Integer.parseInt(nums[1]) - 1;
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        for (int i = 0; i < n; i++) {
            scores[i] = count(i);
        }
        int minScore = n + 1;
        List<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (minScore > scores[i]) {
                minScore = scores[i];
                candidates = new ArrayList<>();
                candidates.add(i + 1);
            } else if (minScore == scores[i]) {
                candidates.add(i + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(minScore).append(" ").append(candidates.size()).append("\n");
        for (int candidate : candidates) {
            sb.append(candidate).append(" ");
        }
        System.out.println(sb);
    }

    private static int count(int start) {
        boolean[] visited = new boolean[n];
        int max = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        visited[start] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            max = Math.max(max, now.dist);
            for (int next : graph.get(now.next)) {
                if (!visited[next]) {
                    q.add(new Node(next, now.dist + 1));
                    visited[next] = true;
                }
            }
        }
        return max;
    }
}