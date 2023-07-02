import java.util.*;

class Solution {
    
    private Map<String, Integer> map = new HashMap<>();
    private int min = Integer.MAX_VALUE;
    private int start = 1;
    private int end = 1;
    private int left = 0;
    private int right = -1;
    private int typeCnt;
    
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for(String e : gems){
            set.add(e);
        }
        typeCnt = set.size();
        int totalLen = gems.length;

        
        while(right < totalLen - 1){
            moveRight(gems);
            moveLeft(gems);
            if(map.size() == typeCnt){
                if(min > right - left + 1){
                    min = right - left + 1;
                    start = left;
                    end = right;
                }
            }  
        }
        return new int[]{start + 1, end + 1};
    }
    private void moveRight(String[] gems){
        right++;
        map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
    }
    
    private void moveLeft(String[] gems){
        while(map.get(gems[left]) > 1){
            map.put(gems[left], map.get(gems[left]) - 1);
            left++;
        }
    }
}
