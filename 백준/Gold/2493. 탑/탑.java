import java.io.*;
import java.util.*;


public class Main {
    static class Top {
        private int height;
        private int idx;

        Top(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }

        public int getHeight() {
            return height;
        }

        public int getIdx() {
            return idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] tops = new int[N];
        Stack<Top> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek().getHeight() >= tops[i]) {
                    sb.append(stack.peek().getIdx() + " ");
                    stack.add(new Top(tops[i], i + 1));
                    break;
                }
                stack.pop();
            }
            if (stack.isEmpty()) {
                sb.append(0 + " ");
                stack.add(new Top(tops[i], i + 1));
            }
        }
        System.out.println(sb);
    }
}