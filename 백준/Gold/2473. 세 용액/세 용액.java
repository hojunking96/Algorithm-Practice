import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static int[] arr;
    private static long min = 3000000000L;
    private static int min1, min2, min3;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        min1 = 0;
        min2 = 0;
        min3 = 0;
        for (int i = 0; i < N - 2; i++) {
            binarySearch(i, i + 1);
        }
        System.out.println(arr[min1] + " " + arr[min2] + " " + arr[min3]);
    }

    private static void binarySearch(int std, int left) {
        int right = N - 1;
        while (left < right) {
            long sum = (long) arr[std] + (long) arr[left] + (long) arr[right];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                min1 = std;
                min2 = left;
                min3 = right;
            }
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
    }
}