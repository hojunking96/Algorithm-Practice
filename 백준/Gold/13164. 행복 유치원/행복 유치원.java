import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int sum = 0;

        List<Integer> children = new ArrayList<>();
        List<Integer> costs = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            children.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < N - 1; i++) {
            costs.add(children.get(i + 1) - children.get(i));
        }
        Collections.sort(costs, Collections.reverseOrder());
        for (int i = K - 1; i < N - 1; i++) {
            sum += costs.get(i);
        }
        System.out.println(sum);
        br.close();


    }
}
