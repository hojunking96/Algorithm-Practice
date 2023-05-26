class Solution {
    public String solution(String s) {
        String answer = "";
        int cnt = 0;
        for(int i = 0; i < s.length(); i++, cnt++){
            char tmp = s.charAt(i);
            if(cnt % 2 == 0 && tmp >= 'a' && tmp <= 'z'){
                answer += (char)(tmp - 32);
            }
            else if(cnt % 2 == 1 && tmp >= 'A' && tmp <= 'Z'){
                answer += (char)(tmp + 32);
            }
            else{
                answer += tmp;
                if(tmp == ' '){
                    cnt = -1;
                }
            }
        }
        return answer;
    }
}