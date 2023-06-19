
import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String alphaStr = "abcdefghijklmnopqrstuvwxyz";
        char[] skipCharArr = skip.toCharArray();
        for(char e : skipCharArr){
            alphaStr = alphaStr.replaceAll("" + e, "");
        }
        
        char[] alphaCharArr = alphaStr.toCharArray();
        Map<Character, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < alphaCharArr.length; i++){
            indexMap.put(alphaCharArr[i], i);
        }
        int len = alphaCharArr.length;
        String answer = "";
        char[] arr = s.toCharArray();
        for(char e : arr){
            int newIndex = (indexMap.get(e) + index) % len;
            answer += alphaCharArr[newIndex];
        }
    
        return answer;
    }
}