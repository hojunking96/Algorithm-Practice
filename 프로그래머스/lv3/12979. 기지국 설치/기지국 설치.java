import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        List<Integer> arr = new ArrayList<>();
        int start = 1;
        int end = 0;
        for(int station : stations){
            end = station - w - 1;
            if(end >= start){
                arr.add(end - start + 1);      
            }
            start = station + w + 1;
        }
        if(n >= start){
            arr.add(n - start + 1);        
        }
        int len = 2 * w + 1;
        for(int k : arr){
            answer += k / len;
            if(k % len != 0){
                answer++;
            }
        }
        return answer;
    }
}