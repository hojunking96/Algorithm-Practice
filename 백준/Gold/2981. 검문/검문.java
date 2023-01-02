import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        int[] keys = new int[N];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            keys[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(keys);
        for (int i = 0; i < N - 1; i++) {
            min = Math.min(min, keys[i + 1] - keys[i]);
        }

        for (int M = 2; M <= min; M++) {
            int i;
            int last = keys[0] % M;
            for (i = 1; i < N; i++) {
                if (keys[i] % M != last)
                    break;
            }
            if (i == N)
                pq.add(M);
        }
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
        br.close();
    }
}
