import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(pibo(N));
    }

    public static int pibo(int N) {
        if (N == 0)
            return 0;
        if (N == 1)
            return 1;
        return (pibo(N - 1) + pibo(N - 2));
    }

}