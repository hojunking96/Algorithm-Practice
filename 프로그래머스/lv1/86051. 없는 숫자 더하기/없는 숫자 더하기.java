class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        for(int e : numbers){
            answer += e;
        }
        
        return 45 - answer;
    }
}