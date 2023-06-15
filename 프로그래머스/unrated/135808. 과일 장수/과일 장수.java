import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] newArr = Arrays.stream(score)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);
        for(int i = m - 1; i < newArr.length; i += m){
            answer += newArr[i] * m;
        }
        return answer;
    }
}