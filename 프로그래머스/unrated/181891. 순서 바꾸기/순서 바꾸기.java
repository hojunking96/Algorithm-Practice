import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> arr = new ArrayList<>();
        int[] arr1 = Arrays.copyOfRange(num_list, n, num_list.length);
        int[] arr2 = Arrays.copyOfRange(num_list, 0, n);
        for(int e : arr1){
            arr.add(e);
        }
        for(int e : arr2){
            arr.add(e);
        }
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}