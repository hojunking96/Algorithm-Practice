import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static long cnt = 0;
    private static int N;
    private static int[] A;
    private static int[] B;
    private static int[] C;
    private static int[] D;
    private static int[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        C = new int[N];
        D = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
        sum = new int[2][N * N];
        int ptr = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum[0][ptr] = A[i] + B[j];
                sum[1][ptr] = C[i] + D[j];
                ptr++;
            }
        }
        Arrays.sort(sum[1]);
        for (int key : sum[0]) {
            int upper = upperBound(sum[1], -key);
            int lower = lowerBound(sum[1], -key);
            cnt += (upper - lower); //개수를 의미
        }
        System.out.println(cnt);
    }

    private static int upperBound(int[] arr, int find) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= find) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private static int lowerBound(int[] arr, int find) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < find) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}