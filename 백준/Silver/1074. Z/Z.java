import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int len = (int) Math.pow(2, N);
        rFind(r, c, len);
        System.out.println(cnt);

    }

    public static void rFind(int r, int c, int len) {
        if (len == 1) {
            return;
        }
        if (r < len / 2 && c < len / 2) {
            rFind(r, c, len / 2);

        } else if (r < len / 2 && c >= len / 2) {
            cnt += len * len / 4;
            rFind(r, c - len / 2, len / 2);

        } else if (r >= len / 2 && c < len / 2) {
            cnt += (len * len / 4) * 2;
            rFind(r - len / 2, c, len / 2);
        } else {
            cnt += (len * len / 4) * 3;
            rFind(r - len / 2, c - len / 2, len / 2);

        }

    }
}

/*
 * N : k^2-1 임
 * */