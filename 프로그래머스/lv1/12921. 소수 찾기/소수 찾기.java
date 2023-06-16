class Solution {
    
    private boolean[] isNotPrime;
    
    public int solution(int n) {
        int answer = 0;
        
        isNotPrime = new boolean[n + 1];
        findPrime(n);
        for(int i = 2; i<=n; i++){
            if(!isNotPrime[i]){
                answer++;
            }
        }
        return answer;
    }
    
    private void findPrime(int n){
        for(int i = 2; i <= n; i++){
            if(!isNotPrime[i]){
                for(int j = i + i; j <= n; j += i){
                    isNotPrime[j] = true;
                }
            }
        }
    }
    
}