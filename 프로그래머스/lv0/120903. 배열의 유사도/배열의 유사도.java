class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for(String e : s1){
            for(String d : s2){
                if(e.equals(d)){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}