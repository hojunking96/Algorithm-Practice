import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        int[] arr1 = Arrays.copyOfRange(arr,intervals[0][0],intervals[0][1] + 1);
        int[] arr2 = Arrays.copyOfRange(arr,intervals[1][0],intervals[1][1] + 1);
        for(int e : arr1){
            list.add(e);
        }
        for(int e : arr2){
            list.add(e);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}