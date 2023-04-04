import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        Arrays.sort(array);
        int min = Integer.MAX_VALUE;
        for(int e : array){
            if(Math.abs(e-n)<min){
                answer=e;
                min=Math.abs(e-n);
            }
        }
        return answer;
    }
}