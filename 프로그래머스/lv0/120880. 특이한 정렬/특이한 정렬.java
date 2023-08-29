import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        return Arrays.stream(numlist).boxed()
                    .sorted(((o1, o2) -> {
                        int diff1 = Math.abs(o1 - n);
                        int diff2 = Math.abs(o2 - n);
                        if (diff1 == diff2) {
                            return o2 - o1;
                        }
                        return diff1 - diff2;
                    }))
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}