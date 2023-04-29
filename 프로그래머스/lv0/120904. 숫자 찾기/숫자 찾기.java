class Solution {
    public int solution(int num, int k) {
        String e = "" + num;
        int answer = -1;
        for(int i = 0; i < e.length(); i++){
            if(e.charAt(i) == k + '0'){
                answer = i + 1;
                break;
            }
        }
        return answer;
    }
}