import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] nums;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        nums = new int[M];
        visited = new boolean[N];
        DFS(N, M, 0);
    }

    public static void DFS(int N, int M, int depth) {
        if (depth == M) {
            for (int e : nums) {
                System.out.print(e + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                nums[depth] = i + 1;
                DFS(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }
}
