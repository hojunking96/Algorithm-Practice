import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        long left = 1;
        long right = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > right) {
                right = arr[i];
            }
        }
        int M = Integer.parseInt(br.readLine());
        while (left <= right) {
            long mid = (right + left) / 2;
            long sum = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j] < mid) {
                    sum += arr[j];
                } else {
                    sum += mid;
                }
            }
            if (sum > M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(right);
    }
}