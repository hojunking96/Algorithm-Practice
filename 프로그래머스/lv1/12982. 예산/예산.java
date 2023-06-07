import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int e : d){
            if(budget >= e){
                budget -= e;
                answer++;
            }
            else{
                break;
            }
        }
        return answer;
    }
}