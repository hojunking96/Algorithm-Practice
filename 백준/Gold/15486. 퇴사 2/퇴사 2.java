import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];   //끝나는 날
        int[] P = new int[N + 1];
        int[] dp = new int[N + 2];  //index 까지 일하면 버는 최대 돈
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken()) + i - 1;
            P[i] = Integer.parseInt(st.nextToken());
        }
        int max = -1;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i - 1]); //여태까지 번 최대 금액(새로운 일 시작 가능 상태)
            if (T[i] <= N) {
                dp[T[i]] = Math.max(dp[T[i]], max + P[i]);
            }
        }
        System.out.println(Math.max(max, dp[N]));
    }
}