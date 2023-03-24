import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Shark {
        int speed;
        int direction;
        int size;

        public Shark(int speed, int direction, int size) {
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }
    }

    private static int R, C;
    private static Shark[][] sharks;
    private static int[] dX = {-1, 1, 0, 0};
    private static int[] dY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sharks = new Shark[R][C];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            sharks[r - 1][c - 1] = new Shark(s, d, z);

        }

        int sum = 0;
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                if (sharks[j][i] != null) {
                    sum += sharks[j][i].size;
                    sharks[j][i] = null;
                    break;
                }
            }
            Shark[][] tmpSharks = new Shark[R][C];
            for (int x = 0; x < R; x++) {
                for (int y = 0; y < C; y++) {
                    if (sharks[x][y] == null) {
                        continue;
                    }
                    Shark shark = sharks[x][y];
                    int newX = x;
                    int newY = y;

                    if (shark.direction == 1 || shark.direction == 2) {
                        shark.speed = shark.speed % (2 * R - 2);
                    }
                    if (shark.direction == 3 || shark.direction == 4) {
                        shark.speed = shark.speed % (2 * C - 2);
                    }

                    for (int k = 0; k < shark.speed; k++) {
                        if (newX == 0 && shark.direction == 1) {
                            shark.direction = 2;
                        } else if (newX == R - 1 && shark.direction == 2) {
                            shark.direction = 1;
                        } else if (newY == 0 && shark.direction == 4) {
                            shark.direction = 3;
                        } else if (newY == C - 1 && shark.direction == 3) {
                            shark.direction = 4;
                        }
                        newX += dX[shark.direction - 1];
                        newY += dY[shark.direction - 1];
                    }

                    if (tmpSharks[newX][newY] != null) {
                        if (tmpSharks[newX][newY].size < shark.size) {
                            tmpSharks[newX][newY] = shark;
                        }
                    } else {
                        tmpSharks[newX][newY] = shark;
                    }

                }
            }
            sharks = tmpSharks;
        }
        System.out.println(sum);
    }
}

//크기가 큰 상어가 작은 상어를 잡아 먹는다 -> 큰 순서로 했을 때 1개만 값을 가짐? 우선순위큐?
//여러마리있을 때 잡아먹는 작업 처리

//2n-2
