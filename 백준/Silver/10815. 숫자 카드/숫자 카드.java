import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int k = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = N - 1;
            int answer = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] > k) {
                    right = mid - 1;
                } else if (arr[mid] < k) {
                    left = mid + 1;
                } else {
                    answer = 1;
                    break;
                }
            }
            sb.append(answer).append(" ");
        }
        System.out.println(sb);
    }
}