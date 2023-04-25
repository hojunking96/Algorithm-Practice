import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : tangerine) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());

        for(int value : list){
            k -= value;
            answer++;
            if(k <= 0){
                return answer;
            }
        }
        
        return answer;
    }
}