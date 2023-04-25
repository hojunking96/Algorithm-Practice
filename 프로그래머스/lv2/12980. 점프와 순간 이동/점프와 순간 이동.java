import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        while(n != 0){
            if(n % 2 == 0){
                n /= 2;
            }
            else{
                n -= 1;
                ans++;
            }
        }
        return ans;
    }
}
/*

6 = 3 * 2 = (2 + 1) * 2
5 = 2 * 2 + 1
5000 = 2500 * 2 = 1250 * 2 * 2 = 625 * 2 * 2 * 2 = (624 + 1) * 2 * 2 * 2
        = (29 * 2 * 2 + 1) = ((7 + 1) * 2 + 1) * 2

*/