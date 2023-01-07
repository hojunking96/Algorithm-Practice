import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        int[] diff = new int[N - 1];
        for (int i = 0; i < N - 1; i++)
            diff[i] = Math.abs(nums[i] - nums[i + 1]);
        int gcd = diff[0];
        for (int i = 1; i < N - 1; i++)
            gcd = findGCD(gcd, diff[i]);
        for (int i = 2; i <= gcd; i++) {
            if (gcd % i == 0)
                System.out.print(i + " ");
        }
    }

    private static int findGCD(int num1, int num2) {
        int tmp, n;
        if (num1 < num2) {
            tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        while (num2 != 0) {
            n = num1 % num2;
            num1 = num2;
            num2 = n;
        }
        return num1;
    }
}
