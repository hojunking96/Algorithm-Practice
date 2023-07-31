import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(i < arr.length){
            int length = list.size();
            if(list.isEmpty()){
                list.add(arr[i++]);
            }
            else if(list.get(length - 1) < arr[i]){
                list.add(arr[i++]);
            }
            else{
                list.remove(length - 1);
            }
        }
        return list.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}