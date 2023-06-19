class Solution {
    public int solution(String s) {
        int xCnt = 0;
        int notXCnt = 0;
        int answer = 0;
        char firstLetter = s.charAt(0);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == firstLetter){
                xCnt++;
            }
            else{
                notXCnt++;
            }
            if(xCnt == notXCnt){
                answer++;
                xCnt = 0;
                notXCnt = 0;
                if(i + 1 < s.length()){
                    firstLetter = s.charAt(i + 1);
                }
            }
            else{
                if(i == s.length() - 1){
                    answer++;
                }
            }
        }
        return answer;
    }
}