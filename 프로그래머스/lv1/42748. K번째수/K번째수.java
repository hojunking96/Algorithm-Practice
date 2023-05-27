import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int ptr = 0;
        for(int[] command : commands){
            List<Integer> arr = new ArrayList<>();
            for(int i = command[0] - 1; i <= command[1] - 1; i++){
                arr.add(array[i]);
            }
            Collections.sort(arr);
            answer[ptr] = arr.get(command[2] - 1);
            ptr++;
        }
        return answer;
    }
}