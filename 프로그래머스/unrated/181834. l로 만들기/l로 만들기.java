class Solution {
    public String solution(String myString) {
        String answer = "";
        char[] tmp = myString.toCharArray();
        for(int i = 0 ; i < tmp.length; i++){
            if(tmp[i] < 'l' && tmp[i] >= 'a'){
                tmp[i] = 'l';
            }
        }
        for(char e : tmp){
            answer += e;
        }
        return answer;
    }
}