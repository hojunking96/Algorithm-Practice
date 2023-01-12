import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Doc {
        private int weight;
        private boolean target;

        public Doc(int weight, boolean target) {
            this.weight = weight;
            this.target = target;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Queue<Doc> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (j == M)
                    queue.add(new Doc(Integer.parseInt(st.nextToken()), true));
                else
                    queue.add(new Doc(Integer.parseInt(st.nextToken()), false));
            }
            while (!queue.isEmpty()) {
                Doc newDoc = queue.poll();
                if (isBiggest(queue, newDoc.weight)) {
                    cnt++;
                    if (newDoc.target)
                        break;
                } else {
                    queue.offer(newDoc);
                }
            }
            System.out.println(cnt);
        }
    }

    public static boolean isBiggest(Queue<Doc> q, int k) {
        for (Doc e : q) {
            if (e.weight > k)
                return false;
        }
        return true;
    }
}
