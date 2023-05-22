import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        List<Integer> arr = new ArrayList<>();
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        
        if(n == 1){
            for(int i = 0 ; i <= b; i++){
                arr.add(num_list[i]);
            }
        }
        else if(n == 2){
            for(int i = a; i < num_list.length; i++){
                arr.add(num_list[i]);
            }
        }
        else if(n == 3){
            for(int i = a; i <= b; i++){
                arr.add(num_list[i]);
            }
        }
        else{
            for(int i = a; i <= b; i += c){
                arr.add(num_list[i]);
            }
        }
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}