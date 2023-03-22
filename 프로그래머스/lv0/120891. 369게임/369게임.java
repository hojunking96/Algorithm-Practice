class Solution {
    public int solution(int order) {
        int answer = 0;
        String k = ""+order;
        for(int i=0;i<k.length();i++){
            if(k.charAt(i)=='3'||k.charAt(i)=='6'||k.charAt(i)=='9'){
                answer++;
            }
        }
        return answer;
    }
}