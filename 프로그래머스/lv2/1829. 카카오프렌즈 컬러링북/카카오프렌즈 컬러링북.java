import java.util.*;

class Solution {
    
    class Node{
        int x;
        int y;
        
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    private boolean[][] visited;
    private int maxSizeOfOneArea = 0;
    private int numberOfArea = 0;
    private int[] dX = {-1, 0, 0, 1};
    private int[] dY = {0, -1, 1, 0};
    
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    BFS(new Node(i, j), picture, m, n, picture[i][j]);
                    numberOfArea++;
                }
            }
        }
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
    
    private void BFS(Node node, int[][] picture, int m, int n, int k){
        int cnt = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited[node.x][node.y] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            cnt++;
            for(int i = 0; i < 4; i++){
                int nextX = now.x + dX[i];
                int nextY = now.y + dY[i];
                
                if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n){
                    continue;
                }
                if(visited[nextX][nextY]){
                    continue;
                }
                if(picture[nextX][nextY] == k){
                    q.add(new Node(nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
    }
}