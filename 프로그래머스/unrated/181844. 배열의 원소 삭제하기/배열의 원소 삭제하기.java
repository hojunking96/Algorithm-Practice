import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        List<Integer> deleteArr = Arrays.stream(delete_list)
            .boxed()
            .collect(Collectors.toList());    
        for(int e : arr){
            if(!deleteArr.contains(e)){
                list.add(e);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}