import java.util.*;

class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuffer sb = new StringBuffer(my_string.substring(s, e + 1));
        String reverse = sb.reverse().toString();
        return my_string.substring(0, s) + reverse + my_string.substring(e + 1);
    }
}