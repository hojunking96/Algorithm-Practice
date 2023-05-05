class Solution {
    public int solution(int[][] board, int k) {
        int answer = 0;
        for(int i = 0; i < board.length; i++){
            int len = Math.min(k - i, board[i].length - 1);
            for(int j = 0; j <= len; j++){
                answer += board[i][j];
            }
        }
        return answer;
    }
}