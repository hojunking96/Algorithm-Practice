import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            int cnt = 0;

            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < M; j++) {
                sum += arr[j];
            }
            if (sum < K) {
                cnt++;
            }
            if (N == M) {
                sb.append(cnt).append("\n");
                continue;
            }
            int left = 0;
            int right = M;

            while (left < N - 1) {
                right %= N;

                sum -= arr[left];
                sum += arr[right];
                if (sum < K) {
                    cnt++;
                }

                left++;
                right++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}