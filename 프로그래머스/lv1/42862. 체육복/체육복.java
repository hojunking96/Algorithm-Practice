import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int cnt = 0;

        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < lost.length; i++) {
            set1.add(lost[i]);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < reserve.length; i++) {
            int v = reserve[i];
            if (set1.contains(v)) {
                set1.remove(v);
                continue;
            }
            set2.add(reserve[i]);
        }

        for (int no : set1) {
            if (set2.contains(no - 1)) {
                set2.remove(no - 1);
            } else if (set2.contains(no + 1)) {
                set2.remove(no + 1);
            } else {
                cnt++;
            }
        }
        return n - cnt;
    }
}