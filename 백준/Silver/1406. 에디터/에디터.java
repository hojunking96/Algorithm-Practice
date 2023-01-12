import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String string = br.readLine();
        Stack<Character> LStack = new Stack<>();
        Stack<Character> RStack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            LStack.push(string.charAt(i));
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "L":
                    if (!LStack.isEmpty()) {
                        RStack.push(LStack.pop());
                    }
                    break;
                case "D":
                    if (!RStack.isEmpty()) {
                        LStack.push(RStack.pop());
                    }
                    break;
                case "B":
                    if (!LStack.isEmpty()) {
                        LStack.pop();
                    }
                    break;
                case "P":
                    char key = st.nextToken().charAt(0);
                    LStack.push(key);
                    break;
                default:
                    break;
            }
        }
        while (!LStack.isEmpty()) {
            RStack.push(LStack.pop());
        }
        while (!RStack.isEmpty()) {
            sb.append(RStack.pop());
        }
        System.out.println(sb);
    }
}
