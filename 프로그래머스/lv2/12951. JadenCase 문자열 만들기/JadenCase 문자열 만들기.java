import java.util.*;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        String answer = "";
        if(s.charAt(0) >= 'a' && s.charAt(0) <= 'z'){
                    answer += Character.toUpperCase(s.charAt(0)); 
            }
            else{
                answer += s.charAt(0);
            }
        
        for(int i = 1; i < s.length(); i++){
            char k = s.charAt(i);
            if(s.charAt(i - 1) == ' ' && k >= 'a' && k <= 'z'){
                   answer += Character.toUpperCase(k); 
            }
            else{
                answer += k;
            }
        }
        return answer;
    }
}