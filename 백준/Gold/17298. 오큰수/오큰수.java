import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] tops = new int[N];
        int[] NGEs = new int[N];
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                if (stack.peek() > tops[i]) {
                    NGEs[i] = stack.peek();
                    stack.add(tops[i]);
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                NGEs[i] = -1;
                stack.add(tops[i]);
            }
        }
        for (int i = 0; i < N; i++) {
            sb.append(NGEs[i]).append(" ");
        }
        System.out.println(sb);
    }
}