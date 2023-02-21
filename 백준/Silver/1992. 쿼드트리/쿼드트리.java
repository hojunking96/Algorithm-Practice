import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final StringBuilder sb = new StringBuilder();
    private static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = input[j] == '1';
            }
        }
        makeQuadTree(0, 0, N);
        System.out.println(sb);
    }

    public static void makeQuadTree(int startX, int startY, int N) {
        boolean key = arr[startX][startY];
        if (isAllSame(startX, startY, N, key)) {
            if (arr[startX][startY]) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            return;
        }
        N /= 2;
        sb.append("(");
        makeQuadTree(startX, startY, N);
        makeQuadTree(startX, startY + N, N);
        makeQuadTree(startX + N, startY, N);
        makeQuadTree(startX + N, startY + N, N);
        sb.append(")");
    }

    private static boolean isAllSame(int startX, int startY, int N, boolean key) {
        for (int i = startX; i < startX + N; i++) {
            for (int j = startY; j < startY + N; j++) {
                if (arr[i][j] != key) {
                    return false;
                }
            }
        }
        return true;
    }
}