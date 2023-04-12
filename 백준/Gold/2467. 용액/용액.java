import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int num1, num2;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (min > Math.abs(sum)) {
                num1 = arr[left];
                num2 = arr[right];
                min = Math.abs(sum);
                if (min == 0) {
                    break;
                }
            }
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        System.out.println(num1 + " " + num2);
    }
}