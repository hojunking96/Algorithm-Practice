import java.util.*;

class Solution {
    public int[] solution(String s) {
         int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                answer[i] = i - map.get(s.charAt(i));
                map.put(s.charAt(i), i);
            }
            else{
                map.put(s.charAt(i), i);
                answer[i] = -1;
            }
        }
        return answer;
    }
}

/*
import java.util.stream.IntStream;

class Solution {
    public int[] solution(String s) {
        return IntStream.range(0, s.length())
            .map(i -> s.substring(0, i).lastIndexOf(s.charAt(i)) > -1 ? i - s.substring(0, i).lastIndexOf(s.charAt(i)) : -1)
            .toArray();
    }
}
*/