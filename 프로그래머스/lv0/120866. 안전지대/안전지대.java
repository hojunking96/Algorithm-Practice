class Solution {
    
    private int n, m;
    
    public int solution(int[][] board) {
        n = board.length;
        m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 1){
                    mark(board, i, j);
                }
            }
        }
        int answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 0){
                    answer++;
                }
            }
        }
        return answer;
    }
    
    private void mark(int[][] board, int x, int y){
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                int newX = x + i;
                int newY = y + j;
                if(newX >= 0 && newX < n && newY >= 0 && newY < m){
                    if(board[newX][newY] == 0){
                        board[newX][newY] = -1;
                    }
                }
            }
        }
    }
}