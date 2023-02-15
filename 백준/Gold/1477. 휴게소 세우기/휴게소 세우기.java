import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] T = new int[N + 2];
        T[0] = 0;
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(st.nextToken());
        }
        T[N + 1] = L;
        Arrays.sort(T);
        int left = 1;
        int right = L;
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int i = 1; i <= N + 1; i++) {
                sum += (T[i] - T[i - 1] - 1) / mid;
            }
            if (sum > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}