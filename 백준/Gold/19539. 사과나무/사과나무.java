import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        int sum = 0, twoLevel = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            sum += trees[i];
            twoLevel += trees[i] / 2;
        }
        if (sum % 3 != 0)
            System.out.println("NO");
        else if (twoLevel >= (sum / 3))
            System.out.println("YES");
        else
            System.out.println("NO");
        br.close();
    }

}
