import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer;
        answer = Arrays.stream(strings)
            .sorted()
            .sorted(Comparator.comparingInt(o -> o.charAt(n)))
            .toArray(String[]::new);
        return answer;
    }
}