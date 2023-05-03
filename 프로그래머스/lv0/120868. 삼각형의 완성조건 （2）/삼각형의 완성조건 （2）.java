class Solution {
    public int solution(int[] sides) {
        int diff = Math.abs(sides[0] - sides[1]);
        int sum = sides[0] + sides[1];
        int answer = 0;
        for(int i = diff + 1; i < sum ; i++){
            answer++;
        }        
        return answer;
    }
}