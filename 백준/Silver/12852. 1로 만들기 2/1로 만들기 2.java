import java.io.*;

public class Main {
    static class DP {
        int value;
        String list = "";

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        DP[] dp = new DP[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = new DP();
        }
        dp[1].value = 0;
        dp[1].list += 1;
        if (N >= 2) {
            dp[2].value = 1;
            dp[2].list = 2 + " " + dp[1].list;
            if (N >= 3) {
                dp[3].value = 1;
                dp[3].list = 3 + " " + dp[1].list;
            }
        }
        for (int i = 4; i <= N; i++) {
            if (i % 3 == 0) {
                if (i % 2 == 0) {
                    dp[i].value = findMin(dp[i - 1].value + 1, dp[i / 2].value + 1, dp[i / 3].value + 1);
                    if (dp[i].value == dp[i - 1].value + 1) {
                        dp[i].list = i + " " + dp[i - 1].list;
                    } else if (dp[i].value == dp[i / 2].value + 1) {
                        dp[i].list = i + " " + dp[i / 2].list;
                    } else {
                        dp[i].list = i + " " + dp[i / 3].list;
                    }

                } else {
                    dp[i].value = Math.min(dp[i - 1].value + 1, dp[i / 3].value + 1);
                    if (dp[i].value == dp[i - 1].value + 1) {
                        dp[i].list = i + " " + dp[i - 1].list;
                    } else {
                        dp[i].list = i + " " + dp[i / 3].list;
                    }
                }
            } else {
                if (i % 2 == 0) {
                    dp[i].value = Math.min(dp[i - 1].value + 1, dp[i / 2].value + 1);
                    if (dp[i].value == dp[i - 1].value + 1) {
                        dp[i].list = i + " " + dp[i - 1].list;
                    } else {
                        dp[i].list = i + " " + dp[i / 2].list;
                    }
                } else {
                    dp[i].value = dp[i - 1].value + 1;
                    dp[i].list = i + " " + dp[i - 1].list;
                }
            }
        }
        System.out.println(dp[N].value);
        System.out.println(dp[N].list);
    }

    public static int findMin(int num1, int num2, int num3) {
        return Math.min(Math.min(num1, num2), num3);
    }

}