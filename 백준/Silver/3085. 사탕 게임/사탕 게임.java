import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static char[][] board;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        answer = Math.max(rowSearch(0, N - 1), columnSearch(0, N - 1));

        changeRow();
        changeColumn();

        System.out.println(answer);
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
    }

    private static void changeRow() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] != board[i][j + 1]) {
                    swap(i, j, i, j + 1);
                    answer = Math.max(answer, columnSearch(j, j + 1));
                    answer = Math.max(answer, rowSearch(i,i));
                    swap(i, j, i, j + 1);
                }
            }
        }
    }

    private static void changeColumn() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (board[j][i] != board[j + 1][i]) {
                    swap(j, i, j + 1, i);
                    answer = Math.max(answer, rowSearch(j, j + 1));
                    answer = Math.max(answer, columnSearch(i,i));
                    swap(j, i, j + 1, i);
                }
            }
        }
    }

    private static int columnSearch(int start, int end) {
        int max = 0;
        int cnt = 0;
        for (int i = start; i <= end; i++) {
            cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }
        return Math.max(max, cnt);
    }

    private static int rowSearch(int start, int end) {
        int max = 0;
        int cnt = 0;
        for (int i = start; i <= end; i++) {
            cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }
        return Math.max(max, cnt);
    }
}
