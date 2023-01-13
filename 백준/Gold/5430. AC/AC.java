import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Deque<String> deque = new LinkedList<>();
            String func = br.readLine();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), "[],");
            for (int j = 0; j < N; j++) {
                deque.offerLast(st.nextToken());
            }
            sb.append(doMainWork(func, deque));
        }
        System.out.println(sb);
    }

    public static StringBuilder doMainWork(String func, Deque<String> deque) {
        boolean isGoingRight = true;
        StringBuilder sb = new StringBuilder();
        for (char e : func.toCharArray()) {
            if (e == 'R') {
                isGoingRight = !isGoingRight;
                continue;
            }
            if (!deque.isEmpty()) {
                if (isGoingRight) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            } else {
                sb.append("error\n");
                return sb;
            }
        }
        if (deque.isEmpty()) {
            sb.append("[]\n");
            return sb;
        }
        sb.append("[");
        while (!deque.isEmpty()) {
            if (isGoingRight) {
                sb.append(deque.pollFirst()).append(",");
            } else {
                sb.append(deque.pollLast()).append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]\n");
        return sb;
    }
}