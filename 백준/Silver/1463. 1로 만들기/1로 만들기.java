import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= N; i++) {
            if (i % 3 == 0) {
                if (i % 2 == 0) {
                    dp[i] = findMin(dp[i - 1] + 1, dp[i / 2] + 1, dp[i / 3] + 1);
                } else {
                    dp[i] = Math.min(dp[i - 1] + 1, dp[i / 3] + 1);
                }
            } else {
                if (i % 2 == 0) {
                    dp[i] = Math.min(dp[i - 1] + 1, dp[i / 2] + 1);
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            }
        }
        System.out.println(dp[N]);
    }

    public static int findMin(int num1, int num2, int num3) {
        return Math.min(Math.min(num1, num2), num3);
    }

}