import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int mid = partition(arr, low, high);
        sort(arr, low, mid - 1);
        sort(arr, mid, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
        while (low <= high) {
            while (arr[low] > pivot)
                low++;
            while (arr[high] < pivot)
                high--;
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void quickSort2(int[] arr) {
        sort2(arr, 0, arr.length - 1);
    }

    private static void sort2(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int mid = partition2(arr, low, high);
        sort2(arr, low, mid - 1);
        sort2(arr, mid, high);
    }

    private static int partition2(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
        while (low <= high) {
            while (arr[low] < pivot)
                low++;
            while (arr[high] > pivot)
                high--;
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] Positive = new int[N];
        int[] Negative = new int[N];
        int cnt1 = 0, cnt2 = 0, sum = 0, i;
        for (i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a > 0) {
                Positive[cnt1] = a;
                cnt1++;
            } else {
                Negative[cnt2] = a;
                cnt2++;
            }
        }
        // 내림차순으로 정리하고
        // 음수나 0의 경우 생각해야함
        quickSort(Positive);
        quickSort2(Negative);
        i = 0;
        while (i < cnt1) {
            if (i + 1 < cnt1 && Positive[i] != 1 && Positive[i + 1] != 1)
                sum += Positive[i++] * Positive[i++];
            else
                sum += Positive[i++];
        }
        i = 0;
        while (i < cnt2) {
            if (i + 1 < cnt2)
                sum += Negative[i++] * Negative[i++];
            else
                sum += Negative[i++];
        }
        System.out.println(sum);
        br.close();
    }
}
