import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int N, K, cnt = 0;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		int []x = new int[N];
		for (int i = 0; i < N; i++) {
			x[i] = sc.nextInt();
		}
		for (int i = N - 1; i >= 0; i--) {
			while (x[i] <= K) {
				if (x[i] <= K) {
					K -= x[i];
					cnt++;
				}
			}
			if (K == 0)
				break;
		}
		System.out.println(cnt);
	}

}


