import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int N, K, space, cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int X[] = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            X[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] Y = new boolean[101];
        space = N;

        for (int i = 0; i < K; i++) {
            if (Y[X[i]] == false) { // 콘센트에 안꽂혀있을 때
                if (space != 0) { // 콘센트에 자리가 남을 때
                    Y[X[i]] = true;
                    space--;
                } else { // 콘센트에 자리가 없을 때
                    ArrayList<Integer> Z = new ArrayList<>(); // 나중에 사용될 것들 배열
                    for (int j = i + 1; j < K; j++) { // +1 맞나 확인
                        if (Y[X[j]] && !Z.contains(X[j])) { // 사용중인데 나중에 다시 사용 될 때
                            Z.add(X[j]); // list에 추가
                        }
                    }
                    if (Z.size() < N) { // 사용중인데 나중에 사용될 것들이 구멍 수보다 작으면 아무거나 삭제해도 됨
                        for (int j = 0; j < Y.length; j++) {
                            if (Y[j] && !Z.contains(j)) { // 꽂혀있는데 안쓸 것 제거
                                Y[j] = false;
                                break;
                            }
                        }
                    } else {
                        int t = Z.get(Z.size() - 1); // 가장 마지막에 사용될 콘센트를 제거.
                        Y[t] = false;
                    }
                    Y[X[i]] = true;
                    cnt++;
                }
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}