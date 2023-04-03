import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] board = new char[R][C];
        List<String> strings = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            String str = "";
            for (int j = 0; j < C; j++) {
                if (board[i][j] != '#') {
                    str += board[i][j];
                } else {
                    if (str.length() >= 2) {
                        strings.add(str);
                    }
                    str = "";
                }
            }
            if (str.length() >= 2) {
                strings.add(str);
            }
        }
        for (int i = 0; i < C; i++) {
            String str = "";
            for (int j = 0; j < R; j++) {
                if (board[j][i] != '#') {
                    str += board[j][i];
                } else {
                    if (str.length() >= 2) {
                        strings.add(str);
                    }
                    str = "";
                }
            }
            if (str.length() >= 2) {
                strings.add(str);
            }
        }
        Collections.sort(strings);
        System.out.println(strings.get(0));
    }
}