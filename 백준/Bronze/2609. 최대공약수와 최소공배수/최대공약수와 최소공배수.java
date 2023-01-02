import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int gcd = GCD(num1, num2);
        int lst = LST(num1, num2, gcd);
        System.out.println(gcd);
        System.out.println(lst);
        br.close();
    }

    public static int GCD(int num1, int num2) {
        while (num1 * num2 != 0) {
            if (num1 > num2)
                num1 -= num2;
            else
                num2 -= num1;
        }
        if (num1 == 0)
            return num2;
        else
            return num1;
    }

    public static int LST(int num1, int num2, int gcd) {
        return num1 * (num2 / gcd);
    }

}
