import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i; j++) {
                int k = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    dp[i][0] = dp[i - 1][0];
                } else if (j == i - 1) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
                dp[i][j] += k;
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[N][i]);
        }
        System.out.println(max);
    }
}