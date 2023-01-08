import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String k = br.readLine();
            boolean flag = true;
            for (int j = 0; j < k.length(); j++) {
                if (k.charAt(j) == '(')
                    stack.push('(');
                else if (k.charAt(j) == ')') {
                    if (stack.isEmpty()) {
                        System.out.println("NO");
                        flag = false;
                        break;
                    } else
                        stack.pop();
                }
            }
            if (flag)
                if (stack.isEmpty())
                    System.out.println("YES");
                else
                    System.out.println("NO");
        }
    }
}