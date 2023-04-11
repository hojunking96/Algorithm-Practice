import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    private static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        cnt = new int[100_001];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int max = 0;
        while (left <= right) {
            if (right < N && cnt[arr[right]] < K) {
                cnt[arr[right]]++;
                right++;
            } else if (cnt[arr[right]] == K) {
                cnt[arr[left]]--;
                left++;
            }
            max = Math.max(max, right - left);
            if (right == N) {
                break;
            }
        }
        System.out.println(max);
    }
}