import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);


        boolean[][] block = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'B')
                    block[i][j] = true;
                else
                    block[i][j] = false;
            }
        }
        int min = 2147483647;

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                int cnt = Math.min(countBlackStart(i, j, block), countWhiteStart(i, j, block));
                if (min > cnt)
                    min = cnt;
            }
        }
        System.out.println(min);
    }

    private static int countBlackStart(int start1, int start2, boolean[][] block) {
        int cnt = 0;
        for (int i = start1; i < start1 + 8; i++) {
            for (int j = start2; j < start2 + 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (block[i][j] == true)
                        cnt++;
                } else {
                    if (block[i][j] == false)
                        cnt++;
                }
            }
        }
        return cnt;
    }

    private static int countWhiteStart(int start1, int start2, boolean[][] block) {
        int cnt = 0;
        for (int i = start1; i < start1 + 8; i++) {
            for (int j = start2; j < start2 + 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (block[i][j] == false)
                        cnt++;
                } else {
                    if (block[i][j] == true)
                        cnt++;
                }
            }
        }
        return cnt;
    }

}
