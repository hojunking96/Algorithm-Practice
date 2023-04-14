import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String answer = "";
        for (char k : input.toCharArray()) {
            if (k >= 'a' && k <= 'z') {
                k += 'A' - 'a';
            } else {
                k += 'a' - 'A';
            }
            answer+=k;
        }
        System.out.println(answer);
    }
}