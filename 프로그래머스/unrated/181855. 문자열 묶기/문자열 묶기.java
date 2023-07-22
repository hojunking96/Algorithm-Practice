import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int max = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for(String str : strArr){
            cntMap.put(str.length(), cntMap.getOrDefault(str.length(), 0) + 1);
        }
        for(int cnt : cntMap.values()){
            if(cnt > max){
                max = cnt;
            }
        }
        return max;
    }
}