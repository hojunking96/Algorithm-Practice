import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int[] cnt = new int[cacheSize];
        Map<String, Integer> cache = new HashMap<>();
        
        int answer = 0;
        
        for(int i = 0 ; i < cities.length; i++){
            String city = cities[i].toLowerCase();
            if(cache.containsKey(city)){
                cache.put(city, i + 1);
                answer++;
            }
            else{
                if(cacheSize == 0 ){
                    answer += 5;
                }
                else if( cache.size() != cacheSize){            
                    cache.put(city, i + 1);
                    answer += 5;
                }
                else{
                    int min = Integer.MAX_VALUE;
                    String LRUKey = "";
                    for(String key : cache.keySet()){
                        if(cache.get(key) < min){
                            min = cache.get(key);
                            LRUKey = key;
                        }
                    }
                    cache.remove(LRUKey);
                    cache.put(city, i + 1);
                    answer += 5;
                }
            }
        }
        return answer;
    }
}