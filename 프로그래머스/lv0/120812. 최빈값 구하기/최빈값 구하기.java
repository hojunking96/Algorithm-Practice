import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int answer = 0;
        for(int e : array){
            int value = map.getOrDefault(e, 0) + 1;
            map.put(e, value);
            if(max < value){
                max = value;
                answer = e;
            }
        }
        int cnt = 0;
        for(int e : map.values()){
            if(max == e){
                cnt++;
            }
            if(cnt == 2){
                return -1;
            }
        }
        return answer;
    }
}