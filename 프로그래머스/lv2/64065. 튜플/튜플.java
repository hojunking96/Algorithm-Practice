import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        
        s = s.substring(2, s.length()-2);
        
        String[] strArr = s.split("\\},\\{");
        
        int len = strArr.length;
        String[] sortedStrArr = new String[len];
        int[] answer = new int[len];
        
        for(String e : strArr){
            String[] numArr = e.split(",");
            sortedStrArr[numArr.length - 1] = e; 
        }
        for(int i = 0; i < len; i++){
            String[] numArr = sortedStrArr[i].split(",");
            for(String e : numArr){
                if(!set.contains(e)){
                    set.add(e);
                    answer[i] = Integer.parseInt(e);
                    break;
                }
            }
        }
        return answer;
    }
}