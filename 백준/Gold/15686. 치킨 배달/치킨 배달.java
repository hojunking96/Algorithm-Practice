import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Chicken {
        int x;
        int y;

        public Chicken(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int N;
    private static int M;
    private static int[][] arr;
    private static boolean[] visited;
    private static List<Chicken> chickens = new ArrayList<>();
    private static Chicken[] chickenList;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        chickenList = new Chicken[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    chickens.add(new Chicken(i, j));
                }
            }
        }

        visited = new boolean[chickens.size()];

        combination(0, 0);
        System.out.println(answer);
    }

    private static void combination(int depth, int start) {
        if (depth == M) {
            answer = Math.min(answer, sumMinChicken());
            return;
        }
        for (int i = start; i < chickens.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                chickenList[depth] = chickens.get(i);
                combination(depth + 1, i);
                visited[i] = false;
            }
        }
    }
    private static int sumMinChicken() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    sum += minChicken(i, j);
                }
            }
        }
        return sum;
    }

    private static int minChicken(int x, int y) {
        int min = Integer.MAX_VALUE;
        for (Chicken e : chickenList) {
            min = Math.min(min, calculate(x, y, e.x, e.y));
        }
        return min;
    }

    private static int calculate(int hX, int hY, int cX, int cY) {
        return Math.abs(hX - cX) + Math.abs(hY - cY);
    }
}
