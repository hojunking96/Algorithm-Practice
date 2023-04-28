class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        char c1 = my_string.charAt(num1);
        char c2 = my_string.charAt(num2);
        for(int i = 0; i < my_string.length(); i++){
            if(i == num1){
                answer += c2;
                continue;
            }
            if(i == num2){
                answer += c1;
                continue;
            }
            answer += my_string.charAt(i);
        }
        return answer;
    }
}