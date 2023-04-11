import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, d, k, c;
    private static int[] arr;
    private static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            int idx = i;
            if (i > N) {
                idx = i % N;
            }
            if (map.containsKey(arr[idx])) {
                int value = map.get(arr[idx]);
                map.replace(arr[idx], value + 1);
            } else {
                map.put(arr[idx], 1);
            }
        }

        max = map.size();
        for (int i = 1; i < N; i++) {
            int left = (i - 1 + N) % N;
            int right = (i + k - 1) % N;

            if (map.get(arr[left]) == 1) {
                map.remove(arr[left]);
            } else {
                int value = map.get(arr[left]);
                map.replace(arr[left], value - 1);
            }

            if (map.containsKey(arr[right])) {
                int value = map.get(arr[right]);
                map.replace(arr[right], value + 1);
            } else {
                map.put(arr[right], 1);
            }
            if (!map.containsKey(c)) {
                max = Math.max(max, map.size() + 1);
                if (max == k + 1) {
                    break;
                }
            } else {
                max = Math.max(max, map.size());
            }
        }
        System.out.println(max);
    }
}