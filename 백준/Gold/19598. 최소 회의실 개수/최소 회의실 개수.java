import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static class Time implements Comparable<Time> {
        private final int start;
        private final int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(Time target) {
            if (this.start > target.start) {
                return 1;
            } else if (this.start == target.start) {
                if (this.end > target.end) {
                    return 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Time> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        List<Integer> schedule = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        schedule.add(pq.poll().end);
        while (!pq.isEmpty()) {
            Time next = pq.poll();
            boolean hasAdded = false;
            for (int i = 0; i < schedule.size(); i++) {
                if (schedule.get(i) <= next.start) {
                    schedule.set(i, next.end);
                    hasAdded = true;
                    break;
                }
            }
            if (!hasAdded) {
                schedule.add(next.end);
            }
        }
        System.out.println(schedule.size());
    }
}
