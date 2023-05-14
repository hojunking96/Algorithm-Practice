import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] answer = myString.split("x");
        List<String> tmp = new ArrayList<>();
        for(String e : answer){
            if(!e.equals("")){
                tmp.add(e);
            }
        }
        Collections.sort(tmp);
        return tmp.toArray(new String[tmp.size()]);

    }
}