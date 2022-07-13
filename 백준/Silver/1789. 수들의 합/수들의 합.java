import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        long N, S;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = Long.parseLong(br.readLine());
        for (N = 1; N <= S; N++) {
            if (N * (N + 1) / 2 <= S && (N + 1) * (N + 2) / 2 > S) {
                bw.write(N + "\n");
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}