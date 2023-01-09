import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Stack<Double> stack = new Stack<>();
        HashMap<Character, Double> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            double value = Double.parseDouble(br.readLine());
            for (int j = 0; j < s.length(); j++) {
                char key = s.charAt(j);
                if (isParam(key))
                    if (!hashMap.containsKey(key)) {
                        hashMap.put(key, value);
                        break;
                    }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i);
            if (isParam(k))
                stack.push(hashMap.get(k));
            else {
                double a = stack.pop();
                double b = stack.pop();
                double result = calculate(a, b, k);
                stack.push(result);
            }
        }
        System.out.printf("%.2f", stack.pop());
    }

    private static boolean isParam(char k) {
        return !(k == '+' || k == '-' || k == '*' || k == '/');
    }

    private static double calculate(double a, double b, char func) {
        if (func == '+')
            return a + b;
        else if (func == '-')
            return b - a;
        else if (func == '*')
            return a * b;
        else return b / a;
    }
}
