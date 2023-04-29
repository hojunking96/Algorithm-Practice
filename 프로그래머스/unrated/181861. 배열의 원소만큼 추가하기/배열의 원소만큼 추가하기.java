import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for(int e : arr){
            for(int i = 0; i < e; i++){
                list.add(e);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}