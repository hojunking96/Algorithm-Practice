class Solution {
    public String solution(String[] str_list, String ex) {
        String answer = "";
        for(String e : str_list){
            if(e.contains(ex)){
                continue;
            }
            answer += e;
        }
        return answer;
    }
}