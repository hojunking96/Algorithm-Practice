import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static int[] newArr;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        arr = new int[N];
        newArr = new int[M];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = pq.poll();
        }
        backTracking(0, 0);
        System.out.println(sb);
    }

    public static void backTracking(int depth, int start) {
        if (depth == M) {
            for (int e : newArr) {
                sb.append(e).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            newArr[depth] = arr[i];
            backTracking(depth + 1, i);
        }
    }
}
