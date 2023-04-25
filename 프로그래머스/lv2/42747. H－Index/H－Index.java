class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        for(int t = 0; t <= 10000; t++){
            int upCnt = 0;
            int downCnt = 0;
            for(int i = 0; i < citations.length; i++){
                if(citations[i] >= t){
                    upCnt++;
                }
                if(citations[i] <= t){
                    downCnt++;
                }
            }
            if(upCnt >= t && downCnt <= t){
                answer = t;
            }
        }
        return answer;
    }
}