import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static boolean[][] paper;
    public static StringBuilder sb;
    public static int cntBlue = 0;
    public static int cntWhite = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        paper = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String tmp = st.nextToken();
                if (tmp.equals("1"))
                    paper[i][j] = true;
                else
                    paper[i][j] = false;
            }
        }
        checkColor(0, 0, N);
        System.out.println(cntWhite);
        System.out.println(cntBlue);

    }

    public static void checkColor(int xStart, int yStart, int size) {
        boolean std = paper[xStart][yStart];
        if (size == 1) {
            if (std) {
                cntBlue++;
            }
            if (!std) {
                cntWhite++;
            }
            return;
        }

        boolean isGood = true;
        for (int i = xStart; i < xStart + size; i++) {
            for (int j = yStart; j < yStart + size; j++) {
                if (paper[i][j] != std) {
                    isGood = false;
                    checkColor(xStart, yStart, size / 2);
                    checkColor(xStart + size / 2, yStart, size / 2);
                    checkColor(xStart, yStart + size / 2, size / 2);
                    checkColor(xStart + size / 2, yStart + size / 2, size / 2);
                    break;
                }
            }
            if (!isGood)
                break;
        }
        if (isGood) {
            if (std) {
                cntBlue++;
            }
            if (!std) {
                cntWhite++;
            }
        }
    }
}