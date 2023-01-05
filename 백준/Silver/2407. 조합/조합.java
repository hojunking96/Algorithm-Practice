import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int min = Math.min(n - m, m);
        BigInteger upSide = new BigInteger("1");
        BigInteger downSide = new BigInteger("1");
        for (int i = 1; i <= min; i++) {
            upSide = upSide.multiply(new BigInteger(String.valueOf(n + 1 - i)));
            downSide = downSide.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(upSide.divide(downSide));
    }
}
