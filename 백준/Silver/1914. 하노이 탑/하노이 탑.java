import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
    public static StringBuilder sb;
    public static int cnt = 0;
    public static BigInteger cnt2;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        cnt2 = new BigInteger("0");
        if (N <= 20) {
            Hanoi(N, 1, 2, 3);
            System.out.println(cnt);
            System.out.println(sb);
        } else {
            System.out.println(HanoiCnt(N));
        }
    }

    public static BigInteger HanoiCnt(int weight) {
        if (weight == 1) {
            return new BigInteger("1");
        }
        return (HanoiCnt(weight - 1).multiply(new BigInteger("2")).add(new BigInteger("1")));
    }

    public static void Hanoi(int weight, int start, int bridge, int end) {
        cnt++;
        if (weight == 1) {
            sb.append(start + " " + end).append("\n");
            return;
        }
        Hanoi(weight - 1, start, end, bridge);
        sb.append(start + " " + end).append("\n");
        Hanoi(weight - 1, bridge, start, end);
    }
}