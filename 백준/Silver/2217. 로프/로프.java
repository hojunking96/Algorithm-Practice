import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int N, W, tmp_W;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> PQ = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            PQ.add(Integer.parseInt(br.readLine()));
        }
        W = PQ.poll() * N;
        N--;
        while (!PQ.isEmpty()) {
            tmp_W = PQ.poll() * N;
            N--;
            if (tmp_W > W)
                W = tmp_W;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(W + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
