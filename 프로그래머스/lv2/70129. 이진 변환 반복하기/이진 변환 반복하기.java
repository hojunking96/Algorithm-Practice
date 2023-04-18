class Solution {
    private static int cnt = 0;
    private static int roundCnt = 0;
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")){
            s = step1(s);
            s = step2(s.length());
            answer[0]++;
        }
        answer[1] = cnt;
        
        return answer;
    }
    private static String step1(String s){
        int len1 = s.length();
        String newS = s.replaceAll("0", "");
        int len2 = newS.length();
        cnt += len1 - len2;
        return newS;
    }
    private static String step2(int len){
        String newS = "";
        while(len > 0){
            newS = len % 2 + newS;
            len /= 2;
        }
    
        return newS;
    }
}