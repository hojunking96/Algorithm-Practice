import java.util.*;

class Solution {
    static class Node{
        int x;
        int y;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static int[][] visited;
    public static int[] dX={-1,1,0,0};
    public static int[] dY={0,0,-1,1};
    public static int n,m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        BFS(0,0,maps);
        int answer=visited[n-1][m-1];
        if(answer==0){
            answer=-1;
        }
        return answer;
    }
    public static void BFS(int startX,int startY,int[][]maps){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startX,startY));
        visited[startX][startY] = 1;
        while(!q.isEmpty()){
            Node now = q.poll();
            int nextX;
            int nextY;
            if(now.x==n&&now.y==m){
                return;
            }
            for(int i=0;i<4;i++){
                nextX=now.x+dX[i];
                nextY=now.y+dY[i];
                if(nextX>=0&&nextX<n&&nextY>=0&&nextY<m){
                    if(visited[nextX][nextY]==0&&maps[nextX][nextY]==1){
                        visited[nextX][nextY]=visited[now.x][now.y]+1;
                        q.add(new Node(nextX,nextY));
                    }
                }
            }
        }
    }
}