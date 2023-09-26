import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] cnt = new int[id_list.length];
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < id_list.length; i++){
            map.put(id_list[i], i);
        }
        
        Set<String> set = new HashSet<>();
        for(String e : report){
            set.add(e);
        }
        for(String e : set){
            String accusedName = e.split(" ")[1];
            cnt[map.get(accusedName)]++;
        }
        for(String e : set){
            String accusedName = e.split(" ")[1];
            String tmp2 = e.split(" ")[0];
            if(cnt[map.get(accusedName)] >= k){
                answer[map.get(tmp2)]++;
            }
        }
        return answer;
    }
}