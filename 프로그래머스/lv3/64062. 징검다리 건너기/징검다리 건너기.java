import java.util.*;

class Solution {
    
    public int solution(int[] stones, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int start = 0;
        int end = 0;
        int[] ans = new int[stones.length - k + 1];
        int index = 0;

        while(end < stones.length) {

            while(deque.size() > 0 && stones[end] > deque.getLast()) {
                deque.removeLast();
            }

            deque.addLast(stones[end]);

            if(end - start + 1 < k) {
                end++;
            }
            else {

                ans[index++] = deque.getFirst();
                
                if(stones[start] == deque.getFirst()) {
                    deque.removeFirst();
                }
                start++;
                end++;
            }
        }
        Arrays.sort(ans);
        return ans[0];
    }
}