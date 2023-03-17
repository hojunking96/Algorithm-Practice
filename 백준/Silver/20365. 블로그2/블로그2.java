import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String colors = br.readLine();
        int cnt = 1;
        for (int i = 0; i < colors.length() - 1; i++) {
            if (colors.charAt(i) != colors.charAt(i + 1)) {
                cnt++;
            }
        }
        System.out.println(cnt / 2 + 1);
    }
}
