import java.util.*;

class Solution {
    public String solution(String my_string, int[][] queries) {
        for(int i = 0; i < queries.length; i++){
            int s = queries[i][0];
            int e = queries[i][1];
            StringBuilder sb = new StringBuilder(my_string.substring(s, e + 1));
            String newSubstring = sb.reverse().toString();
            my_string = my_string.substring(0, s) + newSubstring + my_string.substring(e + 1);
        }
        return my_string;
    }
}