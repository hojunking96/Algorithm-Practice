class Solution {
    
    private long[] dp;
    
    public int solution(int n) {
        dp = new long[5001];
        dp[0] = 1;
        if(n >= 2){
            dp[2] = 3;            
        }
        if(n >= 4){
            dp[4] = 3 * 3 + 2;    
        }
        for(int i = 6; i <= n; i += 2){
            dp[i] = (dp[i - 2] * 3) % 1_000_000_007;
            for(int j = 0; j <= i - 4; j += 2){
                dp[i] += dp[j] * 2 % 1_000_000_007;
                dp[i] %= 1_000_000_007;
            }
        }
        return (int)dp[n];
    }
}

/*
dp 써야 될듯
n = 2 일 때,
가로가로가로 ,  세로세로가로, 가로세로세로 => 3가지

n = 3 일 때,
없네
2 * 1 칸으로 채우니까, 전체 공간이 2로 나누어져야함
n은 홀수가 아님

n = 4 일 때,
n = 2 일 때 * n = 2 일 때
또는 가운데 겹칠 때
2가지 추가임
가운데 가로 두 줄 넣고 나머지는 선택 불가 -> 2가지 경우 가능 위 아래

그러면 n 의 경우
n - 2 의 경우 + 2 의 경우
+ n - 4 의 경우 + 4의 경우




4 -> 2/2 + 4 => 3 * 3 + 2 = 11
6 -> 2/2/2 + 2/4 + 6 => 3^3 + (2 * 3) * 2 + 2 = 41
8 -> 2/2/2/2 + 2/2/4 + 2/6 + 8 => 3^4 + 3^2*2*3 + 3*2*2 + 2 = 149 왜 안맞지 153이어야함
n -> 2개짜리 n개 , 2개짜리 n-1개, 4개짜리 1개, 2개짜리 n-2개, 6개짜리 1개 

*/