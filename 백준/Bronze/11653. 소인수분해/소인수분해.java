import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        factorization(k);
    }

    public static void factorization(int key) {
        int i = 2;
        while (true) {
            if (key == 1)
                break;
            else if (key % i == 0) {
                key /= i;
                System.out.println(i);
            } else i++;
        }
    }
}
