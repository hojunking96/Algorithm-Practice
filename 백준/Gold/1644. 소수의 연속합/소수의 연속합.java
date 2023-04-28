import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] isNotPrime = new boolean[n + 1];

        List<Integer> primeNums = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                for (int j = i + i; j <= n; j += i) {
                    isNotPrime[j] = true;
                }
                primeNums.add(i);
            }
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int cnt = 0;
        while (true) {
            if (sum >= n) {
                sum -= primeNums.get(left++);
            } else if (right == primeNums.size()) {
                break;
            } else {
                sum += primeNums.get(right++);
            }
            if (n == sum) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}