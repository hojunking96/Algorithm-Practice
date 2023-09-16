class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int end = 0;
        for(int e : section){
            if(e >= end){
                end = e + m;
                answer++;
            }
        }
        return answer;
    }
}