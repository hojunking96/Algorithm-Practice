import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M;
    public static LinkedHashSet<String> hashSet;
    public static int[] arr;
    public static int[] newArr;
    public static boolean[] visited;
    public static List<String> results = new ArrayList<>();

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
        hashSet = new LinkedHashSet<>();
        for (int i = 0; i < N; i++) {
            arr[i] = pq.poll();
        }
        backTracking(0);
        StringBuilder sb = new StringBuilder();
        for (String output : hashSet) {
            sb.append(output).append("\n");
        }
        System.out.println(sb);
    }

    public static void backTracking(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int p : newArr)
                sb.append(p).append(' ');
            hashSet.add(sb.toString());
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                newArr[depth] = arr[i];
                visited[i] = true;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
