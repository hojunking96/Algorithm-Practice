class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int t=i;t<=j;t++){
            int value = t;
            while(value>0){
                int tmp = value%10;
                if(tmp==k){
                    answer++;
                }
                value/=10;
            }
        }
        return answer;
    }
}