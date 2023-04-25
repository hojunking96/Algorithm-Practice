import java.util.*;

class Solution {
    boolean solution(String s) {
        char[] arr = s.toCharArray();
        Stack <Character> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '('){
                stack.push('(');
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    
}