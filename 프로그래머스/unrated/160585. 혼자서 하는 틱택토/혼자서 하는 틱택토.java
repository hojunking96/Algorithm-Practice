import java.util.*;

class Solution {
    public int solution(String[] board) {
        int Ocnt = 0;
        int Xcnt = 0;
        //O와 X의 개수를 센다.
        for(int i=0;i<3;i++){
            Ocnt+=countChar(board[i],'O');
            Xcnt+=countChar(board[i],'X');
        }
        
        //'X'가 'O'보다 많으면 규칙 위반
        if(Xcnt>Ocnt){
            return 0;
        }
        
        //'O'가 'X'보다 2개이상 많으면 규칙 위반
        if(Ocnt>Xcnt+1){
            return 0;
        }
        
        //O가 완성 되었을 때 X가 O의 개수와 같으면 규칙 위반
        if(hasWin(board,'O')){
            if(Ocnt==Xcnt){
                return 0;
            }
        }
        //X가 완성 되었을 때 O가 X보다 1개 많으면 규칙 위반
        if(hasWin(board,'X')){
            if(Ocnt==Xcnt+1){
                return 0;
            }
        }
        
        
        return 1;
    }
    private static int countChar(String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }
    private static boolean hasWin(String[] board, char ch){
        //가로 검사
        for(int i=0;i<3;i++){
            if(board[i].charAt(0)==ch
               &&board[i].charAt(1)==ch
               &&board[i].charAt(2)==ch){
               return true;        
            }
        }
        //세로 검사
        for(int i=0;i<3;i++){
            if(board[0].charAt(i)==ch
               &&board[1].charAt(i)==ch
               &&board[2].charAt(i)==ch){
               return true;        
            }
        }
        //대각선 검사
        if(board[0].charAt(0)==ch
           &&board[1].charAt(1)==ch
           &&board[2].charAt(2)==ch){
            return true;
        }
        if(board[0].charAt(2)==ch
           &&board[1].charAt(1)==ch
           &&board[2].charAt(0)==ch){
            return true;
        }
        return false;
    }
}

//3*3 칸에서
// 선공 : O, 후공 : X 를 번갈아가면서 표시
//가로 세로 대각선 3개 같으면 이기는 게임
//9칸이 모두 차면 무승부
//규칙을 지켜서 나온 결과인지 아닌지
