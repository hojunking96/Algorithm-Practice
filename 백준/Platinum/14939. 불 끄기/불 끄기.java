import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] dX = {0, -1, 0, 1, 0};
    private static int[] dY = {0, 0, -1, 0, 1};
    private static char[][] board;
    private static char[][] tmpBoard;
    private static List<String> firstLine = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[10][10];
        for (int i = 0; i < 10; i++) {
            board[i] = br.readLine().toCharArray();
        }
        tmpBoard = new char[10][10];

        int answer = 101;

        makeFirstLine(1, "", 1);
        makeFirstLine(1, "", 2);

        for (String e : firstLine) {
            int cnt = 0;
            copy();

            //1번째 줄 선택
            for (int i = 0; i < 10; i++) {
                if (e.charAt(i) == 'O') {
                    pushSwitch(0, i);
                    cnt++;
                }
            }

            //2~9번쨰 줄 선택
            for (int i = 1; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (tmpBoard[i - 1][j] == 'O') {
                        pushSwitch(i, j);
                        cnt++;
                    }
                }
            }

            //10번째 줄 확인
            if (!cannotMake()) {
                answer = Math.min(answer, cnt);
            }
        }
        if (answer == 101) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

    private static void makeFirstLine(int depth, String output, int mode) {
        if (mode == 1) {
            output += 'O';
        } else {
            output += 'X';
        }
        if (depth == 10) {
            firstLine.add(output);
            return;
        }
        for (int i = 0; i < 2; i++) {
            makeFirstLine(depth + 1, output, i);
        }
    }

    private static void copy() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tmpBoard[i][j] = board[i][j];
            }
        }
    }

    private static void pushSwitch(int x, int y) {
        for (int k = 0; k < 5; k++) {
            int nextX = x + dX[k];
            int nextY = y + dY[k];
            if (nextX >= 0 && nextX < 10 && nextY >= 0 && nextY < 10) {
                if (tmpBoard[nextX][nextY] == 'O') {
                    tmpBoard[nextX][nextY] = '#';
                } else {
                    tmpBoard[nextX][nextY] = 'O';
                }
            }
        }
    }

    private static boolean cannotMake() {
        boolean flag = false;
        for (int i = 0; i < 10; i++) {
            if (tmpBoard[9][i] == 'O') {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
