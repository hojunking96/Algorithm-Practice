import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] score = new int[2][n];
            for (int r = 0; r < 2; r++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    score[r][j] = Integer.parseInt(st.nextToken());
                }
            }
            if (n >= 2) {
                score[0][1] = score[1][0] + score[0][1];
                score[1][1] = score[0][0] + score[1][1];
            }
            for (int j = 2; j < n; j++) {
                score[0][j] = Math.max(score[1][j - 1], score[1][j - 2]) + score[0][j];
                score[1][j] = Math.max(score[0][j - 1], score[0][j - 2]) + score[1][j];
            }
            sb.append(Math.max(score[0][n - 1], score[1][n - 1])).append("\n");
        }
        System.out.println(sb);
    }
}