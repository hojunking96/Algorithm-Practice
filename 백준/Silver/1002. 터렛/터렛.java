import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int N, x1, y1, r1, x2, y2, r2, len1, len2, len3;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());

            len1 = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
            len2 = (r1 + r2) * (r1 + r2);
            len3 = (r1 - r2) * (r1 - r2);
            if (len1 == 0 && len3 == 0) {
                bw.write(-1 + "\n");
            } else if (len1 == 0 || len1 > len2 || len3 > len1)
                bw.write(0 + "\n");
            else if (len1 == len3 || len1 == len2) {
                bw.write(1 + "\n");
            } else if (len1 < len2 && len1 > len3) {
                bw.write(2 + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
