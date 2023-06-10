import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < name.length; i++){
            map.put(name[i], yearning[i]);
        }
        for(int i = 0 ; i < photo.length; i++){
            String[]e = photo[i];
            for(String k : e){
                if(map.containsKey(k)){
                    answer[i] += map.get(k);                    
                }
            }
        }
        return answer;
    }
}