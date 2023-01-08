import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        long sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            int k = Integer.parseInt(br.readLine());
            if (k == 0)
                stack.pop();
            else
                stack.push(k);
        }
        while (!stack.isEmpty())
            sum += stack.pop();
        System.out.println(sum);
    }
}