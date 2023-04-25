class Solution {
    public long solution(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        if(n < 2){
            return dp[n];
        }
        dp[2] = 2;
        if(n < 3){
            return dp[n];
        }
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1]%1234567 + dp[i-2]%1234567;
        }
        
        return dp[n]%1234567;
    }
}