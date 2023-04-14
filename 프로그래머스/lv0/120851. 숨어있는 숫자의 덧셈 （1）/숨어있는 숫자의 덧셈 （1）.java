class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(int i=0;i<my_string.length();i++){
            char k = my_string.charAt(i);
            if(k>='0'&&k<='9'){
                answer += Integer.parseInt(String.valueOf(k));
            }
        }
        return answer;
    }
}