import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static int[][] S;
    public static int N;
    public static boolean[] team1;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        team1 = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0);
        System.out.println(min);
    }

    public static void DFS(int depth, int start) {
        if (depth == N / 2) {
            int diff = calculatePower();
            if (min > diff)
                min = diff;
            return;
        }
        for (int i = start; i < N; i++) {
            team1[i] = true;
            DFS(depth + 1, i + 1);
            team1[i] = false;
        }
    }

    public static int calculatePower() {
        int team1Power = 0;
        int team2Power = 0;
        for (int i = 0; i < N; i++) {
            if (team1[i])
                for (int j = i + 1; j < N; j++) {
                    if (team1[j])
                        team1Power += S[i][j] + S[j][i];
                }
            else
                for (int j = i + 1; j < N; j++) {
                    if (!team1[j])
                        team2Power += S[i][j] + S[j][i];
                }
        }
        return Math.abs(team1Power - team2Power);
    }

}