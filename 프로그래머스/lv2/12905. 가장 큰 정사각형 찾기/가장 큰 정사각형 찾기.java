class Solution {

    public int solution(int[][] board) {

        int row = board.length;
        int column = board[0].length;
        int minLen = Math.min(row, column);
        
        int[][] dp = new int[row][column];
        for(int i = 0; i < row; i++){
            dp[i][0] = board[i][0];
        }
        
        for(int i = 0; i < column; i++){
            dp[0][i] = board[0][i];
        }
        
        for(int i = 1; i < row; i++){
            for(int j = 1; j < column; j++){
                if(board[i][j] == 0){
                    continue;
                }
                
                //왼쪽위, 왼쪽, 위 중에서 가장 작은 값 가져와
                int tmp = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                tmp = Math.min(tmp, dp[i][j - 1]);
                
                if(tmp != 0){
                    dp[i][j] = tmp + 1;
                }
                else{
                    dp[i][j] = board[i][j];
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}