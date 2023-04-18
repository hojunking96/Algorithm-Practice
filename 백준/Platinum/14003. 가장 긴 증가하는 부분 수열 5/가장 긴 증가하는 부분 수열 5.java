import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> arr = new ArrayList<>();
        arr.add(Integer.MIN_VALUE);

        int[] num = new int[N];
        int[] indexes = new int[N];

        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());
            num[i] = next;


            if (next > arr.get(arr.size() - 1)) {
                arr.add(next);
                indexes[i] = arr.size() - 1;
            } else {
                int left = 1;
                int right = arr.size() - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (arr.get(mid) >= next) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                arr.set(right, next);
                indexes[i] = right;
            }
        }
        int max = arr.size() - 1;
        sb.append(max).append("\n");

        int index = arr.size() - 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {
            if (indexes[i] == index) {
                index--;
                stack.push(num[i]);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}