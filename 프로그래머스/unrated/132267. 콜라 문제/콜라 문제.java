class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(true){
            int newCokes = n / a * b;
            answer += newCokes;
            n = n % a + newCokes;
            if(n < a){
                break;
            }
        }
        return answer;
    }
}