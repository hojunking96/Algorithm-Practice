import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        
        int i = 0;
        while(i < arr.length){
            int len = stk.size();
            if(len == 0){
                stk.add(arr[i]);
                i++;
            }
            else if(stk.get(len - 1) == arr[i]){
                stk.remove(len - 1);
                i++;
            }
            else{
                stk.add(arr[i]);
                i++;
            }
        }
        if(stk.isEmpty()){
            return new int[]{-1};
        }
        
        return stk.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}