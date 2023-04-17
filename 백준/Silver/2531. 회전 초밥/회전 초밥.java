import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] cnt = new int[d + 1];
        int[] arr = new int[N];
        int numCnt = 0;

        //k개 윈도우
        for (int i = 0; i < k; i++) {
            int next = Integer.parseInt(br.readLine());
            if (cnt[next] == 0) {
                numCnt++;
            }
            cnt[next]++;
            arr[i] = next;
        }
        int max = numCnt;

        //i가 1씩 증가하면서 윈도우 1칸씩 이동
        for (int i = k; i < N; i++) {
            int next = Integer.parseInt(br.readLine());

            if (cnt[next] == 0) {
                numCnt++;
            }
            cnt[next]++;
            arr[i] = next;

            if (cnt[arr[i - k]] == 1) {
                numCnt--;
            }
            cnt[arr[i - k]]--;

            if (cnt[c] == 0) {
                max = Math.max(max, numCnt + 1);
            } else {
                max = Math.max(max, numCnt);
            }
        }
        //n 까지 돌고 남은 것
        for (int i = 0; i < k; i++) {
            int next = arr[i];
            if (cnt[next] == 0) {
                numCnt++;
            }
            cnt[next]++;

            if (cnt[arr[(i - k + N)]] == 1) {
                numCnt--;
            }
            cnt[arr[i - k + N]]--;

            if (cnt[c] == 0) {
                max = Math.max(max, numCnt + 1);
            } else {
                max = Math.max(max, numCnt);
            }
        }
        System.out.println(max);
    }
}