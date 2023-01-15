import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static int N;
    public static StringBuilder sb;
    public static int[] cnt = new int[4];
    public static int[] arr;

    public static long min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }
        sb = new StringBuilder();
        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;
        DFS(0, 0, 0);
        sb.append(max).append("\n");
        sb.append(min);
        System.out.println(sb);
    }

    public static void DFS(int depth, int index, long num) {
        num = calculate(index, num, arr[depth]);
        if (depth == N - 1) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (cnt[i] > 0) {
                cnt[i]--;
                DFS(depth + 1, i, num);
                cnt[i]++;
            }
        }
    }

    public static long calculate(int idx, long num1, int num2) {
        if (idx == 0)
            return num1 + num2;
        if (idx == 1)
            return num1 - num2;
        if (idx == 2)
            return num1 * num2;
        return num1 / num2;
    }
}