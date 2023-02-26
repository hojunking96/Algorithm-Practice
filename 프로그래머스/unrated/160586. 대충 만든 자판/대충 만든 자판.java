class Solution {
    private static int n,n2;
    private static int[] m;
    private static int[] cnt;
  
    public int[] solution(String[] keymap, String[] targets) {
        n = keymap.length;
        n2 = targets.length;
        m = new int[n];
        int t = 3;
        cnt = new int[n2];
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                int min = 200;
                for (String e : keymap) {
                    min = Math.min(min, find(e, targets[i].charAt(j)));
                }
                if (min == 200) {
                    cnt[i] = -1;
                    break;
                }
                cnt[i] += min;
            }
        }
        return cnt;
    }

    private static int find(String key, char target) {
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i) == target) {
                return i + 1;
            }
        }
        return 200;
    }
}
