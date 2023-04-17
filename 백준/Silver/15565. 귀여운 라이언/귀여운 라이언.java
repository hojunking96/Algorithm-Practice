import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[N];
        int min = Integer.MAX_VALUE;

        st = new StringTokenizer(br.readLine());
        int cnt1 = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < N; i++) {
            String k = st.nextToken();
            if (k.equals("1")) {
                arr[i] = true;
                cnt1++;
                if (cnt1 == 1) {
                    left = i;
                    right = i;
                }
            }
        }
        if (cnt1 < K) {
            System.out.println(-1);
            return;
        }

        int cnt = 0;
        while (right < N) {
            if (arr[right]) {
                cnt++;
                if (cnt == K) {
                    min = Math.min(min, right - left + 1);
                    if (min == K) {
                        System.out.println(min);
                        return;
                    }
                    left++;
                    while (left <= right && !arr[left]) {
                        left++;
                    }
                    cnt--;
                }
            }
            right++;
        }
           System.out.println(min);
        
    }
}