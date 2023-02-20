import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final StringBuilder sb = new StringBuilder();
    private static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            int length = 1;
            int k = Integer.parseInt(input);
            for (int i = 0; i < k; i++) {
                length *= 3;
            }
            arr = new boolean[length];
            check(0, length, length);
            for (int i = 0; i < length; i++) {
                if (!arr[i]) {
                    sb.append("-");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void check(int start, int end, int N) {
        if (N == 1) {
            return;
        }
        N /= 3;
        for (int i = start + N; i < end - N; i++) {
            arr[i] = true;
        }
        check(start, start + N, N);
        check(end - N, end, N);
    }
}