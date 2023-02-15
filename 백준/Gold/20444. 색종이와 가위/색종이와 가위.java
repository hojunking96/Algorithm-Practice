import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long left = 0;
        long right = n / 2;
        while (left <= right) {
            //한 쪽을 기준으로 자른 횟수 기억
            long row = (left + right) / 2;
            long column = n - row;
            long totalCnt = (row + 1) * (column + 1);
            if (totalCnt == k) {
                System.out.println("YES");
                return;
            } else if (totalCnt > k) {
                right = row - 1;
            } else {
                left = row + 1;
            }
        }
        System.out.println("NO");
    }
}