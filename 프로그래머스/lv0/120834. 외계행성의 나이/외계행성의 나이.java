class Solution {
    public String solution(int age) {
        String answer = "";
        String tmp = "" + age;
        for(int i = 0; i < tmp.length(); i++){
            int k = (tmp.charAt(i) - '0' + 'a');
            answer += "" + (char)k;
        }
        return answer;
    }
}