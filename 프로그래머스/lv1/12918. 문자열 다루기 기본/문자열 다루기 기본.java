class Solution {
    public boolean solution(String s) {
        int len = s.length();
        if(len != 4 && len != 6){
            return false;
        }
        return s.matches("^[0-9]*$");
    }
}