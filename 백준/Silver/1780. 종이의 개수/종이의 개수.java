import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[][] arr;
    private static int answer1;
    private static int answer2;
    private static int answer3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cut(0, 0, N);
        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
    }

    private static void cut(int startX, int startY, int N) {
        if (!needToCut(startX, startY, N)) {
            int key = arr[startX][startY];
            if (key == -1) {
                answer1++;
            } else if (key == 0) {
                answer2++;
            } else {
                answer3++;
            }
            return;
        }
        N /= 3;
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                cut(startX + N * i, startY + N * j, N);
            }
        }
    }

    private static boolean needToCut(int startX, int startY, int N) {
        int key = arr[startX][startY];
        if (N == 1) {
            return false;
        }
        for (int i = startX; i < startX + N; i++) {
            for (int j = startY; j < startY + N; j++) {
                if (arr[i][j] != key) {
                    return true;
                }
            }
        }
        return false;
    }
}