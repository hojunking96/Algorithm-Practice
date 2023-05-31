import java.util.*;

class Solution {
    
    class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    private int row;
    private int column;
    private int[][] visited;
    private Node start;
    private Node end;
    
    public int solution(String[] board) {
        
        row = board.length;
        column = board[0].length();
        visited = new int[row][column];
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                char tmp = board[i].charAt(j);
                switch(tmp){
                    case 'D':
                        visited[i][j] = -1;
                        break;
                    case 'R':
                        start = new Node(i, j);
                        break;
                    case 'G':
                        end = new Node(i,j);
                        break;
                    default:
                        break;
                }
            }
        }
        int answer = BFS();
        return answer;
    }
    
    private int BFS(){
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = 1;
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.x == end.x && now.y == end.y){
                return visited[now.x][now.y] - 1;
            }
            
            //아래로 쭉
            Node next = new Node(now.x, now.y);
            for(int i = now.x + 1; i < row; i++){
                if(visited[i][now.y] != -1){
                    next.x = i;
                }
                else{
                    break;
                }
            }
            if(visited[next.x][next.y] == 0){
                q.add(next);
                visited[next.x][next.y] = visited[now.x][now.y] + 1;
            }
            
            //위로 쭉
            next = new Node(now.x, now.y);
            for(int i = now.x - 1; i >= 0; i--){
                if(visited[i][now.y] != -1){
                    next.x = i;
                }
                else{
                    break;
                }
            }
            if(visited[next.x][next.y] == 0){
                q.add(next);
                visited[next.x][next.y] = visited[now.x][now.y] + 1;
            }
            
            //왼쪽으로 쭉
            next = new Node(now.x, now.y);
            for(int i = now.y - 1; i >= 0; i--){
                if(visited[now.x][i] != -1){
                    next.y = i;
                }
                else{
                    break;
                }
            }
            if(visited[next.x][next.y] == 0){
                q.add(next);
                visited[next.x][next.y] = visited[now.x][now.y] + 1;
            }
            
            //아래로 쭉
            next = new Node(now.x, now.y);
            for(int i = now.y + 1; i < column; i++){
                if(visited[now.x][i] != -1){
                    next.y = i;
                }
                else{
                    break;
                }
            }
            if(visited[next.x][next.y] == 0){
                q.add(next);
                visited[next.x][next.y] = visited[now.x][now.y] + 1;
            }
        }
        return -1;
    }
}

/*
시작 위치 -> 목표 위치 최소 몇번
상 하 좌 우
장애물이나 맨 끝 까지 이동
R : 처음 위치
D : 장애물
G : 목표 위치

*/