import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] X = new long[N + 1];
        long[] Y = new long[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }
        X[N] = X[0];
        Y[N] = Y[0];

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += X[i] * Y[i + 1] - X[i + 1] * Y[i];
        }
        double answer = (double) Math.abs(sum) / 2;
        System.out.println(String.format("%.1f", Math.abs(answer)));
    }
}