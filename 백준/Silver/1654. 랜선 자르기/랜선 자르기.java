import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        int K, N;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[] X = new int[K];
        long max = 0, min = 1;

        for (int i = 0; i < K; i++) {
            X[i] = Integer.parseInt(br.readLine());
            if (max < X[i])
                max = X[i];
        }
        max++;
        if (N == 1 && K == 1)
            bw.write(X[0] + "\n");
        else {
            while (min < max) {
                long mid = (max - min) / 2 + min;
                int count = 0;
                for (int i = 0; i < K; i++) {
                    count += X[i] / mid;
                }
                if (count < N)
                    max = mid;
                else
                    min = mid + 1;
            }
            bw.write(min - 1 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}