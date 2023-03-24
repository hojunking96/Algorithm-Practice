import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[][] arr;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        make(arr, 0, 0);
        System.out.println(min);
    }

    private static void make(int[][] result, int x, int y) {
        int[][] tmp = new int[N][M];
        init(tmp, result);
        if (x == N - 1 && y == M) {
            min = Math.min(min, count(tmp));
            return;
        }
        if (y == M) {
            x++;
            y = 0;
        }
        for (int j = y; j < M; j++) {
            if (arr[x][j] >= 1 && arr[x][j] <= 5) {
                change(arr[x][j], tmp, x, j);
            }
        }
        if (x < N - 1) {
            for (int i = x + 1; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] >= 1 && arr[i][j] <= 5) {
                        change(arr[i][j], tmp, i, j);
                    }
                }
            }
        }
        min = Math.min(min, count(tmp));
    }

    private static void init(int[][] tmp, int[][] result) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = result[i][j];
            }
        }
    }

    private static void change(int func, int[][] result, int x, int y) {

        switch (func) {
            case 1:
                for (int i = 1; i <= 4; i++) {
                    int[][] tmp = new int[N][M];
                    init(tmp, result);
                    func1(tmp, i, x, y);
                    make(tmp, x, y + 1);
                }
                break;
            case 2:
                for (int i = 1; i <= 2; i++) {
                    int[][] tmp = new int[N][M];
                    init(tmp, result);
                    func2(tmp, i, x, y);
                    make(tmp, x, y + 1);
                }
                break;
            case 3:
                for (int i = 1; i <= 4; i++) {
                    int[][] tmp = new int[N][M];
                    init(tmp, result);
                    func3(tmp, i, x, y);
                    make(tmp, x, y + 1);
                }
                break;
            case 4:
                for (int i = 1; i <= 4; i++) {
                    int[][] tmp = new int[N][M];
                    init(tmp, result);
                    func4(tmp, i, x, y);
                    make(tmp, x, y + 1);
                }
                break;
            case 5:
                int[][] tmp = new int[N][M];
                init(tmp, result);
                func5(tmp, x, y);
                make(tmp, x, y + 1);
                break;
            default:
                break;
        }
    }

    private static void func1(int[][] result, int func, int x, int y) {
        switch (func) {
            case 1:
                for (int i = x - 1; i >= 0; i--) {
                    if (result[i][y] == 6) {
                        return;
                    }
                    if (result[i][y] == 0) {
                        result[i][y] = -1;
                    }
                }
                break;
            case 2:
                for (int i = x + 1; i < N; i++) {
                    if (result[i][y] == 6) {
                        return;
                    }
                    if (result[i][y] == 0) {
                        result[i][y] = -1;
                    }
                }
                break;
            case 3:
                for (int i = y - 1; i >= 0; i--) {
                    if (result[x][i] == 6) {
                        return;
                    }
                    if (result[x][i] == 0) {
                        result[x][i] = -1;
                    }
                }
                break;
            case 4:
                for (int i = y + 1; i < M; i++) {
                    if (result[x][i] == 6) {
                        return;
                    }
                    if (result[x][i] == 0) {
                        result[x][i] = -1;
                    }
                }
                break;
            default:
                break;
        }
    }

    private static void func2(int[][] result, int func, int x, int y) {
        switch (func) {
            case 1:
                func1(result, 1, x, y);
                func1(result, 2, x, y);
                break;
            case 2:
                func1(result, 3, x, y);
                func1(result, 4, x, y);
                break;
            default:
                break;
        }
    }

    private static void func3(int[][] result, int func, int x, int y) {
        switch (func) {
            case 1:
                func1(result, 1, x, y);
                func1(result, 3, x, y);
                break;
            case 2:
                func1(result, 1, x, y);
                func1(result, 4, x, y);
                break;
            case 3:
                func1(result, 2, x, y);
                func1(result, 3, x, y);
                break;
            case 4:
                func1(result, 2, x, y);
                func1(result, 4, x, y);
                break;
            default:
                break;
        }
    }

    private static void func4(int[][] result, int func, int x, int y) {
        switch (func) {
            case 1:
                func2(result, 1, x, y);
                func1(result, 3, x, y);
                break;
            case 2:
                func2(result, 1, x, y);
                func1(result, 4, x, y);
                break;
            case 3:
                func2(result, 2, x, y);
                func1(result, 1, x, y);
                break;
            case 4:
                func2(result, 2, x, y);
                func1(result, 2, x, y);
                break;
            default:
                break;
        }
    }

    private static void func5(int[][] result, int x, int y) {
        func2(result, 1, x, y);
        func2(result, 2, x, y);
    }

    private static int count(int[][] result) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (result[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}