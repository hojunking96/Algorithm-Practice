class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        
        int[] dX = new int[]{0, 1, 0, -1};
        int[] dY = new int[]{1, 0, -1, 0};
        
        int prevX = 0;
        int prevY = -1;
        int mod = 0;
     
        
        for(int i = 1; i <= n * n; i++){
           
            int nextX = prevX + dX[mod];
            int nextY = prevY + dY[mod];
            
            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || visited[nextX][nextY]){
                mod++;
                if(mod == 4){
                    mod = 0;
                }
                i--;
                continue;
            }
            visited[nextX][nextY] = true;
            answer[nextX][nextY] = i;
            prevX = nextX;
            prevY = nextY;
        }
        
        return answer;
    }
}