import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int N;
    private static int[] dX = {0, -1, 0, 1};
    private static int[] dY = {1, 0, -1, 0};
    private static boolean[][] isDragonCurve;
    private static List<Integer>[] directions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isDragonCurve = new boolean[101][101];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            makeDirections(d, g);
            makeDragonCurve(new Node(y, x), g);

        }
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (isDragonCurve[i][j] && isDragonCurve[i + 1][j] && isDragonCurve[i][j + 1] && isDragonCurve[i + 1][j + 1]) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void makeDirections(int d, int g) {
        directions = new List[g + 1];
        for (int i = 0; i <= g; i++) {
            directions[i] = new ArrayList<>();
        }
        directions[0].add(d);

        for (int i = 1; i <= g; i++) {
            for (int j = 0; j < directions[i - 1].size(); j++) {
                directions[i].add(directions[i - 1].get(j));
            }
            for (int j = directions[i - 1].size() - 1; j >= 0; j--) {
                int e = directions[i - 1].get(j);
                if (e == 3) {
                    e = -1;
                }
                directions[i].add(e + 1);
            }
        }
    }

    private static void makeDragonCurve(Node start, int g) {
        isDragonCurve[start.x][start.y] = true;
        for (int i = 0; i < directions[g].size(); i++) {
            int nextX = start.x + dX[directions[g].get(i)];
            int nextY = start.y + dY[directions[g].get(i)];
            isDragonCurve[nextX][nextY] = true;
            start.x = nextX;
            start.y = nextY;
        }
    }
}