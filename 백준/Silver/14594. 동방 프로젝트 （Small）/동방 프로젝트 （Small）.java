import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static HashSet<Double> walls;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        walls = new HashSet<>();
        for (int i = 0; i < N - 1; i++) {
            walls.add(((double) i + i + 1) / 2);
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            doJB(start, end);
        }
        System.out.println(walls.size() + 1);
    }

    private static void doJB(int start, int end) {
        List<Double> removeList = new ArrayList<>();
        for (Double wall : walls) {
            if (wall > start && wall < end) {
                removeList.add(wall);
            }
        }
        for (double wall : removeList) {
            walls.remove(wall);
        }
    }
}