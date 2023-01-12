import java.io.*;
import java.util.*;

public class Main {
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            deque.add(i);
        int[] positions = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            positions[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            if (shouldGoLeft(positions[i], deque)) {
                while (positions[i] != deque.peek()) {
                    deque.addLast(deque.pollFirst());
                    cnt++;
                }
            } else {
                while (positions[i] != deque.peek()) {
                    deque.addFirst(deque.pollLast());
                    cnt++;
                }
            }
            deque.poll();
        }
        System.out.println(cnt);
    }

    public static boolean shouldGoLeft(int k, LinkedList<Integer> deque) {
        for (int i = 0; i <= deque.size() / 2; i++) {
            if (k == deque.get(i))
                return true;
        }
        return false;
    }
}