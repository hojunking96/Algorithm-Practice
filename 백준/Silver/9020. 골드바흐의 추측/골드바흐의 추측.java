import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean isNotPrime[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        isNotPrime = new boolean[10001];
        init();
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            partition(k);
        }
    }

    public static void init() {
        isNotPrime[1] = false;
        for (int i = 2; i <= 10000; i++) {
            if (isNotPrime[i] == true)
                continue;
            for (int j = i + i; j <= 10000; j += i) {
                isNotPrime[j] = true;
            }
        }
    }

    public static void partition(int k) {
        int left = k / 2;
        int right = k / 2;
        while (true) {
            if (!isNotPrime[left] && !isNotPrime[right]) {
                System.out.println(left + " " + right);
                break;
            }
            left--;
            right++;
        }
    }

}
