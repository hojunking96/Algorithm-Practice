import java.util.*;

class Solution {
    
    private Stack<Integer> stack = new Stack<>();
    private int cnt = 0;
    
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        for(int move : moves){
            for(int i = 0; i < n; i++){
                if(board[i][move - 1] != 0){
                    addStack(board[i][move - 1]);
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }
        return cnt;
    }
    
    private void addStack(int e){
        if(!stack.isEmpty()){
            int top = stack.peek();
            if(top == e){
                stack.pop();
                cnt += 2;
                return;
            }
        }
        stack.push(e);
    }
}


/*
00000
00000             4(3(11)3)
02500
02442
05131
*/