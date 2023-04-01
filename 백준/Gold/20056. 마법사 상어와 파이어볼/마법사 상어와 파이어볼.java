import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class FireBall {
        int m;
        int s;
        int d;

        public FireBall(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    private static List<FireBall>[][] board;
    private static List<FireBall>[][] tmpBoard;
    private static int N;
    private static int[] dX = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dY = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        board = new List[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            board[r][c].add(new FireBall(m, s, d));
        }

        for (int turn = 0; turn < K; turn++) {

            tmpBoard = new List[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    tmpBoard[i][j] = new ArrayList<>();
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j].size() == 0) {
                        continue;
                    }
                    for (FireBall fireBall : board[i][j]) {
                        move(fireBall, i, j);
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (tmpBoard[i][j].size() >= 2) {
                        split(i, j);
                    }
                }
            }
            board = tmpBoard;
            copyBoard();
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (FireBall fireBall : board[i][j]) {
                    sum += fireBall.m;
                }
            }
        }
        System.out.println(sum);
    }

    private static void copyBoard() {
        board = new List[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = new ArrayList<>();
                for (FireBall fireBall : tmpBoard[i][j]) {
                    board[i][j].add(fireBall);
                }
            }
        }
    }

    private static void split(int x, int y) {
        int newM = 0;
        int newS = 0;

        for (FireBall fireBall : tmpBoard[x][y]) {
            newM += fireBall.m;
            newS += fireBall.s;
        }
        newM /= 5;
        if (newM == 0) {
            tmpBoard[x][y] = new ArrayList<>();
            return;
        }
        newS /= tmpBoard[x][y].size();


        if (isAllEven(x, y) || isAllOdd(x, y)) {
            tmpBoard[x][y] = new ArrayList<>();
            tmpBoard[x][y].add(new FireBall(newM, newS, 0));
            tmpBoard[x][y].add(new FireBall(newM, newS, 2));
            tmpBoard[x][y].add(new FireBall(newM, newS, 4));
            tmpBoard[x][y].add(new FireBall(newM, newS, 6));
        } else {
            tmpBoard[x][y] = new ArrayList<>();
            tmpBoard[x][y].add(new FireBall(newM, newS, 1));
            tmpBoard[x][y].add(new FireBall(newM, newS, 3));
            tmpBoard[x][y].add(new FireBall(newM, newS, 5));
            tmpBoard[x][y].add(new FireBall(newM, newS, 7));
        }
    }

    private static boolean isAllEven(int x, int y) {
        for (FireBall fireBall : tmpBoard[x][y]) {
            if (fireBall.d % 2 == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAllOdd(int x, int y) {
        for (FireBall fireBall : tmpBoard[x][y]) {
            if (fireBall.d % 2 == 0) {
                return false;
            }
        }
        return true;
    }


    private static void move(FireBall now, int x, int y) {
        int nextX = x + dX[now.d] * now.s;
        int nextY = y + dY[now.d] * now.s;
        nextX %= N;
        nextY %= N;
        if (nextX < 0) {
            nextX += N;
        }
        if (nextY < 0) {
            nextY += N;
        }
        tmpBoard[nextX][nextY].add(now);
    }
}
