import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i;
        int len = Math.min(score.length, k);
        for(i = 0; i < len; i++){
            pq.add(score[i]);
            answer[i] = pq.peek();
        }
        while(i < score.length){
            if(pq.peek() < score[i]){
                pq.poll();
                pq.add(score[i]);
            }
            answer[i] = pq.peek();
            i++;
        }
        return answer;
    }
}