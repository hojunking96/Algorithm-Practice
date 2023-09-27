import java.util.*;

class Solution {
    
    private int max = -1;
    
    public String solution(String number, int k) {
        int cnt = 0;
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < number.length(); i++){
            char e = number.charAt(i);
            while(!stack.isEmpty() && stack.peek() < e && cnt < k){
                stack.pop();
                cnt++;
            }
            stack.push(e);
        }
        while(!stack.isEmpty()){
            answer = stack.pop() + answer;
        }
        answer = answer.substring(0, number.length() - k);
        return answer;
    }
}

/*
0~k까지

*/