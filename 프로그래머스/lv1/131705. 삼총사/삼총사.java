class Solution {

    public static int[] arr = new int[3];
    public static int cnt = 0;
    public int solution(int[] number) {
        int answer = 0; 
        DFS(0, 0, number);
        answer = cnt;
        return answer;
    }
      public void DFS(int start, int depth, int[] numbers) {
        int sum = 0;
        if (depth == 3) {
            for (int e : arr) {
                sum += e;
            }
            if (sum == 0)
                cnt++;
            return;
        }
        for (int i = start; i < numbers.length; i++) {
            arr[depth] = numbers[i];
            DFS(i + 1, depth + 1, numbers);
        }
    }
}
