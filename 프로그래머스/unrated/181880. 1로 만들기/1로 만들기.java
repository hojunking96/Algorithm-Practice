class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        for(int num : num_list){
            answer += divide(num);
        }
        return answer;
    }
    private int divide(int num){
        int cnt = 0;
        while(num != 1){
            if(num % 2 == 0){
                num /= 2;
                cnt++;
            }
            else{
                num--;
            }
        }
        return cnt;
    }
}