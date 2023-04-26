import java.util.*;

class Solution {
    private static class Point{
        int x;
        int y;
        int d;

        public Point(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    private static boolean[][] visited;
    private static char[][] board;
    private static int row, column;
    private static int[] dX = {-1, 0, 1, 0};
    private static int[] dY = {0, -1, 0, 1};

    public int solution(String[] maps) {
        row = maps.length;
        column = maps[0].length();
        board = new char[row][column];
        visited = new boolean[row][column];

        for(int i = 0; i < row; i++){
            board[i] = maps[i].toCharArray();
        }
        Point start = null;
        Point lever = null;
        Point end = null;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(board[i][j] == 'S'){
                    start = new Point(i, j, 0);
                }
                if(board[i][j] == 'L'){
                    lever = new Point(i, j, 0);
                }
                if(board[i][j] == 'E'){
                    end = new Point(i, j, 0);
                }
            }
        }
        int way1 = BFS(start, lever);
        if(way1 == -1 ){
            return -1;
        }
        visited = new boolean[row][column];
        int way2 = BFS(lever, end);
        if(way2 == -1){
            return -1;
        }
        return way1 + way2;

    }

    private static int BFS(Point start, Point end){
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;

        while(!q.isEmpty()){
            Point now = q.poll();
            if(now.x == end.x && now.y == end.y){
                return now.d;
            }

            for(int i = 0; i < 4; i++){
                int nextX = now.x + dX[i];
                int nextY = now.y + dY[i];
                int nextD = now.d + 1;
                if(nextX < 0 || nextX >= row || nextY < 0 || nextY >= column){
                    continue;
                }
                if(visited[nextX][nextY] || board[nextX][nextY] == 'X'){
                    continue;
                }
                visited[nextX][nextY] = true;
                q.add(new Point(nextX, nextY, nextD));
            }
        }
        return -1;
    }
}