import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if (input.length() % 4 != 0) {
            System.out.println(0);
            return;
        }
        int eachLength = input.length() / 4;

        Set<String> set = new HashSet<>();
        for (int i = 0; i < eachLength; i++) {
            if (input.length() == 0) {
                break;
            }
            String str = "";
            for (int j = 0; j <= i; j++) {
                str += 'w';
            }
            for (int j = 0; j <= i; j++) {
                str += 'o';
            }
            for (int j = 0; j <= i; j++) {
                str += 'l';
            }
            for (int j = 0; j <= i; j++) {
                str += 'f';
            }
            set.add(str);
        }

        boolean isRight = true;
        int start = 0;
        for (int i = 3; i < input.length(); i += 4) {
            if (set.contains(input.substring(start, i + 1))) {
                start = i + 1;
                isRight=true;
            } else {
                isRight = false;
            }
        }
        if (isRight) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}