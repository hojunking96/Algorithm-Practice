import java.io.*;
import java.util.*;

public class Main {

    public static int[] X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        X = new int[100001];
        BFS(N, K);
        System.out.println(X[K]);
    }

    public static void BFS(int N, int K) {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == K)
                break;
            int n1 = now + 1;
            if (n1 >= 0 && n1 <= 100000) {
                if (X[n1] == 0) {
                    X[n1] = X[now] + 1;
                    q.add(n1);
                }
            }
            int n2 = now - 1;
            if (n2 >= 0 && n2 <= 100000) {
                if (X[n2] == 0) {
                    X[n2] = X[now] + 1;
                    q.add(n2);
                }
            }
            int n3 = now * 2;
            if (n3 >= 0 && n3 <= 100000) {
                if (X[n3] == 0) {
                    X[n3] = X[now] + 1;
                    q.add(n3);
                }
            }
        }
    }
}