import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean find(int X[], int low, int high, int k) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (k == X[mid]) {
                return true;
            } else if (k > X[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        int[] X = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(X, 1, N + 1);

        M = Integer.parseInt(br.readLine());
        int[] Y = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            Y[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            if (find(X, 1, N, Y[i]))
                bw.write(1 + "\n");
            else
                bw.write(0 + "\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
