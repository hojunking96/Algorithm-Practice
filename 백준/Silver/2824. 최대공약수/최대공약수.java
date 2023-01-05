import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        BigInteger num1 = new BigInteger("1");
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num1 = num1.multiply(new BigInteger(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        BigInteger num2 = new BigInteger("1");
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            num2 = num2.multiply(new BigInteger(st.nextToken()));
        }
        String result = num1.gcd(num2).toString();
        int length = result.length();
        if (length > 9)
            result = result.substring(length - 9, length);
        System.out.println(result);
    }

}
