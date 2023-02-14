import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];

        long left = 1;
        long right = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > right) {
                right = arr[i];
            }
        }
        while (left <= right) {
            long mid = (right + left) / 2;
            long sum = 0;
            for (int j = 0; j < K; j++) {
                if (arr[j] >= mid) {
                    sum += arr[j] / mid;
                }
            }
            if (sum < N) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(right);
    }
}