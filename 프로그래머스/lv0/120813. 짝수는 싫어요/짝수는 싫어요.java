class Solution {
    public int[] solution(int n) {
        int idx=0;
        int[] answer = new int[(n+1)/2];
        for(int i=1;i<=n;i+=2){
            if(i%2==1){
                answer[idx]=i;  
                idx++;
            }
        }
        return answer;
    }
}