import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int P, L, V, S, cnt = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            if (P == 0 && L == 0 && V == 0)
                break;
            if (V % P > L)
                S = V / P * L + L;
            else
                S = V / P * L + V % P;
            cnt++;
            bw.write("Case " + cnt + ": " + S + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}