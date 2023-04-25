import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] sChar = s.toCharArray();
        for (int i = 0; i < sChar.length; i++) {
            rotate(sChar);
            if (isRight(sChar)) {
                answer++;
            }
        }
        return answer;
    }

    private static void rotate(char[] sChar) {
        char tmp = sChar[0];
        for (int i = 0; i < sChar.length - 1; i++) {
            sChar[i] = sChar[i + 1];
        }
        sChar[sChar.length - 1] = tmp;
    }

    private static boolean isRight(char[] sChar) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sChar.length; i++) {
            char value = sChar[i];
            switch (value) {
                case '(':
                    stack.push(value);
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                    return false;
                case '{':
                    stack.push(value);
                    break;
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.peek() == '{') {
                        stack.pop();
                        break;
                    }
                    return false;

                case '[':
                    stack.push(value);
                    break;
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.peek() == '[') {
                        stack.pop();
                        break;
                    }
                    return false;

            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}