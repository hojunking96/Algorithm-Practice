import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for (int i = 2; i <= N; i++) {
            pibo(list, i);
        }
        System.out.println(list.get(N));
    }

    public static void pibo(List<Integer> list, int N) {
        list.add(list.get(N - 1) + list.get(N - 2));
    }

}