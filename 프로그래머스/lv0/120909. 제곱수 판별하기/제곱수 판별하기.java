
class Solution {
    public int solution(int n) {
        int answer = 2;
        int t = (int)Math.sqrt(n);
        if(t*t==n){
            answer=1;
        }
        return answer;
    }
}