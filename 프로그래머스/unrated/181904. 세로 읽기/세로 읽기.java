class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        for(int i = c ; i <= my_string.length() ; i += m){
            answer += my_string.charAt(i - 1);
        }
        return answer;
    }
}