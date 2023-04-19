class Solution{
    
    public int solution(int n, int a, int b){
        int round = 1;
        int k = 2;
        a--;
        b--;
        while(a / k != b / k){
            k *= 2;
            round++;
        }
        return round;
    }
}