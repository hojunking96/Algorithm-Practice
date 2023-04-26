import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(int i = 0; i < my_string.length(); i++){
            char e = my_string.charAt(i);
            if(e >= 'a' && e <= 'z'){
                e += 'A' - 'a';
                answer += e;
            }
            else{
                e -= 'A' - 'a';
                answer += e;
            }
        }
        return answer;
    }
}