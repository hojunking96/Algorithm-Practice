class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            if((int)Math.sqrt(i) == Math.sqrt(i)){
                answer -= i;
            }
            else{
                answer += i;
            }
        }
        return answer;
    }
}