import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> arr = new ArrayList<>();
        for(int i = l; i <= r; i++){
            String x = "" + i;
            boolean y = true;
            for(char e : x.toCharArray()){
                if(e != '5' && e != '0'){
                    y = false;
                    break;
                }
            }
            if(y){
                arr.add(i);
            }
        }
        if(arr.size() == 0){
            arr.add(-1);
        }
        return arr.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}