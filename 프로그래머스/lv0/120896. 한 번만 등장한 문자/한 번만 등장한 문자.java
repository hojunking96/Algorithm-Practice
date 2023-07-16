import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        Map <String, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            String e = "" + s.charAt(i);
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        
        List<String> strArr = new ArrayList<>();
        for(String e : map.keySet()){
            if(map.get(e) == 1){
                strArr.add(e);
            }
        }
        Collections.sort(strArr);
        for(String e : strArr){
            answer += e;
        }
        return answer;
    }
}