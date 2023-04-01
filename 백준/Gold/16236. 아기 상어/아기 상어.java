import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x;
        int y;
        int d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    private static int N;
    private static int[] dX = {-1, 0, 0, 1};
    private static int[] dY = {0, -1, 1, 0};
    private static int sharkSize = 2;
    private static int fishCnt = 0;
    private static boolean[][] visited;
    private static int[][][] board;
    private static Node shark;
    private static int ateCnt = 0;
    private static int timeCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int k = Integer.parseInt(st.nextToken());
                board[i][j][0] = k;
                if (k >= 1 && k <= 6) {
                    fishCnt++;
                } else if (k == 9) {
                    shark = new Node(i, j, 0);
                    board[i][j][0] = 0;
                }
            }
        }
        while (true) {
            boolean needMom = true;
            calcDistance(shark);
            int minX = N;
            int minY = N;
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j][0] != 0 && board[i][j][0] < sharkSize && board[i][j][1] != 0) {
                        if (minDistance > board[i][j][1]) {
                            minDistance = board[i][j][1];
                            minX = i;
                            minY = j;
                        }
                        needMom = false;
                    }
                }
            }
            if (needMom) {
                break;
            }
            shark.x = minX;
            shark.y = minY;
            board[minX][minY][0] = 0;
            ateCnt++;
            timeCnt += board[minX][minY][1];
            if (ateCnt == sharkSize) {
                sharkSize++;
                ateCnt = 0;
            }
        }
        System.out.println(timeCnt);
    }

    private static void calcDistance(Node start) {
        visited = new boolean[N][N];
        Queue<Node> q = new LinkedList<>();
        q.add(start);


        visited[start.x][start.y] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dX[i];
                int nextY = now.y + dY[i];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                    continue;
                }
                if (!visited[nextX][nextY] && board[nextX][nextY][0] <= sharkSize) {
                    q.add(new Node(nextX, nextY, now.d + 1));
                    visited[nextX][nextY] = true;
                    board[nextX][nextY][1] = now.d + 1;
                }
            }
        }
    }
}

/*
 *
 *       6 15 / 1 6 3 / 2 4 2 5 / 4
 *      21 / 10  / 13 /4
 *  31 17
 * 48
 *
 * */