import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];
        
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for(int i = len - 1; i >= 0; i--){
            while(!stack.isEmpty()){
                if(stack.peek() > numbers[i]){
                    answer[i] = stack.peek();
                    stack.add(numbers[i]);
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()){
                answer[i] = -1;
                stack.add(numbers[i]);
            }
        }
        return answer;
    }
}