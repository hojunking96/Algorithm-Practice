import java.util.*;

class Solution {
    
    static class Process{
        int priority;
        int location;
        
        public Process(int priority, int location){
            this.priority = priority;
            this.location = location;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Process> q = new LinkedList<>();
        PriorityQueue<Process> pq = new PriorityQueue<>(Comparator.comparingInt((Process o) -> o.priority).reversed());
        int len = priorities.length;
        for (int i = 0; i < len; i++) {
            q.add(new Process(priorities[i], i));
            pq.add(new Process(priorities[i], i));
        }
        int answer = 1;
        int max = pq.poll().priority;

        while (!q.isEmpty()) {
            Process now = q.poll();
            if (now.location == location && now.priority == max) {
                return answer;
            } else if (now.priority == max) {
                max = pq.poll().priority;
                answer++;
            } else {
                q.add(now);
            }
        }
        return answer;
    }
}