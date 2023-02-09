import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int min = Math.min(K, N - K);
        int up = 1;
        int down = 1;
        for (int i = 1; i <= min; i++) {
            up *= (N - i + 1);
            down *= i;
        }
        System.out.println(up / down);

    }
}