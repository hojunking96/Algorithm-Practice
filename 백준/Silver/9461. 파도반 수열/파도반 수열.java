import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        long[] dp = new long[101];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 3;
        dp[6] = 4;
        dp[7] = 5;
        dp[8] = 7;
        dp[9] = 9;
        for (int i = 10; i <= 100; i++) {
            dp[i] = dp[i - 5] + dp[i - 1];
        }
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N - 1]).append("\n");
        }
        System.out.println(sb);
    }
}