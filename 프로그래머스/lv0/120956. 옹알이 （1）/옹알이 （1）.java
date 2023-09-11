class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] arr = {"aya", "ye", "woo", "ma"};
        for(String e : babbling){
            for(String x : arr){
                e = e.replaceAll(x, " ");
            }
            e = e.replaceAll(" ", "");
            if(e.equals("")){
                answer++;
            }
        }
        return answer;
    }
}