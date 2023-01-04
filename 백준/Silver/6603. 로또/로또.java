import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] S;
    public static boolean[] visited;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0)
                break;
            S = new int[N];
            visited = new boolean[N];
            for (int i = 0; i < N; i++)
                S[i] = Integer.parseInt(st.nextToken());
            DFS(0, 0);
            System.out.println();
        }
    }

    public static void DFS(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < N; i++) {
                if (visited[i])
                    System.out.print(S[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
