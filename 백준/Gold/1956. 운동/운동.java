import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int V, E;
    public final static int INF = 2000000000;
    public static long[][] dist; //첫 번째 인덱스에서 두 번째 인덱스로 가는 최소 길이

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new long[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                    continue;
                }
                dist[i][j] = INF;
            }
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c);
        }
        floydWarshall();
        long min = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j) {
                    min = Math.min(min, dist[i][j] + dist[j][i]);
                }
            }
        }
        if (min >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    public static void floydWarshall() {
        for (int k = 1; k <= V; k++) {
            // 노드 i에서 j로 가는 경우.
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    // k번째 노드를 거쳐가는 비용이 기존 비용보다 더 작은 경우 갱신
                    // 또는 연결이 안되어있던 경우(INF) 연결 비용 갱신.
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}