
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Double.parseDouble(st.nextToken()));
        }
        double sum = pq.poll();
        while (!pq.isEmpty()) {
            sum += pq.poll() / 2;
        }
        System.out.println(sum);
    }
}
