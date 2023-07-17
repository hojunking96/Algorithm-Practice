import java.util.*;

class Solution {
    class Node{
        int x;
        int y;
        int dir;
        int cost;
        Node(int x, int y, int dir, int cost){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    private int len;
    private int[] dX = {-1, 0, 1, 0};
    private int[] dY = {0, -1, 0, 1};
    private int min = Integer.MAX_VALUE;
    private boolean[][][] visited;
    
    public int solution(int[][] board) {
        len = board.length;
        visited = new boolean[len][len][4];
        BFS(board, new Node(0, 0, -1, 0));
        return min;
    }
    private void BFS(int[][]board, Node start){
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < 4; i++){
            visited[start.x][start.y][i] = true;
        }
        q.add(start);
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.x == len - 1 && now.y == len - 1){
              min = Math.min(min, now.cost);  
            } 
            
            for(int i = 0; i < 4; i++) {
                int nextX = now.x + dX[i];
                int nextY = now.y + dY[i];
                int nextCost = now.cost;
                
                if(nextX < 0 || nextY < 0 || nextX >= len || nextY >= len){
                    continue;
                }
                if(board[nextX][nextY] == 1) {
                    continue;
                }
                
                if(now.dir == i || now.dir == -1){
                  nextCost += 100;  
                } 
                else{
                   nextCost += 600; 
                }  
                
                if(!visited[nextX][nextY][i] || board[nextX][nextY] >= nextCost) {
                    q.add(new Node(nextX, nextY, i, nextCost));
                    visited[nextX][nextY][i] = true;
                    board[nextX][nextY] = nextCost; 
                }
            }
        }       
    }
}