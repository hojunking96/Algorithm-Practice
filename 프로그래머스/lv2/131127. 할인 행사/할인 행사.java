import java.util.*;

class Solution {
    
    private static Map<String, Integer> map;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        map = new HashMap<>();
        int len = discount.length;
        
        for(int i = 0; i < len; i++){
            map.put(discount[i], 0);
        }
        
        for(int i = 0; i < 10; i++){
            plus(discount[i]);
        }
        if(check(want, number)){
            answer++;
        }
        
        int left = 0;
        for(int i = 10; i < len; i++){
            plus(discount[i]);
            minus(discount[left++]);
            if(check(want, number)){
                answer++;
            }
        }
        
        
        return answer;
    }
    
    private static void plus(String key){
        int value = map.get(key);
        map.put(key, value + 1);
    }
    
    private static void minus(String key){
        int value = map.get(key);
        map.put(key, value - 1);
    }
    
    private static boolean check(String[] want, int[] number){
        for(int j = 0 ; j < want.length; j++){
            if(map.containsKey(want[j]) && map.get(want[j]) == number[j]){
                continue;
            }
            return false;
        }
        return true;
    }
}