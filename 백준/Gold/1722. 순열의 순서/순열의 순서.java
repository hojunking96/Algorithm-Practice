import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static int N;
    private static boolean[] visited;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int func = Integer.parseInt(st.nextToken());

        if (func == 1) {
            String answer1 = "";
            visited = new boolean[N + 1];
            long k = Long.parseLong(st.nextToken());
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (!visited[j]) {
                        if (k > factorial(N - i - 1)) {
                            k -= factorial(N - i - 1);
                        } else {
                            answer1 += j + " ";
                            visited[j] = true;
                            break;
                        }
                    }
                }
            }
            System.out.println(answer1);
        } else {
            long answer2 = 1;
            visited = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                int value = Integer.parseInt(st.nextToken());
                for (int j = 1; j < value; j++) {
                    if (!visited[j]) {
                        answer2 += factorial(N - i);
                    }
                }
                visited[value] = true;
            }
            System.out.println(answer2);
        }
    }

    private static long factorial(int k) {
        long s = 1;
        for (int i = 1; i <= k; i++) {
            s *= i;
        }
        return s;
    }
}
