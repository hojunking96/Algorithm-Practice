import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static boolean[] visited;
    private static int[] dX = {-1, 0, 1, 0};
    private static int[] dY = {0, -1, 0, 1};
    private static int R, C;
    private static char[][] arr;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        visited[arr[0][0] - 'A'] = true;
        DFS(0, 0, 1);
        System.out.println(max);
    }

    private static void DFS(int nowX, int nowY, int depth) {
        for (int i = 0; i < 4; i++) {
            int nextX = nowX + dX[i];
            int nextY = nowY + dY[i];
            if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) {
                continue;
            }
            if (!visited[arr[nextX][nextY] - 'A']) {
                visited[arr[nextX][nextY] - 'A'] = true;
                DFS(nextX, nextY, depth + 1);
                visited[arr[nextX][nextY] - 'A'] = false;
            }
        }
        max = Math.max(max, depth);
    }
}