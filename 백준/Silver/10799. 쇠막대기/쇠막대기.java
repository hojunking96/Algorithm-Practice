import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < string.length(); i++) {
            char k = string.charAt(i);
            if (k == ')') {
                if (string.charAt(i - 1) == ')') {
                    sum++;
                    cnt--;
                }
            } else if (k == '(') {
                if (string.charAt(i + 1) == ')')
                    sum += cnt;
                else
                    cnt++;
            }
        }
        System.out.println(sum);
    }
}
