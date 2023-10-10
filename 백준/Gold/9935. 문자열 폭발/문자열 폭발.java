import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String bombStr = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char e = input.charAt(i);
            stack.push(e);
            if (stack.size() >= bombStr.length()) {
                boolean keep = true;
                Stack<Character> tmp = new Stack<>();
                for (int j = bombStr.length() - 1; j >= 0; j--) {
                    if (stack.peek() == bombStr.charAt(j)) {
                        tmp.push(stack.pop());
                    } else {
                        keep = false;
                        break;
                    }
                }
                if (!keep) {
                    while(!tmp.isEmpty()){
                        stack.push(tmp.pop());
                    }
                }
            }
        }
        if (stack.size() == 0) {
            System.out.println("FRULA");
        } else {
            for (char e : stack) {
                sb.append(e);
            }
            System.out.println(sb);
        }
    }
}