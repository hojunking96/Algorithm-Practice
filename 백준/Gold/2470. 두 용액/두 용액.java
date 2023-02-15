import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(T);
        int left = 0;
        int right = N - 1;
        int sum;
        int answerLeft = 0;
        int answerRight = 0;
        int min = Integer.MAX_VALUE;
        while (left < right) {
            sum = T[left] + T[right];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                answerLeft = left;
                answerRight = right;
            }
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(T[answerLeft] + " " + T[answerRight]);
    }
}