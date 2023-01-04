import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] nums;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[M];
        DFS(0, 0);
    }

    public static void DFS(int start, int depth) {
        if (depth == M) {
            for (int e : nums) {
                System.out.print(e + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < N; i++) {
                nums[depth] = i + 1;
                DFS(i + 1, depth + 1);
        }
    }
}
