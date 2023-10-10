import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int n3 = Integer.parseInt(st.nextToken());
        int prize = 0;
        if (n1 == n2) {
            if (n2 == n3) {
                prize = 10000 + n1 * 1000;
            } else {
                prize = 1000 + n1 * 100;
            }
        } else {
            if (n2 == n3) {
                prize = 1000 + n2 * 100;
            } else if (n1 == n3) {
                prize = 1000 + n1 * 100;
            } else {
                int max = Math.max(n1, n2);
                prize = 100 * Math.max(max, n3);
            }
        }
        System.out.println(prize);
    }
}