import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class XY {
        int x;
        int y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static char[][] graph;
    public static boolean[][] visited;
    public static int[] dX = {-1, 0, 0, 1};
    public static int[] dY = {0, 1, -1, 0};
    public static boolean hasChanged;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String input = br.readLine();
            for (int j = 0; j < 6; j++) {
                graph[i][j] = input.charAt(j);
            }
        }
        int cnt = 0;
        while (true) {
            hasChanged = false;
            visited = new boolean[12][6];
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (graph[i][j] != '.') {
                        BFS(new XY(i, j));
                    }
                }
            }
            if (!hasChanged) {
                break;
            }
            goDown();
            cnt++;
        }
        System.out.print(cnt);
    }

    public static void BFS(XY start) {
        Queue<XY> q = new LinkedList<>();
        List<XY> temp = new ArrayList<>();
        q.add(start);
        temp.add(start);
        visited[start.x][start.y] = true;
        int cnt = 0;
        char mainColor = graph[start.x][start.y];

        while (!q.isEmpty()) {
            XY now = q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dX[i];
                int nextY = now.y + dY[i];

                if (nextX < 0 || nextX >= 12 || nextY < 0 || nextY >= 6) {
                    continue;
                }
                if (!visited[nextX][nextY] && graph[nextX][nextY] == mainColor) {
                    visited[nextX][nextY] = true;
                    q.add(new XY(nextX, nextY));
                    temp.add(new XY(nextX, nextY));
                }
            }
        }
        if (cnt >= 4) {
            for (int i = 0; i < cnt; i++) {
                XY now = temp.get(i);
                graph[now.x][now.y] = '.';
            }
            hasChanged = true;
        }
    }

    public static void goDown() {
        for (int j = 0; j < 6; j++) {
            List<Character> arr = new ArrayList<>();
            for (int i = 11; i >= 0; i--) {
                if (graph[i][j] != '.') {
                    arr.add(graph[i][j]);
                }
            }
            for (int i = 0; i < arr.size(); i++) {
                graph[11 - i][j] = arr.get(i);
            }
            for (int i = 11 - arr.size(); i >= 0; i--) {
                graph[i][j] = '.';
            }
        }
    }
}
