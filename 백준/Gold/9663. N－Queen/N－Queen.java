import java.io.*;


public class Main {
    public static int cnt = 0;
    public static int N;
    public static int[][] chessBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        chessBoard = new int[N][N];
        count(0);
        System.out.println(cnt);
    }

    public static void count(int columnCnt) {
        if (columnCnt == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (chessBoard[i][columnCnt] == 0) {
                mark(i, columnCnt);
                count(columnCnt + 1);
                unMark(i, columnCnt);
            }
        }
    }

    public static void mark(int row, int column) {
        int k = column + 1;
        while (k < N) {
            chessBoard[row][k]++;
            k++;
        }
        int i = 1;
        while (row - i >= 0 && column + i < N) {
            chessBoard[row - i][column + i]++;
            i++;
        }
        i = 1;
        while (row + i < N && column + i < N) {
            chessBoard[row + i][column + i]++;
            i++;
        }
    }

    public static void unMark(int row, int column) {
        int k = column + 1;
        while (k < N) {
            chessBoard[row][k]--;
            k++;
        }
        int i = 1;
        while (row - i >= 0 && column + i < N) {
            chessBoard[row - i][column + i]--;
            i++;
        }
        i = 1;
        while (row + i < N && column + i < N) {
            chessBoard[row + i][column + i]--;
            i++;
        }
    }
}