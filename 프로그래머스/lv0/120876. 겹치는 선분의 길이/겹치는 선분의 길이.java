import java.util.*;

class Solution {
    
    private Set<Integer> set = new HashSet<>();
    
    public int solution(int[][] lines) {
        check(lines[0], lines[1]);
        check(lines[0], lines[2]);
        check(lines[1], lines[2]);
        return set.size();
    }
    
    private void check(int[] l1, int[] l2){
        for(int i = l1[0]; i < l1[1]; i++){
            for(int j = l2[0]; j < l2[1]; j++){
                if(i == j){
                    set.add(i);
                }
            }
        }
    }
}