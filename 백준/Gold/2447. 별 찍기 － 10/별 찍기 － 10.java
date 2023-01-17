import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static StringBuilder sb;
    public static boolean[][] board;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        board = new boolean[N][N];
        makeStar(0, 0, N);
        color(N);
        System.out.println(sb);

    }

    public static void color(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!board[i][j])
                    sb.append("*");
                else
                    sb.append(" ");
            }
            sb.append("\n");
        }
    }

    public static void makeStar(int xStart, int yStart, int size) {
        if (size == 1) {
            return;
        }
        for (int i = xStart + size / 3; i < xStart + size / 3 * 2; i++) {
            for (int j = yStart + size / 3; j < yStart + size / 3 * 2; j++) {
                board[i][j] = true;
            }
        }
        makeStar(xStart, yStart, size / 3);
        makeStar(xStart, yStart + size / 3, size / 3);
        makeStar(xStart, yStart + size / 3 * 2, size / 3);

        makeStar(xStart + size / 3, yStart, size / 3);
        makeStar(xStart + size / 3, yStart + size / 3, size / 3);
        makeStar(xStart + size / 3, yStart + size / 3 * 2, size / 3);

        makeStar(xStart + size / 3 * 2, yStart, size / 3);
        makeStar(xStart + size / 3 * 2, yStart + size / 3, size / 3);
        makeStar(xStart + size / 3 * 2, yStart + size / 3 * 2, size / 3);


    }
}