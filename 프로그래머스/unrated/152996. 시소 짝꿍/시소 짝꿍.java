import java.util.*;

class Solution {
    
    private static Map<Integer, Long> map = new HashMap<>();
    private static long cnt = 0;
    
    public long solution(int[] weights) {
        for(int weight : weights){
            map.put(weight, map.getOrDefault(weight, 0L) + 1);
        }
        for(int key : map.keySet()){
            //1:1
            cnt += map.get(key) * (map.get(key) - 1);
            //1:2
            check(key, key * 2);
            if(key % 2 == 0 ){
                //2:1
                check(key, key / 2);
                //2:3       
                check(key, key / 2 * 3);
            }
            if(key % 3 == 0){
                //3:2
                check(key, key / 3 * 2);
                //3:4
                check(key, key / 3 * 4);
            }
            if(key % 4 == 0){
                //4:3
                check(key, key / 4 * 3);
            }
        }
        return cnt / 2;
    }
    
    private static void check(int key1, int key2){
        if(map.containsKey(key2)){
            cnt += map.get(key1) * map.get(key2);
        }
    }
}

/*

          
총 몇가지냐?
1:1, 1:2, 2:1
2:3, 4:3
3:2, 3:4

7가지네
그럼 일단, Map으로 다 받은다음
하나 정해서 개수 * 경우의 수(개수 * 합)들

Map은 getKeys인가 getKeySet인가로 가져오면 되겠네


*/