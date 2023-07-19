import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String myStr) {
        String[] answer = Arrays.stream(myStr.split("[a|b|c]"))
            .filter(e -> !e.equals(""))
            .collect(Collectors.toList()).toArray(new String[0]);
        if(answer.length == 0){
            return new String[]{"EMPTY"};
        }
        return answer;
    }
}