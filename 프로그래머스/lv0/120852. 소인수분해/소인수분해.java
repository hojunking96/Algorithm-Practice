import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> arr = new ArrayList<>();
        int i = 2;
        while(n > 1){
            if(n % i == 0){
                while(n % i == 0){
                    n /= i;
                }                
                arr.add(i);
            }
            else{
                i++;
            }
        }
        return arr.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}