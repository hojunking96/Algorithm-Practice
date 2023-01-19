import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static int[][] S;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = new int[9][9];
        sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int k = Integer.parseInt(st.nextToken());
                S[i][j] = k;
            }
        }
        DFS(0, 0);
    }

    public static void printSudoku() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(S[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void DFS(int x, int y) {
        if (y == 9) {
            DFS(x + 1, 0);
            return;
        }
        if (x == 9) {
            printSudoku();
            System.exit(0);
        }
        if (S[x][y] == 0) {
            for (int k = 1; k <= 9; k++) {
                if (possible(x, y, k)) {
                    S[x][y] = k;
                    DFS(x, y + 1);
                }
            }
            S[x][y] = 0;
            return;
        }
        DFS(x, y + 1);
    }

    public static boolean possible(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (S[x][i] == value)
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (S[i][y] == value)
                return false;
        }
        int xStart = x / 3 * 3;
        int yStart = y / 3 * 3;
        for (int i = xStart; i < xStart + 3; i++) {
            for (int j = yStart; j < yStart + 3; j++) {
                if (S[i][j] == value)
                    return false;
            }
        }
        return true;
    }
}