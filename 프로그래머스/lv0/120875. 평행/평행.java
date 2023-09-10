class Solution {
    public int solution(int[][] dots) {
        if(check(dots[0], dots[1], dots[2], dots[3])
          || check(dots[1], dots[2], dots[3], dots[0])
          || check(dots[2], dots[3], dots[0], dots[1])
          || check(dots[3], dots[0], dots[1], dots[2])){
            return 1;
        }
        return 0;
    }
    
    private boolean check(int[] dot1, int[] dot2, int[] dot3, int[] dot4){
        if(getValue(dot1, dot2) == getValue(dot3, dot4)
          || getValue(dot1, dot2) == getValue(dot4, dot3)){
            return true;
        }
        return false;
    }
    
    private double getValue(int[] dot1, int[] dot2){
        return (double)(Math.abs(dot1[0] - dot2[0])) / Math.abs(dot1[1] - dot2[1]);
    }
}