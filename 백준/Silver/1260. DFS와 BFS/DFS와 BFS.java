import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] c;
    static int[][] arr;
    static int N;
    static Queue<Integer> q;

    static void DFS(int root) {
        c[root] = true;
        sb.append(root).append(' ');
        for (int i = 1; i <= N; i++)
            if (arr[root][i] == 1 && !c[i])
                DFS(i);
    }

    static void BFS(int root) {
        q.add(root);
        c[root] = true;
        while (!q.isEmpty()) {
            root = q.poll();
            sb.append(root).append(' ');
            for (int i = 1; i <= N; i++)
                if (arr[root][i] == 1 && !c[i]) {
                    q.add(i);
                    c[i] = true;
                }
        }
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M, V;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        c = new boolean[N + 1];
        q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());
            arr[tmp1][tmp2] = 1;
            arr[tmp2][tmp1] = 1;
        }
        DFS(V);
        bw.write(sb + "\n");
        sb.setLength(0);
        c = new boolean[N + 1];
        BFS(V);

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();

    }

}