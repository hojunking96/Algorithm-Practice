import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static String[] zero = {"", "0", "00", "000", "0000"};
    private static List<String> ips = new ArrayList<>();
    private static String answer = "";
    private static int blankIndex = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ipv6 = br.readLine();

        convert(ipv6);

        if (blankIndex != -1) {
            fill(blankIndex);
        }
        makeString();

        System.out.println(answer);
    }

    private static void convert(String ipv6) {
        String str = "";
        for (int i = 0; i < ipv6.length(); i++) {
            str += ipv6.charAt(i);
            if (ipv6.charAt(i) == ':') {
                if (i > 0) {
                    if (ipv6.charAt(i - 1) == ':') {
                        blankIndex = ips.size();
                        ips.add("X");
                        str = "";
                        continue;
                    }
                }
                ips.add(make4(str));
                str = "";
            }
        }
        ips.add(zero[4 - str.length()] + str);
    }

    private static String make4(String each4) {
        return zero[5 - each4.length()] + each4;
    }

    private static void fill(int blankIndex) {
        String blank = "";
        for (int i = 0; i < 9 - ips.size(); i++) {
            blank += "0000:";
        }
        ips.set(blankIndex, blank);
    }

    private static void makeString() {
        for (String e : ips) {
            answer += e;
        }
    }
}