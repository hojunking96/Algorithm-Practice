class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        return calc2(calc1(x1, x2), calc1(x3, x4));
    }
    private boolean calc1(boolean a, boolean b){
        return a || b;
    }
    
    private boolean calc2(boolean a, boolean b){
        return a && b;
    }
}