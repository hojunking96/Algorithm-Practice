import java.util.*;

class Solution {
    public static HashSet<Integer> hashSetL;
    public static HashSet<Integer> hashSetR;
    public static int[] leftValue;
    public static int[] rightValue;
    
    public int solution(int[] topping) {
        int cnt=0;
        
        hashSetL = new HashSet<>();
        hashSetR = new HashSet<>();
        leftValue = new int[topping.length];
        rightValue = new int[topping.length];        
        
        for(int i=0;i<topping.length;i++){
            hashSetL.add(topping[i]);
            hashSetR.add(topping[topping.length-i-1]);
            leftValue[i]=hashSetL.size();
            rightValue[topping.length-i-1]=hashSetR.size();
        }
        for (int i = 0; i < topping.length - 1; i++) {
            if (leftValue[i] == rightValue[i + 1]) {
                cnt++;
            }
        }
        return cnt;
    }
}