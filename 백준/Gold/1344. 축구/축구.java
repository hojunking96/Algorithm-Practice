import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double A = Integer.parseInt(br.readLine());
        double B = Integer.parseInt(br.readLine());
        double a = 1;
        double k = (double) 1 / 2;

        double AScoreProbability = primeNumProbability(A / 100);
        double BScoreProbability = primeNumProbability(B / 100);
        double answer = 1 - AScoreProbability * BScoreProbability;
        System.out.println(answer);
    }

    public static double primeNumProbability(double scoreProbability) {
        double sum = 0;
        sum += combination(0) * calcProbability(scoreProbability, 0);
        sum += combination(1) * calcProbability(scoreProbability, 1);
        sum += combination(4) * calcProbability(scoreProbability, 4);
        sum += combination(6) * calcProbability(scoreProbability, 6);
        sum += combination(8) * calcProbability(scoreProbability, 8);
        sum += combination(9) * calcProbability(scoreProbability, 9);
        sum += combination(10) * calcProbability(scoreProbability, 10);
        sum += combination(12) * calcProbability(scoreProbability, 12);
        sum += combination(14) * calcProbability(scoreProbability, 14);
        sum += combination(15) * calcProbability(scoreProbability, 15);
        sum += combination(16) * calcProbability(scoreProbability, 16);
        sum += combination(18) * calcProbability(scoreProbability, 18);
        return sum;
    }

    public static double calcProbability(double scoreProbability, int cnt) {
        double result = 1;
        for (int i = 0; i < cnt; i++) {
            result *= scoreProbability;
        }
        for (int i = cnt; i < 18; i++) {
            result *= (1 - scoreProbability);
        }
        return result;
    }

    public static double combination(int cnt) {
        double upSide = 1;
        double downSide = 1;
        for (int i = 1; i <= cnt; i++) {
            upSide *= (19 - i);
            downSide *= i;
        }
        return upSide / downSide;
    }
}
