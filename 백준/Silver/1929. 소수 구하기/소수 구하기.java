import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        findPrimeNumber(M, N);
    }

    public static void findPrimeNumber(int M, int N) {
        int[] numbers = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            numbers[i] = i;
        }
        checkPrimeNumber(N, numbers);
        for (int i = M; i <= N; i++) {
            if (numbers[i] != 0)
                System.out.println(numbers[i]);
        }
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
