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

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 2];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int max = -1;
        for (int i = 1; i < N + 1; i++) {
            if (max < dp[i])
                max = dp[i];
            int next = i + T[i];
            if (next <= N + 1)
                dp[next] = Math.max(dp[next], max + P[i]);
        }
        bw.write(Math.max(max, dp[N + 1]) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
