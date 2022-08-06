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
        int[] X = new int[N];
        long[][] dp = new long[N][21];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][X[0]] = 1;

        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (j + X[i] <= 20)
                    dp[i][j] += dp[i - 1][j + X[i]];
                if (j - X[i] >= 0)
                    dp[i][j] += dp[i - 1][j - X[i]];
            }
        }

        bw.write(dp[N - 2][X[N - 1]] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
