import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Direction {
        int time;
        String direction;

        public Direction(int time, String direction) {
            this.time = time;
            this.direction = direction;
        }
    }

    private static int N;
    private static final List<Point> apples = new ArrayList<>();
    private static final int[] dX = {0, 1, 0, -1};
    private static final int[] dY = {1, 0, -1, 0};

    // 우 : 0 / 하 : 1 / 좌 : 2 / 상 : 3
    private static int directionBit = 0;
    private static boolean[][] isSnakeBody;
    private static final Deque<Point> snakes = new LinkedList<>();
    private static final Queue<Direction> directions = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        isSnakeBody = new boolean[N][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            apples.add(new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1));
        }
        //일단 사과를 다 입력해 놨어

        int L = Integer.parseInt(br.readLine());

        snakes.addLast(new Point(0, 0));
        isSnakeBody[0][0] = true;
        //(0,0) 부터 출발을 해

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String k = st.nextToken();
            directions.add(new Direction(a, k));
        }
        int answer = move();
        System.out.println(answer);
    }

    // 이게 아니야 1초마다 변경해야 먹었는지를 알 수 있어
    //1초마다 꼬리도 자르고
    private static int move() {
        int timeCnt = 0;
        while (true) {
            boolean ateApple = false;


            if (!directions.isEmpty()) {
                int changeTime = directions.peek().time;
                if (changeTime == timeCnt) {
                    Direction k = directions.poll();
                    changeDirection(k.direction);
                }
            }

            Point head = snakes.getFirst();
            int nextX = head.x + dX[directionBit];
            int nextY = head.y + dY[directionBit];
            if (nextX >= N || nextY >= N || nextX < 0 || nextY < 0) {
                return timeCnt + 1;
            }
            if (isSnakeBody[nextX][nextY]) {
                return timeCnt + 1;
            }


            if (apples.size() != 0) {
                for (Point e : apples) {
                    if (nextX == e.x && nextY == e.y) {
                        ateApple = true;
                        apples.remove(e);
                        break;
                    }
                }
            }

            snakes.addFirst(new Point(nextX, nextY));
            isSnakeBody[nextX][nextY] = true;
            if (!ateApple) {
                Point tail = snakes.getLast();
                isSnakeBody[tail.x][tail.y] = false;
                snakes.removeLast();
            }
            timeCnt++;

        }
    }

    private static void changeDirection(String direction) {
        if (direction.equals("L")) {
            directionBit -= 1;
            if (directionBit == -1) {
                directionBit = 3;
            }
        } else {
            directionBit += 1;
            if (directionBit == 4) {
                directionBit = 0;
            }
        }
    }
}


/*
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 1 1 0 1 1 1 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0
 */