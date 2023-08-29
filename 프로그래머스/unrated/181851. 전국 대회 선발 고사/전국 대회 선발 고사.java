import java.util.*;

class Solution {
    
    class Rank{
        int number;
        int score;
        
        Rank(int number, int score){
            this.number = number;
            this.score = score;
        }
    }
    
    private PriorityQueue<Rank> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.score));
    
    public int solution(int[] rank, boolean[] attendance) {
        
        for(int i = 0; i < rank.length; i++){
            if(attendance[i]){
                pq.add(new Rank(i, rank[i]));
            }
        }
        int a = pq.poll().number;
        int b = pq.poll().number;
        int c = pq.poll().number;
        return 10000 * a + 100 * b + c;
    }
}