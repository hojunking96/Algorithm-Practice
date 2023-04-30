class Solution {
    public String solution(String n_str) {
        int ptr = 0;
        while(n_str.charAt(ptr) == '0'){
            ptr++;
        }
        return n_str.substring(ptr);
    }
}