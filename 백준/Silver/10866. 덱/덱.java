import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String func = st.nextToken();
            if (func.equals("push_front")) {
                int value = Integer.parseInt(st.nextToken());
                deque.addFirst(value);
            } else if (func.equals("push_back")) {
                int value = Integer.parseInt(st.nextToken());
                deque.addLast(value);
            } else if (func.equals("pop_front")) {
                if (deque.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(deque.pollFirst() + "\n");
            } else if (func.equals("pop_back")) {
                if (deque.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(deque.pollLast() + "\n");
            } else if (func.equals("size")) {
                sb.append(deque.size() + "\n");
            } else if (func.equals("empty")) {
                if (deque.isEmpty())
                    sb.append("1\n");
                else sb.append("0\n");
            } else if (func.equals("front")) {
                if (deque.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(deque.peekFirst() + "\n");
            } else if (func.equals("back")) {
                if (deque.isEmpty())
                    sb.append("-1\n");
                else {
                    sb.append(deque.peekLast() + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
