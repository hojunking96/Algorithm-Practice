import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long answer = 0;
        for (int i = 0; i < N; i++) {
            long max = calc(i, arr[i]);
            long min = calc(N - i - 1, arr[i]);
            answer += max - min;
            answer %= 1_000_000_007;
            if (answer < 0) {
                answer += 1_000_000_007;
            }
        }
        System.out.println(answer);
    }

    private static long calc(int cnt, long num) {
        for (int i = 0; i < cnt; i++) {
            num *= 2;
            num %= 1_000_000_007;
        }
        return num;
    }
}