import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < 3; i++){
            for(int j = 0; j < picks[i]; j++){
                pq.add(i);
            }            
        }
        
        int[] fiveMinerals = new int[(minerals.length + 4) / 5];
        for(int i = 0; i < minerals.length; i++){
            if(i >= pq.size() * 5){
                break;
            }
            if(minerals[i].equals("diamond")){
                fiveMinerals[i / 5] += 25;
            }
            else if(minerals[i].equals("iron")){
                fiveMinerals[i / 5] += 5;
                if (fiveMinerals[i / 5] == 25) {
                    fiveMinerals[i / 5] = -25;
                }
            }
            else{
                fiveMinerals[i / 5] ++;
                if (fiveMinerals[i / 5] == 5) {
                    fiveMinerals[i / 5] = -5;
                }
            }
        }
        Integer[] arr = Arrays.stream(fiveMinerals)
            .boxed()
            .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
            .toArray(Integer[]::new);
    
        int len = arr.length;
        int ptr = 0;
        int answer = 0;
        
        while(!pq.isEmpty()){
            if(ptr >= len){
                break;
            }
            int pick = pq.poll();
            
            if (arr[ptr] == -25) {
                if (pick == 0) {
                    answer += 5;
                    ptr++;
                    continue;
                }
                arr[ptr] = 25;
            }

            if (arr[ptr] == -5) {
                if (pick == 1) {
                    answer += 5;
                    ptr++;
                    continue;
                }
                arr[ptr] = 5;
            }
            
            if(pick == 0){
                answer += arr[ptr] / 25 + arr[ptr] % 25 / 5 + arr[ptr] % 5;
            }    
            else if(pick == 1){
                answer += arr[ptr] / 5 + arr[ptr] % 5;
            }
            else{
                answer += arr[ptr];
            }
            ptr++;
        }
        
        return answer;
    }
}
