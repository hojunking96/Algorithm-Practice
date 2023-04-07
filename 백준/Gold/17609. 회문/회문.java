import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String input;
    private static int len;
    private static int flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            flag = 2;
            input = br.readLine();
            len = input.length();
            checkPalindrome();
            if (flag == 2) {
                leftDelete();
                if (flag == 2) {
                    rightDelete();
                }
            }
            sb.append(flag).append("\n");
        }
        System.out.println(sb);
    }

    private static void leftDelete() {
        int left;
        int right;
        if (len % 2 == 0) {
            left = len / 2 - 1;
            right = len / 2 + 1;
        } else {
            left = len / 2;
            right = len / 2 + 1;
        }
        boolean hasSkipped = false;
        while (left >= 0 && right < len) {
            char l = input.charAt(left);
            char r = input.charAt(right);
            if (input.charAt(left) != input.charAt(right)) {
                if (hasSkipped) {
                    flag = 2;
                    return;
                }
                left--;
                hasSkipped = true;
                continue;
            }
            left--;
            right++;
        }
        if (hasSkipped && left == 0) {
            flag = 2;
            return;
        }
        flag = 1;
    }

    private static void rightDelete() {
        int left;
        int right;
        if (len % 2 == 0) {
            left = len / 2 - 2;
            right = len / 2;
        } else {
            left = len / 2 - 1;
            right = len / 2;
        }
        boolean hasSkipped = false;
        while (left >= 0 && right < len) {
            if (input.charAt(left) != input.charAt(right)) {
                if (hasSkipped) {
                    flag = 2;
                    return;
                }
                right++;
                hasSkipped = true;
                continue;
            }
            left--;
            right++;
        }

        if (hasSkipped && right == len - 1) {
            flag = 2;
            return;
        }
        flag = 1;
    }

    private static void checkPalindrome() {
        int left;
        int right;
        if (len % 2 == 0) {
            left = len / 2 - 1;
            right = len / 2;
        } else {
            left = len / 2 - 1;
            right = len / 2 + 1;
        }
        while (left >= 0 && right < len) {
            if (input.charAt(left) != input.charAt(right)) {
                return;
            }
            left--;
            right++;
        }
        if (left >= 0 || right < len) {
            flag = 2;
            return;
        }
        flag = 0;
    }
}