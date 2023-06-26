import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> APq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> BPq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < A.length; i++) {
            APq.add(A[i]);
            BPq.add(B[i]);
        }

        int answer = 0;
        while (!APq.isEmpty()) {
            int aNum = APq.poll();
            int bNum = BPq.peek();
            if (aNum < bNum) {
                BPq.poll();
                answer++;
            }
        }
        return answer;
    }
}