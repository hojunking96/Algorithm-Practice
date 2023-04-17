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
        tmpBoard = new char[10][10];
        for (int i = 0; i < 10; i++) {
            board[i] = br.readLine().toCharArray();
        }
        int answer = 101;
        int cnt;

        makeFirstLine(1, "", 1);
        makeFirstLine(1, "", 2);

        for (int t = 0; t < 1024; ++t) {

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    tmpBoard[i][j] = board[i][j];
                }
            }
            cnt = 0;

            String e = firstLine.get(t);
//            String e = "OOOOOOOOOO";
            for (int i = 0; i < 10; i++) {
                if (e.charAt(i) == 'O') {
                    for (int k = 0; k < 5; k++) {
                        int nextX = 0 + dX[k];
                        int nextY = i + dY[k];
                        if (nextX >= 0 && nextX < 10 && nextY >= 0 && nextY < 10) {
                            if (tmpBoard[nextX][nextY] == 'O') {
                                tmpBoard[nextX][nextY] = '#';
                            } else {
                                tmpBoard[nextX][nextY] = 'O';
                            }
                        }
                    }
                    cnt++;
                }
            }


            for (int i = 1; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (tmpBoard[i - 1][j] == 'O') {
                        for (int k = 0; k < 5; k++) {
                            int nextX = i + dX[k];
                            int nextY = j + dY[k];
                            if (nextX >= 0 && nextX < 10 && nextY >= 0 && nextY < 10) {
                                if (tmpBoard[nextX][nextY] == 'O') {
                                    tmpBoard[nextX][nextY] = '#';
                                } else {
                                    tmpBoard[nextX][nextY] = 'O';
                                }
                            }
                        }
                        cnt++;
                    }
                }
            }

            boolean flag = false;
            for (int i = 0; i < 10; i++) {
                if (tmpBoard[9][i] == 'O') {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                answer = Math.min(answer, cnt);
            }
        }
        if (answer == 101) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

    private static void makeFirstLine(int depth, String output, int mod) {
        if (mod == 1) {
            output += 'O';
        } else {
            output += '#';
        }
        if (depth == 10) {
            firstLine.add(output);
            return;
        }
        makeFirstLine(depth + 1, output, 1);
        makeFirstLine(depth + 1, output, 2);
    }
}

/*

O########O
#OOOOOOOO#
#OOOOOOOO#
#OOOOOOOO#
#OOOOOOOO#
#OOOOOOOO#
#OOOOOOOO#
#OOOOOOOO#
#OOOOOOOO#
O########O


 */