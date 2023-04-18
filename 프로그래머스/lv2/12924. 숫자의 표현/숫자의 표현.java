class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = 1;
        int temp = 0;
        for (int i = 1; i <= n / 2; i++){
            temp = 0;
            num = i;
            while(temp <= n){
                temp += num++;
                if(temp == n){ 
                    answer++;
                }
            }
        }
        return answer + 1;
    }
}