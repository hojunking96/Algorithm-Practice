class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        answer = (long)count * (count + 1) / 2 * price;
        if(answer > money){
            return answer - money;
        }
        return 0;
    }
}