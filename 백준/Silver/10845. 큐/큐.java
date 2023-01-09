import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String func = st.nextToken();
            if (func.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                queue.add(value);
            } else if (func.equals("pop")) {
                if (queue.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(queue.poll());
            } else if (func.equals("size")) {
                System.out.println(queue.size());
            } else if (func.equals("empty")) {
                if (queue.isEmpty())
                    System.out.println("1");
                else System.out.println("0");
            } else if (func.equals("front")) {
                if (queue.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(queue.peek());
            } else if (func.equals("back")) {
                if (queue.isEmpty())
                    System.out.println("-1");
                else {
                    Iterator<Integer> iterator = queue.iterator();
                    for (int j = 0; j < queue.size() - 1; j++) {
                        iterator.next();
                    }
                    System.out.println(iterator.next());
                }
            }
        }
    }
}
