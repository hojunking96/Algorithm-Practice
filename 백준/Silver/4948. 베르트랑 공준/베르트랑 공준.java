import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0)
                break;
            if (N == 1) {
                System.out.println(1);
                continue;
            }
            findPrimeNumber(N + 1, 2 * N - 1);
        }
    }

    public static void findPrimeNumber(int M, int N) {
        int cnt = 0;
        int[] numbers = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            numbers[i] = i;
        }
        checkPrimeNumber(N, numbers);
        for (int i = M; i <= N; i++) {
            if (numbers[i] != 0)
                cnt++;
        }
        System.out.println(cnt);
    }

    public static void checkPrimeNumber(int last, int[] numbers) {
        for (int i = 2; i <= last; i++) {
            if (numbers[i] == 0)
                continue;
            for (int j = i + i; j <= last; j += i)
                numbers[j] = 0;
        }
    }
}
