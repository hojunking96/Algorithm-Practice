import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] leakPlaces = new int[N];
        for (int i = 0; i < N; i++)
            leakPlaces[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(leakPlaces);
        System.out.println(count(N, L, leakPlaces));
        br.close();
    }

    private static int count(int N, int L, int[] leakPlaces) {
        int cnt = 0, i = 0;
        while (i < N) {
            double endPoint = leakPlaces[i] - 0.5 + L;
            while (i < N && leakPlaces[i] + 0.5 <= endPoint)
                i++;
            cnt++;
        }
        return cnt;
    }
}
