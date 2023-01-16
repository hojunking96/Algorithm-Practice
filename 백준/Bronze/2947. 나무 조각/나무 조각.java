import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static int[] arr;
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        doChange();
        System.out.println(sb);
    }

    public static void doChange() {
        if (FTChange()) {
            swap(0, 1);
            print();
        }
        if (TTChange()) {
            swap(1, 2);
            print();
        }
        if (TFChange()) {
            swap(2, 3);
            print();
        }
        if (FFChange()) {
            swap(3, 4);
            print();
        }
        if (FTChange() || TTChange() || TFChange() || FFChange())
            doChange();
    }

    public static boolean FTChange() {
        return arr[0] > arr[1];
    }

    public static boolean TTChange() {
        return arr[1] > arr[2];
    }

    public static boolean TFChange() {
        return arr[2] > arr[3];
    }

    public static boolean FFChange() {
        return arr[3] > arr[4];
    }

    public static void swap(int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    public static void print() {
        for (int e : arr) {
            sb.append(e).append(" ");
        }
        sb.append("\n");
    }

}