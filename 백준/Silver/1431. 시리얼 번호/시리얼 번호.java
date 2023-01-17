import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() - o2.length() == 0) {
                int a = getSum(o1);
                int b = getSum(o2);
                if (a - b == 0) {
                    return o1.compareTo(o2);
                } else {
                    return a - b;
                }
            } else {
                return o1.length() - o2.length();
            }
        });
        for (String e : arr) {
            sb.append(e).append("\n");
        }
        System.out.println(sb);
    }

    public static int getSum(String e) {
        int sum = 0;
        char[] arr = e.toCharArray();
        for (char letter : arr)
            if (Character.isDigit(letter))
                sum += Integer.parseInt(String.valueOf(letter));
        return sum;
    }
}