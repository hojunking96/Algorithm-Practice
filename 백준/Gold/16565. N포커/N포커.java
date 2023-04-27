import java.io.*;

public class Main {

    private static int N;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[53][53];

        for (int i = 0; i <= 52; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= 52; i++) {
            for (int j = 1; j <= 52; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                dp[i][j] %= 10_007;
            }
        }

        int answer = 0;
        for (int i = 1; i <= 13; i++) {
            if (N - 4 * i < 0) {
                break;
            }
            if (i % 2 == 0) {
                answer -= dp[13][i] * dp[52 - 4 * i][N - 4 * i];
            } else {
                answer += dp[13][i] * dp[52 - 4 * i][N - 4 * i];
            }
            answer %= 10_007;
            if (answer < 0) {
                answer += 10_007;
            }
        }
        System.out.println(answer);
    }
}