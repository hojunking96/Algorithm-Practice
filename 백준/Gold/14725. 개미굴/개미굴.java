import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        HashMap<String, Node> childNodes = new HashMap<>();
    }

    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node root = new Node();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            Node now = root;
            for (int j = 0; j < K; j++) {
                String next = st.nextToken();
                if (!now.childNodes.containsKey(next)) {
                    now.childNodes.put(next, new Node());
                }
                now = now.childNodes.get(next);
            }
        }
        print(root, "");
        System.out.println(sb);
    }

    private static void print(Node root, String bar) {
        Object[] keys = root.childNodes.keySet().toArray();
        Arrays.sort(keys);
        for (Object e : keys) {
            sb.append(bar).append(e).append("\n");
            print(root.childNodes.get(e), bar + "--");
        }
    }
}