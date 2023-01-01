import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Lecture {
        int num;
        int startTime;
        int endTime;

        Lecture(int num, int startTime, int endTime) {
            this.num = num;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static List<Lecture> lectures = new ArrayList<>();
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static Comparator<Lecture> comparator = new Comparator<>() {
        @Override
        public int compare(Lecture l1, Lecture l2) {
            return Integer.compare(l1.startTime, l2.startTime);
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Lecture k = new Lecture(number, start, end);
            lectures.add(k);
        }
        Collections.sort(lectures, comparator);
        int max = 0;
        for (int i = 0; i < N; i++) {
            while (!pq.isEmpty() && pq.peek() <= lectures.get(i).startTime) {
                pq.poll();
            }
            pq.add(lectures.get(i).endTime);
            max = Math.max(max, pq.size());
        }
        System.out.println(max);
        br.close();
    }

}
