import java.util.*;

class Solution{
    
    public int solution(String s){
        Stack<Character> stack = new Stack<>();
        int ptr = 0;

        while(ptr < s.length()){
            while(!stack.isEmpty() && ptr < s.length() 
                  && stack.peek() == s.charAt(ptr)){
                stack.pop();
                ptr++;
            }
            if(ptr == s.length()){
                break;
            }
            stack.push(s.charAt(ptr++));
        }
        if(stack.isEmpty()){
            return 1;
        }
        return 0;
    }
}