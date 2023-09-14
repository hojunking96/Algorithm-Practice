import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int e : nums){
           set.add(e); 
        }
        return Math.min(set.size(), nums.length / 2);
    }
}