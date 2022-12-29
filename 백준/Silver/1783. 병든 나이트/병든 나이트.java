import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        System.out.println(movingCount(N, M) + 1);
    }

    private static int movingCount(int N, int M) {
        int cnt = 0;
        if (N == 1)
            return 0;
        if (N == 2) {
            if (M >= 9)
                return 3;
            if (M >= 3)
                return (M - 1) / 2;
            return 0;
        }
        if (N > 2) {
            if (M >= 7)
                return M - 3;
            if (M >= 4)
                return 3;
            return M - 1;
        }
        return cnt;
    }
}
