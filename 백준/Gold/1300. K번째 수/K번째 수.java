import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        long left = 1;
        long right = k;
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}