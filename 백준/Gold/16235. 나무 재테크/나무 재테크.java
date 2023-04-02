import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int[] dX = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dY = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static int[][] A;
    private static int[][] B;
    private static List<Integer>[][] board;
    private static List<Integer> tmpList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        B = new int[N][N];
        board = new List[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                board[i][j] = new ArrayList<>();
                B[i][j] = 5;
            }
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            board[x][y].add(z);
        }

        for (int year = 0; year < K; year++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int nextB = 0;
                    Collections.sort(board[i][j]);
                    tmpList = new ArrayList<>();
                    for (Integer e : board[i][j]) {
                        if (B[i][j] >= e) {
                            B[i][j] -= e;
                            tmpList.add(e + 1);
                        } else {
                            nextB += e / 2;
                        }
                    }
                    board[i][j] = new ArrayList<>();
                    B[i][j] += nextB;
                    for (int k = 0; k < tmpList.size(); k++) {
                        board[i][j].add(tmpList.get(k));
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (Integer age : board[i][j]) {
                        if (age % 5 == 0) {
                            for (int t = 0; t < 8; t++) {
                                int nextX = i + dX[t];
                                int nextY = j + dY[t];
                                if (nextX >= 0 && nextX <= N - 1 && nextY >= 0 && nextY <= N - 1) {
                                    board[nextX][nextY].add(1);
                                }
                            }
                        }
                    }
                    B[i][j] += A[i][j];
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt += board[i][j].size();
            }
        }
        System.out.println(cnt);
    }
}