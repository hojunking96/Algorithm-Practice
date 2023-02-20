import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int k = recurDivide(N, arr);
        System.out.println(k);
    }

    private static int recurDivide(int N, int[][] arr) {
        if (N == 1) {
            return arr[0][0];
        }
        int[][] newArr = new int[N / 2][N / 2];
        int row = 0;
        int col;
        for (int i = 0; i < N; i += 2) {
            col = 0;
            for (int j = 0; j < N; j += 2) {
                int value = secondBiggest(i, j, arr);
                newArr[row][col] = value;
                col++;
            }
            row++;
        }
        return recurDivide(N / 2, newArr);
    }

    private static int secondBiggest(int startX, int startY, int[][] arr2) {
        int[] tmp = new int[4];
        tmp[0] = arr2[startX][startY];
        tmp[1] = arr2[startX + 1][startY];
        tmp[2] = arr2[startX][startY + 1];
        tmp[3] = arr2[startX + 1][startY + 1];
        Arrays.sort(tmp);
        return tmp[2];
    }

}