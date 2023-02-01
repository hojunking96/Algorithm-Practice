import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] visited;
    public static int F, S, G, U, D;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());   //총 층 수
        S = Integer.parseInt(st.nextToken());   //현재 층 수
        G = Integer.parseInt(st.nextToken());   //목적지
        U = Integer.parseInt(st.nextToken());   //위로 몇 칸씩
        D = Integer.parseInt(st.nextToken());   //아래로 몇 칸씩
        visited = new int[F + 1];
        BFS();
        if (S == G) {
            System.out.println("0");
        } else if (visited[G] == 0) {
            System.out.println("use the stairs");
        } else {
            System.out.println(visited[G]);
        }
    }

    public static void BFS() {
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == G) {
                break;
            }
            if (U != 0) {
                int next = now + U;
                if (next <= F && visited[next] == 0) {
                    q.add(next);
                    visited[next] = visited[now] + 1;
                }
            }
            if (D != 0) {
                int next = now - D;
                if (next >= 1 && visited[next] == 0) {
                    q.add(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
    }
}
