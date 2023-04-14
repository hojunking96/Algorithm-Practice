import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        int k = Integer.parseInt(br.readLine());
        for (int i = 2; i <= k; i++) {
            t *= i;
        }
        System.out.println(t);
    }
}