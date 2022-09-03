import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static private void countAlpha(int alpha[], String k) {
        for (int i = 0; i < k.length(); i++) {
            int index = k.charAt(i) - 'A'; // i번째글자 뽑아냄
            alpha[index]++; // 개수 저장
        }
    }

    static private boolean OddCheck(int alpha[]) { // 홀수인 개수 확인
        int cnt = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] % 2 == 1)
                cnt++;
            if (cnt > 1)
                break;
        }
        if (cnt > 1) // 1개보다 많으면 불가능함
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String X = br.readLine();
        String k = "";
        int[] alphabet = new int[26];

        countAlpha(alphabet, X);
        if (OddCheck(alphabet))
            k = "I'm Sorry Hansoo";
        else {
            for (int i = 0; i < alphabet.length; i++) {
                for (int r = 0; r < alphabet[i] / 2; r++) { // 반만큼 str에 추가
                    sb.append((char) (i + 65));
                }
            }
            k += sb.toString();
            String K_reverse = sb.reverse().toString();
            sb = new StringBuilder();
            for (int i = 0; i < alphabet.length; i++) { // 가운데 수 추가
                if (alphabet[i] % 2 == 1) {
                    sb.append((char) (i + 65));
                }
            }
            k += sb.toString() + K_reverse;
        }
        System.out.println(k);
        br.close();
    }
}
