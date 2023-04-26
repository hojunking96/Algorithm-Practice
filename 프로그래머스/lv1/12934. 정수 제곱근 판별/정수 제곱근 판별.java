class Solution {
    public long solution(long n) {
        long answer = (long)Math.sqrt(n);
        if(answer != Math.sqrt(n)){
            return -1;
        }
        return (long)Math.pow(answer + 1, 2);
    }
}