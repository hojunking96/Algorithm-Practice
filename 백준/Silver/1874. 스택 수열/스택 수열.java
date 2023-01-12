import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }
        int nextNum = 1;
        int ptr;
        int idx = 0;
        stack.push(0);
        while (idx < N) {
            ptr = stack.peek();
            if (ptr > N) {
                sb= new StringBuilder();
                sb.append("NO");
                break;
            }
            if (ptr < sequence[idx]) {
                stack.push(nextNum);
                sb.append("+\n");
                nextNum++;
            } else if (ptr == sequence[idx]) {
                stack.pop();
                idx++;
                sb.append("-\n");
            } else {
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.println(sb);
    }
}
