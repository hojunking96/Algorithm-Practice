import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static int N;
    public static int M;
    public static StringBuilder sb;
    public static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        cnt = new int[N];
        printSequence(0);
        System.out.println(sb);
    }

    public static void printSequence(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(cnt[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            cnt[depth] = i + 1;
            printSequence(depth + 1);
        }
    }
}