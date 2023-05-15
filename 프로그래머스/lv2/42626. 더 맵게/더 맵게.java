import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int e : scoville){
            pq.add(e);
        }
        while(pq.size() >= 2){
            int s1 = pq.poll();
            if(s1 >= K){
                break;
            }
            int s2 = pq.poll();
            int newS = s1 + s2 * 2;
            pq.add(newS);
            answer++;
        }
        if(pq.peek() < K){
            return -1;
        }
        return answer;
    }
}