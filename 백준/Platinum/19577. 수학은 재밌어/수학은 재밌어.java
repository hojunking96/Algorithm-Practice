import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long answer = 0;
        ArrayList<Long> arr = new ArrayList<>();

        for (long i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                arr.add(i);
                if (n / i != i) {
                    arr.add(n / i);
                }
            }
        }
        Collections.sort(arr);
        for (long e : arr) {
            if (e * EulerPhi(e) == n) {
                answer = e;
                break;
            }
        }

        if (answer == 0) {
            answer = -1;
        }
        System.out.println(answer);
    }

    private static long EulerPhi(long n) {
        long pi = n;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                pi = pi / i * (i - 1);
            }
            while (n % i == 0) {
                n /= i;
            }
        }
        if (n != 1) {
            pi = pi / n * (n - 1);
        }
        return pi;
    }

}