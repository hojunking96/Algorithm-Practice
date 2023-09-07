import java.util.*;

class Solution {
    public int[] solution(int num, int total) {
        List<Integer> arr = new ArrayList<>();
        if(num % 2 == 0){
            int mid = total / num;
            int start = mid - num / 2 + 1;
            for(int i = 0; i < num; i++){
                arr.add(i + start);
            }
        }
        else{
            int mid = total / num;
            int start = mid - num / 2;
            for(int i = 0; i < num; i++){
                arr.add(i + start);
            }
        }
        return arr.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}