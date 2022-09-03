import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int arithmeticMean(int cnt[], int min, int max, int N) {
        double s = 0;
        for (int i = min; i <= max; i++) {
            s += ((i - 4000) * cnt[i]);
        }
        if (s < 0)
            return (int) (s / N - 0.5);
        else
            return (int) (s / N + 0.5);
    }

    static int Median(int cnt[], int min, int max, int N) {
        int s = 0, i;
        for (i = min; i <= max; i++) {
            s += cnt[i];
            if (s >= (N + 1) / 2)
                break;
        }
        return i - 4000;
    }

    static int Mode(int cnt[], int min, int max, int N) {
        int maxcnt = 0;
        int maxInd = 0;
        int flag = 0;
        for (int i = min; i <= max; i++) {
            if (cnt[i] > maxcnt) {
                maxcnt = cnt[i];
                maxInd = i - 4000;
                flag = 0;
            } else if (cnt[i] == maxcnt && flag == 0) {
                flag = 1;
                maxInd = i - 4000;
            }
        }
        return maxInd;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int min = 8001;
        int max = -1;
        int cnt[] = new int[8001];
        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine()) + 4000;
            cnt[k]++;
            if (k < min)
                min = k;
            if (k > max)
                max = k;
        }
        sb.append(arithmeticMean(cnt, min, max, N) + "\n");
        sb.append(Median(cnt, min, max, N) + "\n");
        sb.append(Mode(cnt, min, max, N) + "\n");
        sb.append(max - min + "\n");
        System.out.println(sb);
        br.close();
    }
}
