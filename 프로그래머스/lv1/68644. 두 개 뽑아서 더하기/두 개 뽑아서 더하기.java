import java.util.*;

class Solution {
    
    private Set<Integer> set = new HashSet<>();
    
    public int[] solution(int[] numbers) {
        search(0, numbers, 0, 0);
        set.stream()
            .mapToInt(Integer::intValue)
            .sorted()
            .toArray();
        return set.stream()
            .mapToInt(Integer::intValue)
            .sorted()
            .toArray();
    }
    
    private void search(int depth, int[] numbers, int sum, int start){
        if(depth == 2){
            set.add(sum);
            return;
        }
        for(int i = start; i < numbers.length; i++){
            search(depth + 1, numbers, sum + numbers[i], i + 1);
        }
    }
}