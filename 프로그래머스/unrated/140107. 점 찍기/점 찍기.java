import java.util.*;

class Solution {
    
    public long solution(int k, int d) {
        long answer = 0;
        long max = (long)d;
        for(long i=0;i<=d;i+=k){
            double y = Math.sqrt(max*max-i*i);
            answer+=Math.floor(y/k)+1;
        }
        return answer;
    }
}