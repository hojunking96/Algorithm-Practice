import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        int N, M;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>(N);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Long tmp = Long.parseLong(st.nextToken());
            if (map.get(tmp) == null)
                map.put(tmp, 1);
            else
                map.put(tmp, map.get(tmp) + 1);
        }

        M = Integer.parseInt(br.readLine());
        Long[] Y = new Long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            Y[i] = Long.parseLong(st.nextToken());

        for (int i = 0; i < M; i++) {
            if (map.get(Y[i]) == null)
                bw.write(0 + " ");
            else
                bw.write(map.get(Y[i]) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}