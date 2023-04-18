import java.util.*;

class Solution {
    public int solution(int n) {
        int bitCnt = Integer.bitCount(n);
        while(true){
            n++;
            int cnt2 = Integer.bitCount(n);
            if(cnt2==bitCnt){
                break;
            }
        }
        return n;
    }
}