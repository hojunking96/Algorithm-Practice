class Solution {
    
    public static int N;
    
    public int[] solution(int[] prices) {
        int[] answer = {};
         N = prices.length;
        answer = new int[N];
        
        calculate(prices, answer);
        return answer;
    }
    

    public static void calculate(int[] prices, int[] answer) {

        for (int i = 0; i < N; i++) {
            int cnt = 1;
            int j = i + 1;
            for (j = i + 1; j < N; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = cnt;
                    break;
                }
                cnt++;
            }
            if (j == N)
                answer[i] = cnt - 1;
        }
        answer[N - 1] = 0;
    }
}