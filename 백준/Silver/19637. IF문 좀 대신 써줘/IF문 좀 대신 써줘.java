import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        String[] title = new String[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            title[i] = input[0];
            arr[i] = Integer.parseInt(input[1]);
        }
        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine());
            int left = 0;
            int right = N - 1;
            while (left <= right) {
                int mid = (right + left) / 2;
                if (power <= arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            sb.append(title[right + 1]).append("\n");
        }
        System.out.println(sb);
    }
}