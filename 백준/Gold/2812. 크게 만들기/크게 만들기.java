import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        StringBuffer input = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        input.append(br.readLine());
        for (int i = 0; i < N; i++) {
            while (K > 0 && !stack.isEmpty() && stack.peek() < input.charAt(i)) {
                stack.pop();
                K--;
            }
            stack.push(input.charAt(i));
        }
        for (Object e : stack.toArray())
            sb.append(e);
        System.out.println(sb.substring(0, stack.size() - K));
    }
}