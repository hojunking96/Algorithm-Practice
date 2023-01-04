import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean isNotPrime[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isNotPrime = new boolean[1000001];
        init();
        while (true) {
            int k = Integer.parseInt(br.readLine());
            if (k == 0)
                break;
            partition(k);
        }
    }

    public static void init() {
        isNotPrime[1] = false;
        for (int i = 2; i <= 1000000; i++) {
            if (isNotPrime[i] == true)
                continue;
            for (int j = i + i; j <= 1000000; j += i) {
                isNotPrime[j] = true;
            }
        }
    }

    public static void partition(int k) {
        int left = 3;
        int right = k - 3;
        while (true) {
            if (!isNotPrime[left] && !isNotPrime[right]) {
                System.out.println(k + " = " + left + " + " + right);
                break;
            }
            left++;
            right--;
            if (left > k / 2) {
                System.out.println("Goldbach's conjecture is wrong.");
                break;
            }
        }
    }

}
