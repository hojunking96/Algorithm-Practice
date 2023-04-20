import java.io.*;
import java.util.*;

public class Main {
    private static class Line {
        private int start;
        private int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Line> lines = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            lines.add(new Line(Math.min(h, o), Math.max(h, o)));
        }
        int d = Integer.parseInt(br.readLine());

        Collections.sort(lines, (o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = 0;
        int prev = -100_000_001;
        for (Line line : lines) {
            int end = line.end;
            if (prev < end) {
                while (!pq.isEmpty()) {
                    if (pq.peek() < end - d) {
                        pq.poll();
                    } else {
                        break;
                    }
                }
            }
            if (line.start >= end - d) {
                pq.add(line.start);
            }
            max = Math.max(max, pq.size());
        }
        System.out.println(max);

    }
}

/*
4
1 4
1 4
2 5
3 4
3
3

5
-2 3
2 5
4 3
2 -1
-2 5
5
output: 3
correct answer: 2

5
4 3
1 -1
4 5
-2 5
-2 3
5
output: 3
correct answer: 2

4
-2 2
1 0
3 0
3 -1
4
output: 4
correct answer: 3
 */