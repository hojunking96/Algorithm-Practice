import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        for(int e : arr){
            if(list.size() == k){
                return list.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
            }
            if(!list.contains(e)){
                list.add(e);
            }
        }
        int[] answer = new int[k];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        for(int j = list.size(); j < k; j++){
            answer[j] = -1;
        }
        return answer;
    }
}