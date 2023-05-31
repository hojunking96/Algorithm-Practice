import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        if(enemy.length <= k){
            return enemy.length;
        }
        
        int ptr;
        
        for(ptr = 0; ptr < k; ptr++){
            pq.add(enemy[ptr]);
        }
        
        while(ptr < enemy.length && !pq.isEmpty()){
            if(enemy[ptr] < pq.peek()){
                if(n < enemy[ptr]){
                    return ptr;
                }
                n -= enemy[ptr];
            }
            else{
                if(n < pq.peek()){
                    return ptr;
                }
                n -= pq.poll();
                pq.add(enemy[ptr]);
            }
            ptr++;
        }
        
        
        
        return ptr;
    }
}

/*
k >= enemy.length   -> return enemy.length

일단 리스트에 k개 만큼 넣어봐
그리고 리스트에서 가장 작은것과 새로 들어올 것의 크기를 비교
리스트에 있는게 더 작으면
n -= 리스트에 있는거



*/