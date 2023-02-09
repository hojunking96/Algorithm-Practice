import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            hashSet.add(br.readLine());
        }
        int n = hashSet.size();
        String[] arr = new String[n];
        int ptr = 0;
        for (String k : hashSet) {
            arr[ptr++] = k;
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() == o2.length()) {
                if (o1.compareTo(o2) > 0) {
                    return 1;
                }
                return -1;
            }
            return -1;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}