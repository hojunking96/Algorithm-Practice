class Solution {
    public int solution(int M, int N) {
        if(M > N){
            return N * (M - 1) + (N - 1);
        }
        else{
            return M * (N - 1) + (M - 1);
        }
    }
}