import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        int N, M, s = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            pq.add(Integer.parseInt(st.nextToken()));
        while (pq.size() != 1) {
            pq2.add((pq.poll() - pq.peek()));
        }
        for (int i = 0; i < M - 1; i++) {
            pq2.poll();
        }
        while (!pq2.isEmpty()) {
            s += pq2.poll();
        }
        bw.write(s + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
