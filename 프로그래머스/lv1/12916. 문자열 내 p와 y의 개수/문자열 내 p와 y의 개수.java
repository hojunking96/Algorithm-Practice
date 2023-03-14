class Solution {
    boolean solution(String s) {
        int pCnt=0;
        int yCnt=0;
        boolean answer = true;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='p'||s.charAt(i)=='P'){
                pCnt++;
                answer=false;
            }
            else if(s.charAt(i)=='y'||s.charAt(i)=='Y'){
                yCnt++;
                answer=false;
            }
        }
        if(pCnt==yCnt){
            return true;
        }
        return answer;
    }
}