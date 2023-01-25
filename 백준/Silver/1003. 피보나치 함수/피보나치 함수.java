import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        int[] zeroCnt = new int[41];
        int[] oneCnt = new int[41];
        zeroCnt[0] = 1;
        zeroCnt[1] = 0;
        oneCnt[0] = 0;
        oneCnt[1] = 1;
        for (int i = 2; i <= 40; i++) {
            zeroCnt[i] = zeroCnt[i - 1] + zeroCnt[i - 2];
            oneCnt[i] = oneCnt[i - 1] + oneCnt[i - 2];
        }
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(zeroCnt[N]).append(" ").append(oneCnt[N]).append("\n");
        }
        System.out.println(sb);
    }
}