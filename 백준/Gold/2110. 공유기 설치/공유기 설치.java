import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int k = binarySearch(arr, C, N);
        System.out.println(k);
    }

    public static int binarySearch(int[] arr, int key, int N) {
        int left = 1;
        int right = arr[N - 1] - arr[0] + 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (canInstall(mid, arr, N) < key) {
                right = mid - 1;
            } else {
                /**
                 * 설치 가능한 공유기 개수가 M 개수보다 크거나 같으면
                 * 거리를 벌리면서 최소거리가 가질 수 있는 최대 거리를
                 * 찾아낸다.
                 */
                left = mid + 1;
            }
        }
        return right;
    }

    public static int canInstall(int distance, int[] arr, int N) {

        // 첫 번째 집은 무조건 설치한다고 가정
        int count = 1;
        int lastLocate = arr[0];

        for (int i = 1; i < N; i++) {
            int locate = arr[i];

            /*
             *  현재 탐색하는 집의 위치와 직전에 설치했던 집의 위치간 거리가
             *  최소 거리(distance)보다 크거나 같을 때 공유기 설치 개수를 늘려주고
             *  마지막 설치 위치를 갱신해준다.
             */
            if (locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }
        return count;

    }
}
