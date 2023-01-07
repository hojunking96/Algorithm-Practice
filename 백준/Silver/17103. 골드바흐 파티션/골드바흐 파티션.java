import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean[] isNotPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isNotPrime = new boolean[1000001];
        int T = Integer.parseInt(br.readLine());
        checkPrime();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(count(N));
        }
    }

    public static int count(int N) {
        int cnt = 0;
        for (int i = 1; i <= N / 2; i++) {
            if (!isNotPrime[i] && !isNotPrime[N - i])
                cnt++;
        }
        return cnt;
    }

    public static void checkPrime() {
        isNotPrime[1] = true;
        isNotPrime[2] = false;
        for (int i = 2; i < 1000001; i++) {
            if (!isNotPrime[i])
                for (int j = i + i; j < 1000001; j += i) {
                    isNotPrime[j] = true;
                }
        }
    }

}
