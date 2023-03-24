import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if (M == 0) {
            if (N >= 99 && N <= 102) {
                calcCnt1(N);
            } else {
                min = ("" + N).length();
            }
        } else {
            String[] arr = new String[M];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arr[i] = st.nextToken();
            }

            calcCnt1(N);
            calcCnt2(N, arr);
        }
        System.out.println(min);
    }

    private static void calcCnt1(int N) {
        min = Math.abs(N - 100);
    }

    private static void calcCnt2(int N, String[] arr) {
        int diff = 0;
        int len;
        int minPlus = Integer.MAX_VALUE;
        int maxPlus = Integer.MAX_VALUE;
        while (true) {
            if (diff >= min) {
                return;
            }

            if (minPlus != Integer.MAX_VALUE || maxPlus != Integer.MAX_VALUE) {
                min = Math.min(min, Math.min(minPlus, maxPlus));
                return;
            }

            String newNumPlus = "" + (N + diff);
            boolean hasError = false;
            for (String e : arr) {
                if (newNumPlus.contains(e)) {
                    hasError = true;
                    break;
                }
            }

            if (!hasError) {
                len = ("" + (N + diff)).length();
                maxPlus = diff + len;
            }


            String newNumMinus = "" + (N - diff);
            hasError = false;
            for (String e : arr) {
                if (newNumMinus.contains(e)) {
                    hasError = true;
                    break;
                }
            }


            if (!hasError) {
                len = ("" + (N - diff)).length();
                minPlus = diff + len;
            }


            diff++;
        }
    }
}
//2222 or 999
/*
 * 5457
 * 5 -> 4 -> 5 -> 9 -> - -> -
 * 총 6번
 * */

/*
반례
1555
3
0 1 9
ans 670


99999
9
0 2 3 4 5 6 7 8 9
ans 11118


50000
9
0 1 2 3 4 5 6 7 8
ans 40005


139133
7
9 6 8 2 1 5 7
ans 94694


*/
