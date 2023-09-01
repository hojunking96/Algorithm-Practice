class Solution {
    public int solution(String A, String B) {
        if(A.equals(B)){
            return 0;
        }
        for(int i = 1; i < A.length(); i++){
            String newString = A.substring(A.length() - i, A.length()) + A.substring(0, A.length() - i);
            if(newString.equals(B)){
                return i;
            }
        }
        return -1;
    }
}