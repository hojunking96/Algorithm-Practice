import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String answer = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int len1 = str1.length;
        int len2 = str2.length;

        int[][] dp = new int[len1 + 1][len2 + 1];


        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (str1[i] == str2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        int x = len1;
        int y = len2;

        while (x != 0 && y != 0) {
            if (dp[x - 1][y] == dp[x][y]) { // 왼쪽값과 같다
                x--;
            } else if (dp[x][y - 1] == dp[x][y]) { // 윗쪽값과 같다.
                y--;
            } else { // 왼쪽값과 윗쪽값과 같은 경우가 없다.
                answer = str1[x - 1] + answer;
                x--;
                y--;
            }
        }
        int max = dp[len1][len2];
        System.out.println(max);
        if (max != 0) {
            System.out.println(answer);
        }
    }
}
