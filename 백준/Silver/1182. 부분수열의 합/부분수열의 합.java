import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        DFS(N, S, 0, 0);
        if (S == 0)
            cnt--;
        System.out.println(cnt);
    }

    public static void DFS(int N, int S, int sum, int ptr) {
        if (ptr == N) {
            if (sum == S)
                cnt++;
            return;
        }
        DFS(N, S, sum + arr[ptr], ptr + 1);
        DFS(N, S, sum, ptr + 1);
    }
}
