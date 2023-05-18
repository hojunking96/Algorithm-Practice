import java.util.*;

class Solution {
    
    private static boolean[] isOnSub;
    
    public int solution(int[] order) {
        int length = order.length;
        
        Queue<Integer> q = new LinkedList<>();        
        for(int i = 1; i <= length; i++){
            q.add(i);
        }
        isOnSub = new boolean[length + 1];
        Stack<Integer> stack = new Stack<>();
        
        int cnt = 0;
        for(int e : order){
            if(isOnSub[e]){
                if(stack.peek() != e){
                    return cnt;
                }
                stack.pop();
                cnt++;
                continue;
            }
            //컨테이너에 있을 때
            while(!q.isEmpty()){
                int now = q.poll();
                if(now == e){
                    cnt++;
                    break;
                }
                stack.push(now);
                isOnSub[now] = true;
            }
        }
        
        return cnt;
    }
}
