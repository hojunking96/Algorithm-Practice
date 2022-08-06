import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N;
        N = Integer.parseInt(br.readLine());
        int[][] K = new int[N][N];
        long[][] dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                K[i][j] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int move = K[i][j];
                if (dp[i][j] != 0 && K[i][j] != 0) {
                    if (i + move < N)
                        dp[i + move][j] += dp[i][j];
                    if (j + move < N)
                        dp[i][j + move] += dp[i][j];
                }
            }
        }

        bw.write(dp[N - 1][N - 1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
