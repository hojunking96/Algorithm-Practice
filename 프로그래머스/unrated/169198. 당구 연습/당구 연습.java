import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for(int i = 0; i < balls.length; i++){
            answer[i] = findMin(m, n, balls[i], startX, startY);
        }
        return answer;
    }
    
    private int findMin(int m, int n, int[] ball, int startX, int startY){
        startX += m;
        startY += n;
        int endX = ball[0] + m;
        int endY = ball[1] + n;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if(endY != startY || endX >= startX){
            pq.add(calc(startX, startY, 2 * m - endX, endY));
        }
        if(endY != startY || endX <= startX){
            pq.add(calc(startX, startY, 4 * m - endX, endY));
        }
        if(endX != startX || endY >= startY){
            pq.add(calc(startX, startY, endX, 2 * n - endY));
        }
        if(endX != startX || endY <= startY){
            pq.add(calc(startX, startY, endX, 4 * n - endY));            
        }
        return pq.poll();
    }
    
    private int calc(int startX, int startY, int endX, int endY){
        return (int)(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
    }
}


/*

가로 : m
세로 : n

공이 있는 곳을 가운데 판 x이라고 하고
y y y
y x y
y y y  처럼 구현해도 될듯?

일직선 거리를 이어서

m을 기준으로 
2m을 기준으로
n을 기준으로
2n을 기준으로

m,n을 기준으로
m,2n을 기준으로

2m,n을 기준으로
2m,2n을 기준으로

*/