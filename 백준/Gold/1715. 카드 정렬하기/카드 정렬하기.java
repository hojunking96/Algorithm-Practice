import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int N;
        long S = 0, tmp1, tmp2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(br.readLine()));
        }
        while (pq.size() > 1) {
            tmp1 = pq.poll();
            tmp2 = pq.poll();
            S += tmp1 + tmp2;
            pq.offer(tmp1 + tmp2);
        }
        bw.write(S + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
