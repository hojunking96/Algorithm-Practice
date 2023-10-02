import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int n, m;
    private static boolean[][] A, B;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new boolean[n][m];
        B = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == '1') {
                    A[i][j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                if (input.charAt(j) == '1') {
                    B[i][j] = true;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j >= m - 2 || i >= n - 2) {
                    if (A[i][j] != B[i][j]) {
                        System.out.println(-1);
                        return;
                    }
                }
                if (A[i][j] != B[i][j]) {
                    doJob(new Node(i, j));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void doJob(Node start) {
        for (int i = start.x; i < start.x + 3; i++) {
            for (int j = start.y; j < start.y + 3; j++) {
                A[i][j] = !A[i][j];
            }
        }
    }

}
