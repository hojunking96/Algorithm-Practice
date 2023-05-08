import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> arr = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        int index;

        for (index = 1; index <= 26; index++) {
            map.put("" + (char) ('A' + index - 1), index);
        }
        for (int i = 0; i < msg.length(); i++) {
            String key = "" + msg.charAt(i);
            int num = 0;
            
            
            while (map.containsKey(key)) {
                i++;
                num = map.get(key);
                if (i == msg.length()) {
                    break;
                }
                key += msg.charAt(i);
            }
            map.put(key, index++);
            arr.add(num);
            i--;
            if (i == msg.length() - 1) {
                break;
            }
        }
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}