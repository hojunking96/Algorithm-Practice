import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, K;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[2][500001];
        if (N == K) {
            System.out.println(0);
        } else {
            System.out.println(BFS(N));
        }
    }

    private static int BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[0][start] = true;

        int size, mod, time = 0;
        while (!q.isEmpty()) {
            size = q.size();
            time++;
            mod = time % 2;
            K += time;
            if (K > 500000) {
                return -1;
            }
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                int next = now - 1;
                if (next >= 0 && !visited[mod][next]) {
                    q.add(next);
                    visited[mod][next] = true;
                }
                next = now + 1;
                if (next <= 500000 && !visited[mod][next]) {
                    q.add(next);
                    visited[mod][next] = true;
                }
                next = now * 2;
                if (next <= 500000 && !visited[mod][next]) {
                    q.add(next);
                    visited[mod][next] = true;
                }
            }
            if (visited[mod][K]) {
                return time;
            }

        }
        return -1;
    }
}