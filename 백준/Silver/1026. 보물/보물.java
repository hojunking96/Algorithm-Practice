import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int S = 0, AMin, BMax;
        int N;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        StringTokenizer a = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A.add(Integer.parseInt(a.nextToken()));

        StringTokenizer b = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            B.add(Integer.parseInt(b.nextToken()));

        for (int j = 0; j < N; j++) {
            AMin = Collections.min(A);
            BMax = Collections.max(B);
            S += AMin * BMax;
            A.remove(Integer.valueOf(AMin));
            B.remove(Integer.valueOf(BMax));
        }
        bw.write(S + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}