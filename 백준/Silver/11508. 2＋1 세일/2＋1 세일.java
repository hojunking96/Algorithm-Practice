import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private static long[] arr = new long[64];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] C = new Integer[N];
        for (int i = 0; i < N; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(C, Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < C.length; i++) {
            if (i % 3 == 2) {
                continue;
            }
            sum += C[i];
        }
        System.out.println(sum);
    }
}