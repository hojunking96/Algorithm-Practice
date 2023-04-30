import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> arr = new ArrayList<>();
        for(String e : strArr){
            if(!e.contains("ad")){
                arr.add(e);
            }
        }
        return arr.toArray(new String[arr.size()]);
    }
}