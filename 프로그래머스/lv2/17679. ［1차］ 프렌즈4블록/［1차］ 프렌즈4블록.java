import java.util.*;

class Solution {
    private static char[][] kakao;
    private static boolean[][] isBroken;
    private static final char EMPTY = 'e';
    public int solution(int m, int n, String[] board) {
        kakao = new char[m][n];
        for(int i = 0; i < m; i++){
            kakao[i] = board[i].toCharArray();
        }
        while(true){
            isBroken = new boolean[m][n];
            if(!doBreak(m, n)){
                break;
            }
            changeBlock(m, n);
            fallDown(m, n);
        }
        return count(m, n);
    }
    private static int count(int m, int n){
        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(kakao[i][j] == EMPTY){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private static boolean doBreak(int m, int n){
        boolean hasBroken = false;
        for(int i = 0; i < m - 1; i++){
            for(int j = 0; j < n - 1; j++){
                if(canDoBreak(i, j)){
                    isBroken[i][j] = true;
                    isBroken[i][j + 1] = true;
                    isBroken[i + 1][j] = true;
                    isBroken[i + 1][j + 1] = true;
                    // kakao[i][j] = EMPTY;
                    // kakao[i][j + 1] = EMPTY;
                    // kakao[i + 1][j] = EMPTY;
                    // kakao[i + 1][j + 1] = EMPTY;
                    hasBroken = true;
                }
            }
        }
        return hasBroken;
    }
    private static boolean canDoBreak(int x, int y){
        char value = kakao[x][y];
        if(value == EMPTY){
            return false;
        }
        return value == kakao[x + 1][y] 
            && value == kakao[x][y + 1] 
            && value == kakao[x + 1][y + 1];
    }
    private static void fallDown(int m, int n){
        for(int i = 0; i < n; i++){
            List<Character> arr = new ArrayList<>();
            for(int j = m - 1; j >= 0; j--){
                if(kakao[j][i] != EMPTY){
                    arr.add(kakao[j][i]);
                }
            }
            for(int j = 0 ; j < arr.size(); j++){
                kakao[m - j - 1][i] = arr.get(j);
            }
            for(int j = m - arr.size() - 1; j >= 0 ; j--){
                kakao[j][i] = EMPTY;
            }
        }
    }
    private static void changeBlock(int m, int n){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isBroken[i][j]){
                    kakao[i][j] = EMPTY;
                }
            }
        }
    }
}


/*
CCBDE
AAADE
AAABF
CCBBF

*/