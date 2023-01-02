import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        System.out.println(count(nums));
    }

    public static int count(int[] nums) {
        int cnt = 0;
        for (int e : nums) {
            if (e != 1 && isPrimeNum(e))
                cnt++;
        }
        return cnt;
    }

    public static boolean isPrimeNum(int key) {
        for (int i = 2; i <= key / 2; i++)
            if (key % i == 0)
                return false;
        return true;
    }
}
