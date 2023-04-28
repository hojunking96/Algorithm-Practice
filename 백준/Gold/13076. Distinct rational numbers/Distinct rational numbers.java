import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[t];
        int max = 0;
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int[] dp = new int[max + 1];
        dp[1] = 2;

        for (int i = 2; i <= max; i++) {
            int now = EulerPhi(i);
            dp[i] = dp[i - 1] + now;
        }
        for (int i = 0; i < t; i++) {
            sb.append(dp[arr[i]]).append("\n");
        }
        System.out.println(sb);
    }

    private static int EulerPhi(int n) {
        int pi = n;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                pi = pi / i * (i - 1);
            }
            while (n % i == 0) {
                n /= i;
            }
        }
        if (n != 1) {
            pi = pi / n * (n - 1);
        }
        return pi;
    }

}