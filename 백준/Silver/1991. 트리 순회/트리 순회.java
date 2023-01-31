import java.io.*;
import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, String[]> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String parent = input[0];
            String[] child = new String[2];
            child[0] = input[1];
            child[1] = input[2];
            graph.put(parent, child);
        }
        preOrder(graph, "A");
        sb.append("\n");
        inOrder(graph, "A");
        sb.append("\n");
        postOrder(graph, "A");
        System.out.println(sb);
    }

    public static void preOrder(Map<String, String[]> graph, String start) {
        sb.append(start);
        String left = graph.get(start)[0];
        String right = graph.get(start)[1];
        if (!left.equals(".")) {
            preOrder(graph, left);
        }
        if (!right.equals(".")) {
            preOrder(graph, right);
        }
    }
    public static void inOrder(Map<String, String[]> graph, String start) {
        String left = graph.get(start)[0];
        String right = graph.get(start)[1];
        if (!left.equals(".")) {
            inOrder(graph, left);
        }
        sb.append(start);
        if (!right.equals(".")) {
            inOrder(graph, right);
        }
    } public static void postOrder(Map<String, String[]> graph, String start) {
        String left = graph.get(start)[0];
        String right = graph.get(start)[1];
        if (!left.equals(".")) {
            postOrder(graph, left);
        }
        if (!right.equals(".")) {
            postOrder(graph, right);
        }
        sb.append(start);
    }
}
