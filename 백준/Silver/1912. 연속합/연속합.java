import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1];
            }
            dp[i] += arr[i];
        }
        int max = -1000;
        for (int e : dp) {
            max = Math.max(max, e);
        }
        System.out.println(max);
    }
}