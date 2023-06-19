import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        int[] xNumbers = new int[10];
        int[] yNumbers = new int[10];
        
        int xLen = X.length();
        int yLen = Y.length();
        
        char[] xCharArray = X.toCharArray();
        char[] yCharArray = Y.toCharArray();
        
        if(xLen > yLen){
            for(int i = 0; i < yLen; i++){
                xNumbers[(int)(xCharArray[i] - '0')]++;
                yNumbers[(int)(yCharArray[i] - '0')]++;
            }
            for(int i = yLen; i < xLen; i++){
                xNumbers[(int)(xCharArray[i] - '0')]++;
            }
        }
        else{
            for(int i = 0; i < xLen; i++){
                xNumbers[(int)(xCharArray[i] - '0')]++;
                yNumbers[(int)(yCharArray[i] - '0')]++;
            }
            for(int i = xLen; i < yLen; i++){
                yNumbers[(int)(yCharArray[i] - '0')]++;
            }            
        }
        for(int i = 9; i >= 0; i--){
            answer += (""+i).repeat(Math.min(xNumbers[i], yNumbers[i]));         
        }
        
        if(answer.equals("")){
            return "-1";
        }
        if(answer.charAt(0) == '0'){
            return "0";
        }
        return answer;
    }
}