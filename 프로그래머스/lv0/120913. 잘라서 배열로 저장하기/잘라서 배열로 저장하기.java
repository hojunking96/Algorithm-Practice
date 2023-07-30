class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[(my_str.length() - 1) / n + 1];
        int start = 0;
        int idx = 0;
        for(int i = n; i < my_str.length(); i += n){
            answer[idx++] = my_str.substring(start, i);
            start = i;
        }
        if(start != my_str.length()){
            answer[idx] = my_str.substring(start, my_str.length());
        }
        return answer;
    }
}