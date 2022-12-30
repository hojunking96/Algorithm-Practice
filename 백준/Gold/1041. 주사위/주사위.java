import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        long sum = 0;
        long min = 51;
        long max = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] keys = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            keys[i] = Integer.parseInt(st.nextToken());
            if (keys[i] < min)
                min = keys[i];
            if (keys[i] > max)
                max = keys[i];
        }
        long min2 = findMin2(keys);
        long min3 = findMin3(keys);
        if (N == 1) {
            for (int e : keys)
                sum += e;
            sum -= max;
        } else if (N == 2) {
            long min2s = min2 * 4;
            long min3s = min3 * 4;
            sum = min2s + min3s;
        } else {
            long min1s = min * (N - 2) * (N - 1) * 4 + min * (N - 2) * (N - 2);
            long min2s = min2 * (N - 1) * 4 + min2 * (N - 2) * 4;
            long min3s = min3 * 4;
            sum = min1s + min2s + min3s;
        }
        System.out.println(sum);
        br.close();
    }

    private static long findMin2(int[] keys) {
        long min2 = 101;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (i + j != 5)
                    if (keys[i] + keys[j] < min2)
                        min2 = keys[i] + keys[j];
            }
        }
        return min2;
    }

    private static long findMin3(int[] keys) {
        long min3 = 151;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++)
                for (int l = j + 1; l < 6; l++) {
                    if (i + j != 5 && i + l != 5 && j + l != 5)
                        if (keys[i] + keys[j] + keys[l] < min3)
                            min3 = keys[i] + keys[j] + keys[l];
                }
        }
        return min3;
    }
}