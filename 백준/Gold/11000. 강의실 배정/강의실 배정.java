import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class C {
    int start;
    int end;

    C(int start, int end) {
        this.start = start;
        this.end = end;
    }

}

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        C[] classes = new C[N];

        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            StringTokenizer st = new StringTokenizer(s);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            classes[i] = new C(a, b);
        }

        Arrays.sort(classes, (l1, l2) -> l1.start == l2.start ? l1.end - l2.end : l1.start - l2.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(classes[0].end);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= classes[i].start) {
                pq.poll();
            }
            pq.offer(classes[i].end);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(pq.size() + "\n");
        bw.flush();
        bw.close();
        bf.close();

        System.out.println();

    }
}