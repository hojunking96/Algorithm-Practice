import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] positions = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int newPosition = Integer.parseInt(st.nextToken());
            if (newPosition > S)
                positions[i] = newPosition - S;
            else
                positions[i] = S - newPosition;
        }
        int gcd = positions[0];
        for (int i = 1; i < N; i++) {
            gcd = findGCD(gcd, positions[i]);
        }
        System.out.println(gcd);
    }


    private static int findGCD(int num1, int num2) {
        int tmp, n;
        if (num1 < num2) {
            tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        while (num2 != 0) {
            n = num1 % num2;
            num1 = num2;
            num2 = n;
        }
        return num1;
    }
}
