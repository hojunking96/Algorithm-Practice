import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        String max = makeMax(arr);
        String min = makeMin(arr);

        System.out.println(max);
        System.out.println(min);

    }

    private static String makeMax(char[] arr) {
        String max = "";
        int MCnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'M') {
                MCnt++;
                if (i == arr.length - 1) {
                    for (int j = 0; j < MCnt; j++) {
                        max += 1;
                    }
                }
            }
            if (arr[i] == 'K') {
                max += 5;
                for (int j = 0; j < MCnt; j++) {
                    max += 0;
                }
                MCnt = 0;
            }
        }
        return max;
    }

    private static String makeMin(char[] arr) {
        String min = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'M') {
                if (i >= 1 && arr[i - 1] == 'M') {
                    min += '0';
                } else {
                    min += '1';
                }
            } else {
                min += '5';
            }
        }
        return min;
    }
}
