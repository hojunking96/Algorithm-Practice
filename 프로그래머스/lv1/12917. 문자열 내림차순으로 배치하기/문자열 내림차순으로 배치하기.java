import java.util.*;

class Solution {
    public String solution(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        StringBuilder tmp = new StringBuilder(new String(charArray));
        String answer = tmp.reverse().toString();
        return answer;
    }
}