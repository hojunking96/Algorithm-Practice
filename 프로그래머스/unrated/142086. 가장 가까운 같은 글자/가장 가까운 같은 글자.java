import java.util.stream.IntStream;

class Solution {
    public int[] solution(String s) {
        return IntStream.range(0, s.length())
            .map(i -> s.substring(0, i).lastIndexOf(s.charAt(i)) > -1 ? i - s.substring(0, i).lastIndexOf(s.charAt(i)) : -1)
            .toArray();
    }
}