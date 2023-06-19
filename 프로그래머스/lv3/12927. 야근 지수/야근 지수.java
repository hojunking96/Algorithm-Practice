import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works){
            pq.add(work);
        }
        while(!pq.isEmpty() && n != 0){
            int work = pq.poll();
            if(work > 1){
                pq.add(work - 1);
            }
            n--;
        }
        if(pq.isEmpty()){
            return 0;
        }
        for(int k : pq){
            answer += k * k;
        }
        return answer;
    }
}

/*





*/