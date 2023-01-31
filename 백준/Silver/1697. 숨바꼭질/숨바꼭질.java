import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean check[] = new boolean[100001];
    static int X[] = new int[100001];
    static int N, K;

    static void BFS(int root) {
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        check[root] = true;
        X[root] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == K)
                break;
            int n1 = now + 1;
            if (n1 >= 0 && n1 <= 100000) {
                if (!check[n1] && X[n1] == 0) {
                    check[n1] = true;
                    X[n1] = X[now] + 1;
                    q.add(n1);
                }
            }
            int n2 = now - 1;
            if (n2 >= 0 && n2 <= 100000) {
                if (!check[n2] && X[n2] == 0) {
                    X[n2] = X[now] + 1;
                    check[n2] = true;
                    q.add(n2);
                }
            }
            int n3 = now * 2;
            if (n3 >= 0 && n3 <= 100000) {
                if (!check[n3] && X[n3] == 0) {
                    X[n3] = X[now] + 1;
                    check[n3] = true;
                    q.add(n3);
                }
            }

        }

    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        BFS(N);
        bw.write(X[K] - 1 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
