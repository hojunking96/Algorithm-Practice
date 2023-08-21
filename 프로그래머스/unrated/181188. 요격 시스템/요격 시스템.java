import java.util.*;

class Solution {
    
    class Missile implements Comparable<Missile> {
        int start;
        int end;
        Missile(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        public int compareTo(Missile o){
            return this.end - o.end;
        }
    }
    
    private PriorityQueue<Missile> pq;
    
    public int solution(int[][] targets) {
        pq = new PriorityQueue<>();
        
        for(int[] target : targets){
            pq.add(new Missile(target[0], target[1]));
        }
        int answer = 0;
        while(!pq.isEmpty()){
            Missile m = pq.poll();
            while(!pq.isEmpty() && pq.peek().start < m.end){
                pq.poll();
            }
            answer++;
        }
        return answer;
    }
}

/*
미사일 요격하는데 가장 많은 
시작시간 기준으로 정렬하고
동일할 때 끝 시간 기준으로 정렬해

우선순위큐에 아무것도 없을때까지 반복

하나(a)를 우선순위 큐에서 뽑아
a가 끝나기 전까지 시작한 미사일이 있으면 다 뽑아
a가 끝나기 전에 요격 한번 해야함
-> 미사일 발사 1회

*/