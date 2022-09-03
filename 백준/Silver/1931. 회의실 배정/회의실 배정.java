import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class times {
    int start;
    int end;

    times(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void quickSort(times[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(times[] arr, int low, int high) {
        if (low >= high)
            return;

        int mid = partition(arr, low, high);
        sort(arr, low, mid - 1);
        sort(arr, mid, high);
    }

    private static int partition(times[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2].end;
        int pivot2 = arr[(low + high) / 2].start;
        int len = arr.length;
        while (low <= high) {
            while (true) {
                if (arr[low].end > pivot || arr[low].end == pivot && arr[low].start >= pivot2)
                    break;
                if (low == len - 1)
                    break;
                low++;
            }
            while (true) {
                if (arr[high].end < pivot || arr[high].end == pivot && arr[high].start <= pivot2)
                    break;
                if (high == 0)
                    break;
                high--;
            }
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    private static void swap(times[] arr, int i, int j) {
        times tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = 1, t_line;
        int N = Integer.parseInt(br.readLine());
        times t[] = new times[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            t[i] = new times(a, b);
        }
        quickSort(t); // 끝나는 시간이 빠른 순서로 정렬
        t_line = t[0].end;
        for (int i = 1; i < N; i++) {
            if (t[i].start >= t_line) {
                t_line = t[i].end;
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
