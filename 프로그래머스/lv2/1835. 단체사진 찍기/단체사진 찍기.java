import java.util.*;

class Solution {
    
    private String[] members = {"A", "C", "F", "J", "M", "N", "R", "T"};
    private int cnt = 0;
    
    public int solution(int n, String[] data) {
        dd("", data);
        return cnt;
    }
    
    private void dd(String line, String[] data){
        if(line.length() == 8){
            if(check(line, data)){
                cnt++;
            }
            return;
        }
        for(int i = 0; i < 8; i++){
            if(!line.contains(members[i])){
                line += members[i];
                dd(line, data);
                line = line.substring(0, line.length() - 1);
            }
        }
    }
    
    private boolean check(String line, String[] data){
        for(String expression : data){
            String v1 = expression.substring(0, 1);
            String v2 = expression.substring(2, 3);
            String func = expression.substring(3, 4);
            int amount = Integer.parseInt(expression.substring(4, 5)) + 1;
            
            int idx1 = line.indexOf(v1);
            int idx2 = line.indexOf(v2);
            int diff = Math.abs(idx1 - idx2);
            if(func.equals("=")){
                if(diff != amount){
                    return false;
                }
            }
            else if(func.equals("<")){
                if(diff >= amount){
                    return false;
                }
            }
            else{
                if(diff <= amount){
                    return false;
                }
            }
        }
        return true;
    }
}

/*
A, C, F, J, M, N, R, T 총 8개
간격 : 0 ~ 6 (나란히 있는 경우 : 0)
경우의 수 계산

완탐하면 오래걸리겠지?


*/