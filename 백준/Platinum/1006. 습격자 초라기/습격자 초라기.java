import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int W;

    private static int[][] board;

    private static int[] a;
    private static int[] b;
    private static int[] c;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int result = 2147483647;
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            board = new int[2][N];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            a = new int[N];
            b = new int[N];
            c = new int[N + 1];

            a[0] = 1;
            b[0] = 1;
            c[0] = 0;

            // 인덱스 0부터 시작
            solve(0);

            result = Math.min(result, c[N]);

            // 두 행 이상일 경우
            if (N > 1) {
                // 두 행 모두 걸칠 경우
                if (board[0][0] + board[0][N - 1] <= W && board[1][0] + board[1][N - 1] <= W) {
                    a[1] = 1;
                    b[1] = 1;
                    c[1] = 0;

                    // 인덱스 1부터 시작 (1까지 초기값이 있기 때문)
                    solve(1);

                    result = Math.min(result, c[N - 1] + 2);
                }

                // 윗 행만 걸칠 경우
                if (board[0][0] + board[0][N - 1] <= W) {
                    a[1] = 2;
                    b[1] = board[1][0] + board[1][1] > W ? 2 : 1;
                    c[1] = 1;

                    // 인덱스 1부터 시작 (1까지 초기값이 있기 때문)
                    solve(1);

                    result = Math.min(result, b[N - 1] + 1);
                }

                // 아래 행만 걸칠 경우
                if (board[1][0] + board[1][N - 1] <= W) {
                    a[1] = board[0][0] + board[0][1] > W ? 2 : 1;
                    b[1] = 2;
                    c[1] = 1;

                    // 인덱스 1부터 시작 (1까지 초기값이 있기 때문)
                    solve(1);

                    result = Math.min(result, a[N - 1] + 1);
                }
            }

            System.out.println(result);
        }
    }

    private static void solve(int num) {
        for (int i = num; i < N; i++) {
            c[i + 1] = Math.min(a[i] + 1, b[i] + 1);

            // c팀이 인접한 두 개의 구역을 점령할 수 있을 경우
            if (board[0][i] + board[1][i] <= W) {
                c[i + 1] = Math.min(c[i + 1], c[i] + 1);
            }

            // c팀이 인접한 두개의 구역 2개를 점령할 수 있을 경우
            if (i > 0 && board[0][i - 1] + board[0][i] <= W && board[1][i - 1] + board[1][i] <= W) {
                c[i + 1] = Math.min(c[i + 1], c[i - 1] + 2);
            }

            // a, b팀의 인덱스 보정 (c팀은 인덱스가 하나 더 많음)
            if (i < N - 1) {
                a[i + 1] = c[i + 1] + 1;
                b[i + 1] = c[i + 1] + 1;

                // a팀이 인접한 두 개의 구역을 점령할 수 있을 경우
                if (board[0][i] + board[0][i + 1] <= W) {
                    a[i + 1] = Math.min(a[i + 1], b[i] + 1);
                }

                // b팀이 인접한 두 개의 구역을 점령할 수 있을 경우
                if (board[1][i] + board[1][i + 1] <= W) {
                    b[i + 1] = Math.min(b[i + 1], a[i] + 1);
                }
            }
        }
    }
}
//모르겠다 다음에 다시 보자