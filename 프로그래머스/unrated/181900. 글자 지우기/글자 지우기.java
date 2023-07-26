import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        Arrays.sort(indices);
        for(int i = indices.length - 1; i >=0; i--){
            my_string = my_string.substring(0, indices[i]) + my_string.substring(indices[i] + 1);
        }
        return my_string;
    }
}