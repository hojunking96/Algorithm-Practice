class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for(int i = 0 ; i < s.length(); i++){
            char tmp = s.charAt(i);
            if(tmp >= 'a' && tmp <= 'z'){
                answer += (char)((tmp - 'a' + n) % 26 + 'a');
            }
            else if(tmp >= 'A' && tmp <= 'Z'){
                answer += (char)((tmp - 'A' + n) % 26 + 'A');
            }
            else{
                answer += tmp;
            }
        }
        return answer;
    }
}