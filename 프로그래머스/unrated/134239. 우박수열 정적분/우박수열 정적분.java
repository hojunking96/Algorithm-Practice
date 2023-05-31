import java.util.*;
class Solution {
    
    private List<Integer> list = new ArrayList<>();
    
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        addArr(k);
        
        int ptr = 0;
        for(int[] range : ranges){
            int a = range[0];
            int b = list.size() + range[1] - 1;
            if(a > b){
                answer[ptr++] = -1;
                continue;
            }
            
            for(int i = a; i < b; i++){
                answer[ptr] += (double)(list.get(i) + list.get(i + 1)) / 2;
            }
            ptr++;
        }
        
        
        return answer;
    }
    
    private void addArr(int k){
        list.add(k);
        if(k <= 1){
            return;
        }
        if(k % 2 == 0){
            k /= 2;
            addArr(k);
        }
        else{
            k = k * 3 + 1;
            addArr(k);
        }
    }
}