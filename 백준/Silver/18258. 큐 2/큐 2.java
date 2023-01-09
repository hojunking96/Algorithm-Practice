import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> dequeue = new LinkedBlockingDeque<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String func = st.nextToken();
            if (func.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                dequeue.addLast(value);
            } else if (func.equals("pop")) {
                if (dequeue.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(dequeue.pollFirst() + "\n");
            } else if (func.equals("size")) {
                sb.append(dequeue.size() + "\n");
            } else if (func.equals("empty")) {
                if (dequeue.isEmpty())
                    sb.append("1\n");
                else sb.append("0\n");
            } else if (func.equals("front")) {
                if (dequeue.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(dequeue.peekFirst() + "\n");
            } else if (func.equals("back")) {
                if (dequeue.isEmpty())
                    sb.append("-1\n");
                else {
                    sb.append(dequeue.peekLast() + "\n");
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
