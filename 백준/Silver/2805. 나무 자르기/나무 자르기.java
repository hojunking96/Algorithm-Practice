import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] X = new int[N];
        int low = 0;
        int high = 0;
        long sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
            if (X[i] > high)
                high = X[i];
        }
        Arrays.sort(X);
        high++;

        while (low < high) {
            int mid = (high - low) / 2 + low;
            sum = 0;
            for (int i = 0; i < N; i++)
                if (X[i] > mid)
                    sum += X[i] - mid;
            if (sum < M)
                high = mid;
            else
                low = mid + 1;
        }
        bw.write(low - 1 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
