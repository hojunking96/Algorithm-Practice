import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            long n = Long.parseLong(br.readLine());
            if (n == 0) {
                break;
            }
            if (n == 1) {
                sb.append("0\n");
                continue;
            }
            sb.append(EulerPhi(n)).append("\n");
        }
        System.out.println(sb);
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