import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class pair {
    int x;
    int y;

    pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int X[][];
    static int K, N, M;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static void DFS(pair now) {
        X[now.x][now.y] = 0;
        for (int i = 0; i < 4; i++) {
            pair next = new pair(now.x + dx[i], now.y + dy[i]);
            if (next.x >= 0 && next.x < N && next.y >= 0 && next.y < M) {
                if (X[next.x][next.y] != 0)
                    DFS(next);
            }
        }
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int caseT = 0; caseT < T; caseT++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int cnt = 0;
            X = new int[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int tmpX = Integer.parseInt(st.nextToken());
                int tmpY = Integer.parseInt(st.nextToken());
                X[tmpY][tmpX] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (X[i][j] == 1) {
                        DFS(new pair(i, j));
                        cnt++;
                    }
                }
            }
            bw.write(cnt + "\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
