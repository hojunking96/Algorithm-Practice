import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static long[] arr = new long[64];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (long)Math.pow(2, i);
        }

        System.out.println(make(k));
    }

    public static int make(long k) {
        if (k == 1)  return 0;
        long N = 0;

        for (int i = 0; i < arr.length; i++) {
            if (k > arr[i]) N = arr[i];
            else break;

        }
        return 1 - make(k - N);
    }

}