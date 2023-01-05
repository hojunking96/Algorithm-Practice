import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] visited;
    public static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        nums = new int[N];
        DFS(N, 0);
    }

    private static void DFS(int N, int length) {
        if (length == N) {
            for (int e : nums)
                System.out.print(e + " ");
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                nums[length] = i + 1;
                DFS(N, length + 1);
                visited[i] = false;
            }
        }
    }
}
