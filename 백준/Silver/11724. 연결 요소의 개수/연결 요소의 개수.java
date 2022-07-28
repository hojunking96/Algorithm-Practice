import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int X[][];

    static boolean c[];

    public static void DFS(int root) {
        if (c[root])
            return;
        else {
            c[root] = true;
            for (int i = 0; i < N; i++) {
                if (X[root][i] == 1)
                    DFS(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = new int[N][N];
        c = new boolean[N];
        int cnt = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());
            X[tmp1 - 1][tmp2 - 1] = 1;
            X[tmp2 - 1][tmp1 - 1] = 1;
        }
        for (int i = 0; i < N; i++) {
            if (!c[i]) {
                DFS(i);
                cnt++;
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();

    }

}
