class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long cnt = (long)count;
        answer = cnt * (cnt + 1) / 2 * price;
        if(answer > money){
            return answer - money;
        }
        return 0;
    }
}