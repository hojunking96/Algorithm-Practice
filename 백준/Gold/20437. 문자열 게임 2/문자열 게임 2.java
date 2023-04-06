import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] alphaCount;
    private static int min;
    private static int max;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {


            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            if (K == 1) {
                sb.append("1 1").append("\n");
                continue;
            }
            alphaCount = new int[26];
            for (int j = 0; j < W.length(); j++) {
                char c = W.charAt(j);
                alphaCount[c - 97]++;
            }

            if (!find(W, K)) {
                sb.append(-1 + "\n");
                continue;
            }
            sb.append(min + " " + max + "\n");
        }
        System.out.println(sb);
    }

    private static boolean find(String W, int K) {
        int len = W.length();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for (int i = 0; i <= len - K; i++) {
            char start = W.charAt(i);
            if (alphaCount[start - 97] >= K) {
                int tmpCount = 1;
                for (int j = i + 1; j < len; j++) {
                    char cur = W.charAt(j);
                    if (start == cur) {
                        tmpCount++;

                        if (tmpCount == K) {
                            int len2 = (j - i) + 1;
                            min = Math.min(min, len2);
                            max = Math.max(max, len2);
                            break;
                        }
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return false;
        }
        return true;
    }
}