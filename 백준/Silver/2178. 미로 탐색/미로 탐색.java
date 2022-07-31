import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] X;

    static int N, M;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static class pair {
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void BFS(int x, int y) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(x, y));
        while (!q.isEmpty()) {
            pair now = q.poll();

            for (int i = 0; i < 4; i++) {
                pair next = new pair(now.x + dx[i], now.y + dy[i]);
                if (next.x >= 0 && next.x <= N - 1 && next.y >= 0 && next.y <= M - 1) {
                    if (X[next.x][next.y] == 1) {
                        X[next.x][next.y] = X[now.x][now.y] + 1;
                        q.add(next);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++)
                X[i][j] = s.charAt(j) - '0';
        }
        BFS(0, 0);
        bw.write(X[N - 1][M - 1] + "\n");

        bw.flush();
        bw.close();
        br.close();

    }
}
