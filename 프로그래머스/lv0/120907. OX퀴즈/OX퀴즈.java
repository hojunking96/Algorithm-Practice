import java.util.*;

class Solution {
    public String[] solution(String[] quiz) {
        List<String> arr = new ArrayList<>();
        for(String e : quiz){
            if(e.contains(" - ")){
                String[] tmps = e.split(" - | = ");
                int num1 = Integer.parseInt(tmps[0]);
                int num2 = Integer.parseInt(tmps[1]);
                int result = Integer.parseInt(tmps[2]);
                if(num1 - num2 == result){
                    arr.add("O");
                    continue;
                }
                arr.add("X");
                continue;
            }
            String[] tmps = e.split(" \\+ | = ");
            int num1 = Integer.parseInt(tmps[0]);
            int num2 = Integer.parseInt(tmps[1]);
            int result = Integer.parseInt(tmps[2]);
            if(num1 + num2 == result){
                arr.add("O");
                continue;
            }
            arr.add("X");
            continue;
        }
        return arr.toArray(new String[0]);
    }
}