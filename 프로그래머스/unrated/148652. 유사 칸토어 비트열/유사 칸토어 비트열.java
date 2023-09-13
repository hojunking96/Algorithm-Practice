class Solution {
    
    public int solution(int n, long l, long r) {
        long length = 1;
        for(int i = 0; i < n; i++){
            length *= 5;
        }
        int sum = 0;
        for(long i = l; i <= r; i++){
            sum += job(length, i);
        }
        return sum;
    }
    
    private int job(long length, long idx){
        while(length > 0){
            long left = length / 5 * 2 + 1;
            long right = length / 5 * 3;
            if(left <= idx % length && idx % length <= right){
                return 0;
            }
            length /= 5;
        }
        return 1;
    }
}

/*

n-1번째 : 1 -> 11011       0 -> 00000

0번째 : 1
1번째 : 1                             1                             0                             1                             1
2번째 : 1     1     0     1     1     1     1     0     1     1     0     0     0     0     0     1     1     0     1     1     11011
3번째 : 11011 11011 00000 11011 11011 11011 11011 00000 11011 11011 00000 00000 00000 00000 00000 11011 11011 00000 11011 11011 11011 11011 00000 11011 11011


0이 되는 것들

1번째 1 * 2 + 1 <= 5로 나눈 나머지 <= 1 * 3
2번째 5 * 2 + 1 <= 25로 나눈 나머지 <= 5 * 3
3번째 25 * 2 + 1 <= 125로 나눈 나머지 <= 25 * 3

n번째 일 때
5^(n-1) * 2 + 1 <= 5^n로 나눈 나머지 <= 5^(n-1) + 1



*/