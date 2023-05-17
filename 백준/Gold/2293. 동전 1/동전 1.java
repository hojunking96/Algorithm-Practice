import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Integer> arr = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value <= k && !arr.contains(value)) {
                arr.add(value);
            }
        }

        for (int e : arr) {
            dp[e]++;
            for (int i = e; i <= k; i++) {
                dp[i] += dp[i - e];
            }
        }
        System.out.println(dp[k]);
    }
}